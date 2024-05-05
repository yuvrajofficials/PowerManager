
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class RaiseComplaints extends JFrame implements ActionListener {

    JTextField tfname, tfsubject, tfphone;
    JTextArea tfmessage;
    JButton Submitbtn, Backbtn;

    RaiseComplaints() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.png"));
        Image i2 = i1.getImage().getScaledInstance(1720, 900, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1420, 830);
        add(image);
        

        JLabel requestlabel = new JLabel("Raise Request");
        requestlabel.setBounds(560, 60, 600, 60);
        requestlabel.setFont(new Font("Century", Font.PLAIN, 40));
        requestlabel.setForeground(Color.WHITE);
       image.add(requestlabel);

        JPanel framelog = new JPanel();
        framelog.setBounds(300, 140, 780, 540);
        framelog.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        framelog.setOpaque(false);
        image.add(framelog);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(330, 170, 80, 40);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        image.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(450, 170, 600, 40);
        tfname.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        image.add(tfname);

        JLabel lblsubject = new JLabel("subject");
        lblsubject.setBounds(330, 240, 80, 40);
        lblsubject.setForeground(Color.WHITE);
        lblsubject.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        image.add(lblsubject);

        tfsubject = new JTextField();
        tfsubject.setBounds(450, 240, 600, 40);
        tfsubject.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        image.add(tfsubject);

        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(330, 310, 80, 40);
        lblphone.setForeground(Color.WHITE);
        lblphone.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        image.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(450, 310, 600, 40);
        tfphone.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        image.add(tfphone);

        JLabel lblmessage = new JLabel("Message :");
        lblmessage.setBounds(330, 380, 100, 40);
        lblmessage.setForeground(Color.WHITE);
        lblmessage.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
       image.add(lblmessage);

        tfmessage = new JTextArea();
        tfmessage.setBounds(450, 380, 600, 230);
        tfmessage.setFont(new Font("Century", Font.CENTER_BASELINE, 20));
        tfmessage.setLineWrap(true);
       image.add(tfmessage);

        Submitbtn = new JButton("Submit");
        Submitbtn.setBounds(550, 630, 400, 40);
        Submitbtn.setFont(new Font("Century", Font.PLAIN, 20));
        Submitbtn.setBackground(Color.BLACK);
        Submitbtn.setForeground(Color.WHITE);
        Submitbtn.addActionListener(this);
        image.add(Submitbtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(20, 20, 120, 40);
        Backbtn.setFont(new Font("Century", Font.PLAIN, 20));
        Backbtn.setBackground(Color.BLACK);
        Backbtn.setForeground(Color.WHITE);

        Backbtn.addActionListener(this);
       image.add(Backbtn);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submitbtn) {
            String name = tfname.getText();
            String date = new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
            String message = tfmessage.getText();
            String subject = tfsubject.getText();
            String phone = tfphone.getText();

            try {
                Conn conn = new Conn();
             
                String query = "insert into complaints (name,subject,message,phone,date,priority) values('" + name + "','"+ subject + "', '" + message + "',"+ phone +",'" + date + "',6)";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Submitted Successfully");
                setVisible(false);
                new Splash();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Splash();

        }
   
    }

    public static void main(String[] args) {
        new RaiseComplaints();
    }

}
