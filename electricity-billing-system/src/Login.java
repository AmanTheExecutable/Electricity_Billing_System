import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener,Custom {
    
    JButton btnlogin,btncancel,btnsignup;
    JTextField txtusername,txtpassword;
    Choice logginin;
    Login()
    {
        super("Login");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setFont(new Font("Tahoma", Font.PLAIN, 16));

        // Create Labels for username and password
        JLabel lblusername = new JLabel("Username");
        JLabel lblpassword = new JLabel("Password");
        JLabel lblloginas = new JLabel("Login As");

        // Create Text Fields for username and password
        txtusername = new JTextField();
        txtpassword = new JTextField();

        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");

        // Create Buttons for login and cancel
        btnlogin = new JButton("Login");
        btncancel = new JButton("Cancel"); 
        btnsignup = new JButton("Sign Up");

        // Add Labels to the frame
        add(lblusername);
        add(lblpassword);
        add(lblloginas);

        // Add Text Fields to the frame
        add(txtusername);
        add(txtpassword);

        // Add Buttons to the frame
        add(btnlogin);
        add(btncancel);
        add(btnsignup);

        // Add Choice to the frame
        add(logginin);

        // Set Bounds for Labels
        lblusername.setBounds(150, 50, 100, 30);
        lblpassword.setBounds(150, 100, 100, 30);
        lblloginas.setBounds(150, 150, 100, 30);

        // Set Bounds for Text Fields
        txtusername.setBounds(250, 50, 200, 30);
        txtpassword.setBounds(250, 100, 200, 30);

        // Set Bounds for Buttons
        btnlogin.setBounds(180, 200, 100, 30);
        btncancel.setBounds(320, 200, 100, 30);
        btnsignup.setBounds(250, 240, 100, 30);

        // Set Bounds for Choice
        logginin.setBounds(250, 155, 200, 30);

        // Set Background Color for Buttons
        btnlogin.setBackground(btnColor);
        btncancel.setBackground(btnColor);
        btnsignup.setBackground(btnColor);

        // Set Foreground Color for Buttons
        btnlogin.setForeground(Color.WHITE);
        btncancel.setForeground(Color.WHITE);
        btnsignup.setForeground(Color.WHITE);

        // Set on click color for Buttons
        btnlogin.setBorderPainted(false);
        btncancel.setBorderPainted(false);
        btnsignup.setBorderPainted(false);

        // Add Action Listener to Buttons to perform action
        btnlogin.addActionListener(this);
        btncancel.addActionListener(this);
        btnsignup.addActionListener(this);

        setSize(640, 350);
        setLocation(600, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == btnlogin)
        {
            String susername = txtusername.getText();
            String spassword = txtpassword.getText();
            String user = logginin.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + susername + "' and password = '" + spassword + "' and user = '" + user + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next())
                {
                    setVisible(false);
                    new Project(user, meter);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == btncancel)
        {
            System.exit(0);
            // setVisible(false);
        }
        else if (ae.getSource() == btnsignup)
        {
            new Signup().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) 
    {
        new Login();
    }
}