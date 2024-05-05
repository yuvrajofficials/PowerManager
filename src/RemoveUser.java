

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveUser extends JFrame implements ActionListener {
    
    Choice cmeternumber;
    JButton delete, back;
    
    RemoveUser() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.png"));
        Image i2 = i1.getImage().getScaledInstance(1720, 900, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1420, 830);
        add(image);

        // ImageIcon docimg = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        // Image docimg2 = docimg.getImage().getScaledInstance(220, 500, Image.SCALE_REPLICATE);
        // ImageIcon docimg3 = new ImageIcon(docimg2);
        // JLabel image = new JLabel(docimg3);
        // image.setBounds(0, 0, 1420, 830);
        // add(image);

        
        JLabel removeheading = new JLabel("Remove User Details");
        removeheading.setBounds(320, 30, 500, 50);
        removeheading.setForeground(Color.WHITE);
        removeheading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        image.add(removeheading);
        
        // JPanel framelog = new JPanel();
        // framelog.setBounds(15, 100, 500, 380);
        // framelog.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
        // framelog.setOpaque(false);        
        // image.add(framelog);
        
        
        JLabel meternumber = new JLabel("Meter Number");
        
        meternumber.setForeground(Color.WHITE);
        meternumber.setBounds(50, 150, 100, 30);
        image.add(meternumber);
        
        cmeternumber = new Choice();
        cmeternumber.setBounds(200, 150, 150, 30);
        
        cmeternumber.setForeground(Color.BLACK);
        image.add(cmeternumber);
        
        try {
            Conn c = new Conn();
            String query = "select * from users";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cmeternumber.add(rs.getString("meternumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name    :");
        labelname.setBounds(50, 200, 100, 30);
    
        labelname.setForeground(Color.WHITE);
        image.add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 200, 100, 30);
        
        lblname.setForeground(Color.WHITE);
        image.add(lblname);
        
        JLabel labelphone = new JLabel("Phone    :");
        
        labelphone.setForeground(Color.WHITE);
        labelphone.setBounds(50, 250, 100, 30);
       image.add(labelphone);
        
        JLabel lblphone = new JLabel();
        
        lblphone.setForeground(Color.WHITE);
        lblphone.setBounds(200, 250, 100, 30);
        image.add(lblphone);
        
        JLabel labelemail = new JLabel("Email     :");
        
        labelemail.setForeground(Color.WHITE);
        labelemail.setBounds(50, 300, 100, 30);
       image.add(labelemail);
        
        JLabel lblemail = new JLabel();
        
        lblemail.setForeground(Color.WHITE);
        lblemail.setBounds(200, 300, 100, 30);
       image.add(lblemail);
        
        try {
            Conn c = new Conn();
            String query = "select * from users where meternumber = '"+cmeternumber.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cmeternumber.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from users where meternumber = '"+cmeternumber.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(50, 350, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        image.add(delete);
        
        back = new JButton("Back");
        back.setBounds(190, 350, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        // ImageIcon d1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        // Image d2 = d1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        // ImageIcon d3 = new ImageIcon(d2);
        // JLabel imaged = new JLabel(d3);
        // imaged.setBounds(350, 0, 600, 400);
        // image.add(imaged);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from users where meternumber = '"+cmeternumber.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "User Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveUser();
    }
}
