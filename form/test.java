import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root"; // Your MySQL username
        String password = "hema@23"; // Your MySQL password

        Connection c = null;

        try {
            // Connect to the database
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // SQL query to insert data into the 'hema' table
            String insertQuery2 = "INSERT INTO hema (name) VALUES ('Hema')";
            String insertQuery3 = "INSERT INTO hema (name) VALUES ('Hema shah')";
            String insertQuery4 = "INSERT INTO hema (name) VALUES ('?')";
            // Create a Statement object
            Statement stmt = c.createStatement();

            
            // Execute the query
            stmt.executeUpdate(insertQuery2);
            stmt.executeUpdate(insertQuery3);
            stmt.executeUpdate(insertQuery4);


            // Close the connection
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
