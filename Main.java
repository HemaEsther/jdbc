// // Import JDBC classes
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

// public class MySQLExample {
//     public static void main(String[] args) {
//         // Step 1: Set database details
//         String url = "jdbc:mysql://localhost:3306/movie"; // Database URL
//         String user = "root";                              // Your MySQL username
//         String password = "hema@23";                  // Your MySQL password

//         // Step 2: Connect to the database
//         try (Connection conn = DriverManager.getConnection(url, user, password);
//              Statement stmt = conn.createStatement()) {

//             // Step 3: Execute a query
//             String query = "SELECT * FROM students"; // Example query
//             ResultSet rs = stmt.executeQuery(query);

//             // Step 4: Process the results
//             while (rs.next()) {
//                 int id = rs.getInt("id");          // Get "id" column
//                 String name = rs.getString("name"); // Get "name" column
//                 System.out.println("ID: " + id + ", Name: " + name);
//             }

//         } catch (Exception e) {
//             e.printStackTrace(); // Print errors if any
//         }
//     }
// }


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

// java -cp "bin:/Users/faizan/Desktop/Java-Mysql/form/lib/mysql-connector-j-9.1.0.jar" Main
 
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel genderLabel = new JLabel("Gender:");
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String gender = (String) genderComboBox.getSelectedItem();

       
                try (Connection connection = DatabaseConnection.getConnection()) {
                    String query = "INSERT INTO users (name, email, password, gender) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, gender);
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(frame,
                            "Data inserted successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Failed to insert data: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                genderComboBox.setSelectedIndex(0);
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(genderLabel);
        frame.add(genderComboBox);
        frame.add(submitButton);
        frame.add(resetButton);

        frame.setVisible(true);
    }
}
