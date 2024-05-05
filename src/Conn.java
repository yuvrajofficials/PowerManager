

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    // Host: sql6.freesqldatabase.com
    // Database name: sql6700618
    // Database user: sql6700618
    // Database password: HZULxPaZqR
    // Port number: 3306


    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///powermanager", "root", "User@2026");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
