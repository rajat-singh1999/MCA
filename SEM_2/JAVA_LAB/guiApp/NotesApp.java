import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class NotesApp extends JFrame {
    private static final String DB_URL = "jdbc:sqlite:notes.db";
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT)";
    private static final String CREATE_NOTES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS notes (username TEXT, note TEXT)";

    private JPanel pnlLogin;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnLogout;

    private JPanel pnlNotes;
    private JList<String> lstNotes;
    private JScrollPane scrollPane;
    private JTextArea txtAreaNote;
    private JButton btnCreateNote;
    private JButton btnEditNote;
    private JButton btnDeleteNote;

    private String currentUsername;

    public NotesApp() {
        super("Notes App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        pnlLogin = new JPanel(new GridLayout(3, 2));
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        btnLogout = new JButton("Logout");

        pnlLogin.add(lblUsername);
        pnlLogin.add(txtUsername);
        pnlLogin.add(lblPassword);
        pnlLogin.add(txtPassword);
        pnlLogin.add(btnLogin);
        pnlLogin.add(btnLogout);

        pnlNotes = new JPanel(new BorderLayout());
        lstNotes = new JList<>();
        scrollPane = new JScrollPane(lstNotes);
        txtAreaNote = new JTextArea();
        btnCreateNote = new JButton("Create Note");
        btnEditNote = new JButton("Edit Note");
        btnDeleteNote = new JButton("Delete Note");

        pnlNotes.add(scrollPane, BorderLayout.CENTER);
        pnlNotes.add(txtAreaNote, BorderLayout.SOUTH);
        pnlNotes.add(btnCreateNote, BorderLayout.EAST);
        pnlNotes.add(btnEditNote, BorderLayout.WEST);
        pnlNotes.add(btnDeleteNote, BorderLayout.NORTH);

        add(pnlLogin, BorderLayout.NORTH);
        add(pnlNotes, BorderLayout.CENTER);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if (login(username, password)) {
                    currentUsername = username;
                    showNotes();
                    clearLoginForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUsername = null;
                clearNotes();
                clearLoginForm();
            }
        });

        btnCreateNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUsername != null) {
                    String note = txtAreaNote.getText();
                    if (!note.isEmpty()) {
                        saveNoteToDatabase(currentUsername, note);
                        showNotes();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please login to create a note", "Login Required", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnEditNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUsername != null) {
                    int selectedIndex = lstNotes.getSelectedIndex();
                    if (selectedIndex != -1) {
                        String existingNote = lstNotes.getSelectedValue();
                        String updatedNote = txtAreaNote.getText();
                        if (!updatedNote.isEmpty()) {
                            updateNoteInDatabase(currentUsername, existingNote, updatedNote);
                            showNotes();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please login to edit a note", "Login Required", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnDeleteNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUsername != null) {
                    int selectedIndex = lstNotes.getSelectedIndex();
                    if (selectedIndex != -1) {
                        String noteToDelete = lstNotes.getSelectedValue();
                        deleteNoteFromDatabase(currentUsername, noteToDelete);
                        showNotes();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please login to delete a note", "Login Required", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        createTablesIfNotExist();
    }

    private void createTablesIfNotExist() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(CREATE_TABLE_QUERY);
            stmt.executeUpdate(CREATE_NOTES_TABLE_QUERY);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean login(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveNoteToDatabase(String username, String note) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO notes (username, note) VALUES (?, ?)")) {

            stmt.setString(1, username);
            stmt.setString(2, note);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateNoteInDatabase(String username, String existingNote, String updatedNote) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("UPDATE notes SET note = ? WHERE username = ? AND note = ?")) {

            stmt.setString(1, updatedNote);
            stmt.setString(2, username);
            stmt.setString(3, existingNote);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteNoteFromDatabase(String username, String note) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM notes WHERE username = ? AND note = ?")) {

            stmt.setString(1, username);
            stmt.setString(2, note);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showNotes() {
        if (currentUsername != null) {
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement stmt = conn.prepareStatement("SELECT note FROM notes WHERE username = ?")) {

                stmt.setString(1, currentUsername);

                ResultSet rs = stmt.executeQuery();
                DefaultListModel<String> notesModel = new DefaultListModel<>();
                while (rs.next()) {
                    String note = rs.getString("note");
                    notesModel.addElement(note);
                }
                lstNotes.setModel(notesModel);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            clearNotes();
        }
    }

    private void clearNotes() {
        lstNotes.setModel(new DefaultListModel<>());
        txtAreaNote.setText("");
    }

    private void clearLoginForm() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotesApp().setVisible(true);
            }
        });
    }
}
