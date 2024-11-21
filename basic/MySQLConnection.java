import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// compile -  javac -cp "mysql-connector-j-9.1.0.jar" MySQLConnection.java
// run -  java -cp ".;mysql-connector-j-9.1.0.jar" MySQLConnection

public class MySQLConnection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String password = "hema@23";
        // Connection object
        Connection connection = null;
        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
}