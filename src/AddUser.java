
import java.util.Enumeration;
import java.util.Hashtable;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener{
    
    
    
    Random ran = new Random();
    int number = ran.nextInt(999999);

    
    
    JTextField tname, tfaddress , tfcity,tfstate,  tfphone,  tfemail,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbstates;
    JLabel tfmeternumber;
    JButton add, back;
    
    AddUser() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.png"));
        Image i2 = i1.getImage().getScaledInstance(1720, 900, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1420, 830);
        add(image);


        

        JPanel framelog = new JPanel();
        framelog.setBounds(15, 100, 700, 580);
        framelog.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
        framelog.setOpaque(false);        
        image.add(framelog);
        
        JLabel heading = new JLabel("Add User Details");
        heading.setBounds(320, 30, 500, 50);
           heading.setForeground(Color.WHITE);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
       image.add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setForeground(Color.WHITE);
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
       image.add(labelname);
        
        tname = new JTextField();
        tname.setBounds(200, 150, 450, 30);
      image.add(tname);
        
    
        
        JLabel labeldate = new JLabel("Date ");
        labeldate.setForeground(Color.WHITE);
        labeldate.setBounds(50, 200, 150, 30);
       labeldate.setFont(new Font("serif", Font.PLAIN, 20));
       image.add(labeldate);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
       image.add(dcdob);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setForeground(Color.WHITE);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
       image.add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
       image.add(tfaddress);
        

        JLabel labelcity = new JLabel("City");
        labelcity.setBounds(400, 200, 150, 30);
        labelcity.setForeground(Color.WHITE);
        labelcity.setFont(new Font("serif", Font.PLAIN, 20));
      image.add(labelcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(500, 200, 150, 30);
      image.add(tfcity);

        JLabel labelstate = new JLabel("State");
        labelstate.setBounds(400, 300, 150, 30);
        labelstate.setForeground(Color.WHITE);
        labelstate.setFont(new Font("serif", Font.PLAIN, 20));
     image.add(labelstate);
        

        String states[] = {"Select","Andhra Pradesh","Andaman and Nicobar","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra & Nagar Haveli","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Lakshadweep","Ladakh","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Puducherry","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal","Jammu and Kashmir"};
        cbstates = new JComboBox(states);
        cbstates.setBackground(Color.WHITE);
        cbstates.setBounds(500, 300, 150, 30);
        image.add(cbstates);
        
       
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        labelphone.setForeground(Color.WHITE);
        image.add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(500, 250, 150, 30);
        image.add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        labelemail.setForeground(Color.WHITE);
        image.add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        image.add(tfemail);
        
             
        JLabel labelmeternumber = new JLabel("Meter Number");
        labelmeternumber.setBounds(50, 400, 150, 30);
        labelmeternumber.setFont(new Font("serif", Font.PLAIN, 20));
        labelmeternumber.setForeground(Color.WHITE);
        image.add(labelmeternumber);
        
        tfmeternumber = new JLabel("" + number);
        tfmeternumber.setForeground(Color.WHITE);
        tfmeternumber.setBounds(200, 400, 150, 30);
        tfmeternumber.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(tfmeternumber);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
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
            String name = tname.getText();

          
            
            // String date = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String city = tfcity.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String state = (String) cbstates.getSelectedItem();
           
           
            String meternumber = tfmeternumber.getText();
            
            try {
                Conn conn = new Conn();
                // String query = "insert into users (+meternumber+,+name+,+address+,+city+,+state+,+email+,+phone+,+date+) values( '"+meternumber+"','"+name+"', '"+address+"',  '"+city+"','"+state+"','"+email+"',  '"+phone+"', '"+date+"')";
                // conn.s.executeUpdate(query);
                String query = "INSERT INTO users (meternumber, name, address, city, state, email, phone) VALUES ('" + meternumber + "', '" + name + "', '" + address + "', '" + city + "', '" + state + "', '" + email + "', '" + phone + "')";
                // String query = "SELECT * FROM bill address REGEXP 'Maregaon'";
                conn.s.executeUpdate(query);
                // String query2 = "UPDARE bill address REGEXP 'Maregaon'";
                // conn.s.executeUpdate(query);
//                 Conn conn = new Conn();
// String query3 = "UPDATE emp \n" +
// "SET phone = phone + \n" +
// "  CASE \n" +
// "    WHEN address REGEXP '\\\\bWani\\\\b' THEN 2 \n" +
// "    WHEN address REGEXP '\\\\bapple\\\\b' THEN 3 \n" +
// "    WHEN address REGEXP '\\\\bmango\\\\b' THEN 1 \n" +
// "    ELSE 0 \n" +
// "  END \n" +
// "WHERE name REGEXP '\\\\byuvraj\\\\b|\\\\bapple\\\\b|\\\\bmango\\\\b';";

// conn.s.executeUpdate(query3);


                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new AddUser();
    }
}


