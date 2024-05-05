import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;

// Custom panel to display a background image
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

public class ShowComp extends JFrame implements ActionListener {
    private Map<String, String[]> users = new HashMap<>();
    private DefaultTableModel model;
    private JButton backButton;
    
    public ShowComp() {
        // Set up the frame
        setTitle("User Complaints");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Set up the background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel("./icons/Background.png");
        backgroundPanel.setLayout(new BorderLayout());
        
        // Set the background panel as the content pane
        setContentPane(backgroundPanel);
        
        // Initialize the default table model
        model = new DefaultTableModel(new Object[]{"Name", "Phone", "Subject", "Message", "Priority"}, 0);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setOpaque(false); // Keep transparent to see background
        topPanel.add(backButton);
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false); // Keep transparent
        scrollPane.getViewport().setOpaque(false); // Keep transparent

        backgroundPanel.add(topPanel, BorderLayout.NORTH);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        // Load the data into the table
        loadData();

        setVisible(true); // Set frame visibility
    }

    private void loadData() {
        try {
            Conn conn = new Conn();

            // Example SQL query to update priorities
            String updateQuery = "UPDATE complaints SET priority = CASE " +
                "WHEN message REGEXP '\\bbill\\b|\\bpayment\\b|\\btariff\\b' THEN 3 " +
                "WHEN message REGEXP '\\bservice\\b|\\bmaintenance\\b|\\brestoration\\b' THEN 2 " +
                "WHEN message REGEXP '\\bmeter\\b|\\btransformer\\b|\\bvoltage\\b' THEN 1 " +
                "ELSE 6 END";
            conn.s.executeUpdate(updateQuery);

            // Fetch data from the database
            String query = "SELECT * FROM complaints";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String subject = rs.getString("subject");
                String message = rs.getString("message");
                String priority = rs.getString("priority");

                users.put(phone, new String[]{name, phone, subject, message, priority});
            }

            rs.close();

            createRowsByPriority(); // Load data into the table

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error accessing Database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createRowsByPriority() {
        // Add rows to the table in order of priority (0 through 6)
        for (String prio : Arrays.asList("0", "1", "2", "3", "4", "5", "6")) {
            for (Map.Entry<String, String[]> entry : users.entrySet()) {
                if (prio.equals(entry.getValue()[4])) {
                    model.addRow(new Object[]{entry.getValue()[0], entry.getValue()[1], entry.getValue()[2], entry.getValue()[3], entry.getValue()[4]});
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            // Define action for back button
            this.dispose(); // Close this frame
            new Home().setVisible(true); // Assuming 'Home' is another JFrame or similar
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShowComp().setVisible(true));
    }
}
