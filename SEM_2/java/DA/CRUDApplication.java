import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CRUDApplication extends JFrame {
    private JLabel nameLabel, ageLabel, genderLabel;
    private JTextField nameField, ageField, genderField;
    private JButton addButton, updateButton, deleteButton, viewButton;

    private Connection connection;
    private Statement statement;

    public CRUDApplication() {
        initializeDatabase();
        createUI();
        bindActions();
    }

    private void initializeDatabase() {
        try {
            // Establish the connection with the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

            // Create a statement object
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createUI() {
        // Set frame properties
        setTitle("CRUD Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels
        nameLabel = new JLabel("Name:");
        ageLabel = new JLabel("Age:");
        genderLabel = new JLabel("Gender:");

        // Create text fields
        nameField = new JTextField();
        ageField = new JTextField();
        genderField = new JTextField();

        // Create buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        viewButton = new JButton("View");

        // Create panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(viewButton);

        // Add panel to the frame
        add(panel);

        // Set frame visibility
        setVisible(true);
    }

    private void bindActions() {
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = genderField.getText();

                // Insert record into the database
                try {
                    statement.executeUpdate("INSERT INTO patients (name, age, gender) VALUES ('" + name + "', " + age + ", '" + gender + "')");
                    JOptionPane.showMessageDialog(null, "Record added successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = genderField.getText();

                // Update record in the database
                try {
                    statement.executeUpdate("UPDATE patients SET age=" + age + ", gender='" + gender + "' WHERE name='" + name + "'");
                    JOptionPane.showMessageDialog(null, "Record updated successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                // Delete record from the database
                try {
                    statement.executeUpdate("DELETE FROM patients WHERE name='" + name + "'");
                    JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch records from the database
                try {
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM patients");

                    StringBuilder records = new StringBuilder();
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String gender = resultSet.getString("gender");

                        records.append("Name: ").append(name).append(", Age: ").append(age).append(", Gender: ").append(gender).append("\n");
                    }

                    JOptionPane.showMessageDialog(null, records.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CRUDApplication();
            }
        });
    }
}

