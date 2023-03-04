import java.sql.*;

public class connection {
    Connection c;
    Statement s;

    connection() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "781416");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
