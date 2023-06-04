import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class NotesApp {
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextArea notesArea;
    private JButton loginButton;
    private JButton logoutButton;
    private JButton saveButton;
    private Connection connection;
    private String currentUser;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotesApp().initialize();
            }
        });
    }

    public void initialize() {
        frame = new JFrame("Notes App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Log In");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        panel.add(loginButton);

        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        panel.add(logoutButton);
        logoutButton.setEnabled(false);

        notesArea = new JTextArea();
        panel.add(new JScrollPane(notesArea));

        saveButton = new JButton("Save Notes");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveNotes();
            }
        });
        panel.add(saveButton);
        saveButton.setEnabled(false);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);

        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            // Modify the database URL, username, and password as per your configuration
            String url = "jdbc:mysql://localhost:3306/notes_db";
            String username = "your_username";
            String password = "your_password";

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void login() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        try {
            // Check if the user exists in the database
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                currentUser = email;
                loginButton.setEnabled(false);
                logoutButton.setEnabled(true);
                saveButton.setEnabled(true);

                // Load the user's notes
                loadNotes();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void logout() {
        currentUser = null;
        emailField.setText("");
        passwordField.setText("");
        notesArea.setText("");
        loginButton.setEnabled(true);
        logoutButton.setEnabled(false);
        saveButton.setEnabled(false);
    }

    private void saveNotes() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(frame, "Please log in to save notes", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String notes = notesArea.getText();

        try {
            // Update or insert the user's notes in the database
            PreparedStatement statement = connection.prepareStatement("INSERT INTO notes (email, notes) VALUES (?, ?) ON DUPLICATE KEY UPDATE notes=?");
            statement.setString(1, currentUser);
            statement.setString(2, notes);
            statement.setString(3, notes);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Notes saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadNotes() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(frame, "Please log in to load notes", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Retrieve the user's notes from the database
            PreparedStatement statement = connection.prepareStatement("SELECT notes FROM notes WHERE email=?");
            statement.setString(1, currentUser);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String notes = resultSet.getString("notes");
                notesArea.setText(notes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
