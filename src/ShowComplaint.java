import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;


public class ShowComplaint extends JFrame {

    Map<String, String[]> users = new HashMap<>();
    DefaultTableModel model = new DefaultTableModel(new Object[]{"Name", "Phone", "Subject","Message"}, 0);
    

    public ShowComplaint() {
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        try {
            // HashMap to store user data with phone number as the key

            Conn conn = new Conn();
            // Update priority in the database
            String query3 = "UPDATE complaints SET priority = CASE " +
                            "WHEN message REGEXP '\\bbill\\b|\\bpayment\\b|\\btariff\\b' THEN 3 " +
                            "WHEN message REGEXP '\\bservice\\b|\\bmaintenance\\b|\\brestoration\\b' THEN 2 " +
                            "WHEN message REGEXP '\\bmeter\\b|\\btransformer\\b|\\bvoltage\\b' THEN 1 " +
                            "ELSE 6 END " +
                            "WHERE message REGEXP '\\bservice\\b|\\bmaintenance\\b|\\brestoration\\b|\\bbill\\b|\\bpayment\\b|\\btariff\\b|\\bmeter\\b|\\btransformer\\b|\\bvoltage\\b';";
            conn.s.executeUpdate(query3);

            // Fetch data from the database
            String query = "SELECT * FROM complaints";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String subject = rs.getString("subject");
                String message = rs.getString("message");
                String priority = rs.getString("priority");

                // Using phone as key and array of details as value
                users.put(phone, new String[]{name, phone,subject,message,priority});
            }
            rs.close();
            // DefaultTableModel model = new DefaultTableModel(new Object[]{"Name", "Phone", "Message"}, 0);
          
         createRow("0");
         createRow("1");
         createRow("2");
         createRow("3");
         createRow("4");
         createRow("5");
         createRow("6");

            JTable table = new JTable(model);
      

            JScrollPane scrollPane = new JScrollPane(table);
          add(scrollPane, BorderLayout.CENTER);

            setTitle("User Table");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error accessing Database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createRow(String prio){

        for (Map.Entry<String, String[]> entry : users.entrySet()) {
            if (prio.equals(entry.getValue()[4])) {
                model.addRow(new Object[]{entry.getValue()[0], entry.getValue()[1], entry.getValue()[2], entry.getValue()[3]});
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShowComplaint().setVisible(true));
    }
}
