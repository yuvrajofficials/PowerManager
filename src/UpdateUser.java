
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateUser extends JFrame implements ActionListener{
    
    JTextField tfname,tfcity, tfphone, tfaddress, tfemail, tfmeternumber, tfstate;
    JLabel lblusersId,labelmtrnumber;
    JButton add, back;
    String usersId;
    
    UpdateUser() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.usersId = usersId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.png"));
        Image i2 = i1.getImage().getScaledInstance(1720, 900, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1420, 830);
        add(image);


        JPanel framelog = new JPanel();
        framelog.setBounds(15, 100, 600, 580);
        framelog.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
        framelog.setOpaque(false);        
        image.add(framelog);
        
        
        JLabel heading = new JLabel("Update users Detail");
        heading.setBounds(150, 30, 300, 50);
        heading.setForeground(Color.WHITE);

        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        image.add(heading);
        
        
        JLabel labelmeternumber = new JLabel("Meter Number :");
        labelmeternumber.setBounds(50, 150, 150, 30);
        labelmeternumber.setForeground(Color.WHITE);
        labelmeternumber.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelmeternumber);
        
        tfmeternumber = new JTextField();
        tfmeternumber.setBounds(200, 150, 300, 30);
       image.add(tfmeternumber);
        
      
        JLabel labelcity = new JLabel("City :");
        labelcity.setForeground(Color.WHITE);

        labelcity.setBounds(50, 220, 150, 30);
        labelcity.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(200, 220, 300, 30);
        image.add(tfcity);
        
        JLabel labelstate = new JLabel("State :");
        labelstate.setBounds(50, 290, 150, 30);
        labelstate.setForeground(Color.WHITE);
        labelstate.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(200, 290, 300, 30);
        image.add(tfstate);
     
            
        JLabel labelphone = new JLabel("Phone :");
        labelphone.setForeground(Color.WHITE);
        labelphone.setBounds(50, 360, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 360, 300, 30);
        image.add(tfphone);
        
        JLabel labelemail = new JLabel("Email :");
        labelemail.setForeground(Color.WHITE);

        labelemail.setBounds(50, 430, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
       image.add(labelemail);

       tfemail = new JTextField();
       tfemail.setBounds(200, 430, 300, 30);
      image.add(tfemail);

       JLabel labeladdress = new JLabel("Address :");
       labeladdress.setForeground(Color.WHITE);

       labeladdress.setBounds(50, 500, 150, 30);
       labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
      image.add(labeladdress);
       
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 500, 300, 30);
       image.add(tfaddress);
        
        
        // JLabel labelmtrnumber = new JLabel("Name :");
        // labelmtrnumber.setBounds(50, 400, 150, 30);
        // labelmtrnumber.setFont(new Font("serif", Font.PLAIN, 20));
        // image.add(labelmtrnumber);
        
    //     lblusersId = new JLabel();
    //     lblusersId.setBounds(200, 400, 150, 30);
    //     lblusersId.setFont(new Font("serif", Font.PLAIN, 20));
    //    image.add(lblusersId);
        
        try {
            Conn c = new Conn();
            String query = "select * from users where meternumber = '"+tfmeternumber+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
               

      
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(70, 550, 200, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back = new JButton("Back");
        back.setBounds(300, 550, 200, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String city = tfcity.getText();
            String address = tfaddress.getText();
            String meternumber = tfmeternumber.getText();
            String phone = tfphone.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();

           
            
            try {
                Conn conn = new Conn();
               String updateQuery = "UPDATE users "
                + "SET "               
                + "    address =  '" + address + "',  "
                + "    city =  '" + city + "', "
                + "    state = '" + state + "', "
                + "    email ='" + email + "', "
                + "    phone = " + phone + " "
                + "WHERE meternumber = " + meternumber;


                conn.s.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateUser();
    }
}
