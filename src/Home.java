
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove , exit,showcomplaints;
    
    Home() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.png"));
        Image i2 = i1.getImage().getScaledInstance(1720, 900, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1420, 830);
        add(image);
        
        JLabel heading = new JLabel("WELCOME TO POWER MANAGER ADMIN PANEL");
        heading.setBounds(100, 35, 1200, 60);
        heading.setFont(new Font("Century", Font.BOLD,35));
        heading.setForeground(Color.WHITE);
        image.add(heading);

        exit = new JButton("Exit");
        exit.setBounds(1100, 50, 120, 40);
        exit.setFont(new Font("Century", Font.PLAIN,15));
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);

                
        
      
         
        add = new JButton("Add New User");
        add.setBounds(1000, 150, 270, 70);
        add.setFont(new Font("Century", Font.PLAIN,20));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        image.add(add);

                
        update = new JButton("Update User");
        update.setBounds(1000, 245, 270, 70);
        update.setFont(new Font("Century", Font.PLAIN,20));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        image.add(update);

 

        remove = new JButton("Remove User");
        remove.setBounds(1000, 340, 270, 70);
        remove.setFont(new Font("Century", Font.PLAIN,20));
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        image.add(remove);


         
                 
        view = new JButton("View Users");
        view.setBounds(1000, 435, 270, 70);
        view.setFont(new Font("Century", Font.PLAIN,20));
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        image.add(view);

        showcomplaints = new JButton("Notifications");
        showcomplaints.setBounds(1000, 520, 270, 70);
        showcomplaints.setFont(new Font("Century", Font.PLAIN,20));
        showcomplaints.setBackground(Color.BLACK);
        showcomplaints.setForeground(Color.WHITE);
        showcomplaints.addActionListener(this);
        image.add(showcomplaints);




        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddUser();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewUser();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateUser();
        }
        else if (ae.getSource() == exit) {
            setVisible(false);
            new Splash();
        }
        else if (ae.getSource() == remove) {

            setVisible(false);
            new RemoveUser();
        }
        else if (ae.getSource() == showcomplaints ) {

            setVisible(false);
            new ShowComplaint();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
