
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashMap;

public class ShowComplaints extends JFrame {
    public ShowComplaints() {
        
       

        try {

            HashMap<String, String> users = new HashMap<>();
 
            // Adding elements to the Map
            // using standard put() method
            // map.put("vishal", 10);
            // map.put("sachin", 30);
            // map.put("vaibhav", 20);
            Conn conn = new Conn();
            String query3 = "UPDATE complaints \n" +
            "SET priority = \n" +
            "  CASE \n" +
            "   WHEN message REGEXP '\\\\bbill\\\\b|\\\\bpayment\\\\b|\\\\btariff\\\\b' THEN 3 \n" +
            "    WHEN message REGEXP '\\\\bservice\\\\b|\\\\bmaintenance\\\\b|\\\\brestoration\\\\b' THEN 2 \n" +
            "    WHEN message REGEXP '\\\\bmeter\\\\b|\\\\btransformer\\\\b|\\\\bvoltage\\\\b' THEN 1 \n" +
            "    ELSE 6 \n" +
            "  END \n" +
            "WHERE message REGEXP '\\\\bservice\\\\b|\\\\bmaintenance\\\\b|\\\\brestoration\\\\b|\\\\bbill\\\\b|\\\\bpayment\\\\b|\\\\btariff\\\\b|\\\\bmeter\\\\b|\\\\btransformer\\\\b|\\\\bvoltage\\\\b';";
            
            
            conn.s.executeUpdate(query3);

            String query = "SELECT * FROM complaints"; // Modify as needed
            ResultSet rs = conn.s.executeQuery(query);

            

            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String city = rs.getString("message");
                String priority = rs.getString("priority");

                String val = name+phone+city;
                users.put(priority,val);
            }

            rs.close();

            
 System.out.println(users);
            // // Create a JTable with the sorted user data
            // DefaultTableModel model = new DefaultTableModel(new Object[]{"Name", "Phone", "City"}, 0);
   
           

            // JTable table = new JTable(model);
            // JScrollPane scrollPane = new JScrollPane(table);

            // add(scrollPane, BorderLayout.CENTER);

            // setTitle("User Table");
            // setSize(400, 200);
            // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ShowComplaints();
    }
}
