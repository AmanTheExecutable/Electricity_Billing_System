import java.sql.*;

public class Conn {
    Connection c; // connection object to connect to the database
    Statement s; // statement object to execute queries

    Conn() {
        // create the connection
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver"); // load the driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebsystem", "root", "root");
            s = c.createStatement(); // create statement object to execute queries
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}