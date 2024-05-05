
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Splash extends JFrame implements ActionListener {
    
    JTextField tfusername, tfpassword;
    
    JButton raisebtn, LoginPage;
    
    
    Splash() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.png"));
        Image i2 = i1.getImage().getScaledInstance(1720, 900, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1420, 830);
        add(image);

        JLabel heading = new JLabel("WELCOME TO POWER MANAGER");
        heading.setBounds(80, 35, 1200, 60);
        heading.setFont(new Font("Century", Font.BOLD,60));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
      
            
        raisebtn = new JButton("Raise Query");
        raisebtn.setBounds(125, 400, 200, 60);
        raisebtn.setFont(new Font("Century", Font.PLAIN,20));
        raisebtn.setBackground(Color.BLACK);
        raisebtn.setForeground(Color.WHITE);
        raisebtn.addActionListener(this);
        image.add(raisebtn);


        
        // login functionality


        JPanel framelog = new JPanel();
        framelog.setBounds(750, 160, 500, 480);
        framelog.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
        framelog.setOpaque(false);        
        image.add(framelog);


        JLabel lgheading = new JLabel("Login");
        lgheading.setForeground(Color.white);
        lgheading.setFont(new Font("Century", Font.CENTER_BASELINE,40));
        lgheading.setBounds(940, 190, 300, 60);
        image.add(lgheading);
        
 
        JLabel lblusername = new JLabel("Username");
        lblusername.setForeground(Color.white);
        lblusername.setFont(new Font("Century", Font.BOLD,20));
        lblusername.setBounds(800, 250, 300, 60);
        image.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(800, 310, 400, 40);
        tfusername.setFont(new Font("Century", Font.PLAIN,20));
        image.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setForeground(Color.white);
        lblpassword.setBounds(800, 370, 100, 30);
        lblpassword.setFont(new Font("Century", Font.BOLD,20));
        image.add(lblpassword);      
        
        tfpassword = new JTextField();
        tfpassword.setBounds(800, 420, 400, 40);
        tfpassword.setFont(new Font("Century", Font.PLAIN,20));
        image.add(tfpassword);
        
        LoginPage = new JButton("Sign Up");
        LoginPage.setBounds(910, 500, 200, 60);
        LoginPage.setFont(new Font("Century", Font.PLAIN,20));
        LoginPage.setBackground(Color.BLACK);
        LoginPage.setForeground(Color.WHITE);
        LoginPage.addActionListener(this);
        image.add(LoginPage);
   
        




        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
      
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == LoginPage) {
            
         
            try {
                String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from admin where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                
            }
            } catch (Exception e) {
              System.err.println(e);
            }
        } else if (ae.getSource() == raisebtn) {
            
            setVisible(false);
            new RaiseComplaints();
        }
    }




  
    public static void main(String args[]) {
        new Splash();
    }
}
