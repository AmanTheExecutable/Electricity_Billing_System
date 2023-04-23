import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Signup extends JFrame implements Custom,ActionListener {
    
    JButton btncreate,btnback;
    Choice accountType;
    JTextField meter,username,name, password;
    
    Signup()
    {
        setBounds(600,300,640,400);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(20,30,590,300);
        panel.setBackground(secondaryColor);
        panel.setBorder(new TitledBorder(new LineBorder(accentColor,2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,FontColor));
        panel.setLayout(null);
        panel.setForeground(FontColor);
        add(panel);
        
        // Create Labels for Account type,meter number,username,name and password
        JLabel heading = new JLabel("Create Account as");
        JLabel lblmeter = new JLabel("Meter Number");
        JLabel lblusername = new JLabel("Username");
        JLabel lblname = new JLabel("Name");
        JLabel lblpassword = new JLabel("Password");
        
        // Create Text Fields for meter number,username,name and password
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        
        meter = new JTextField();
        username = new JTextField();
        name = new JTextField();
        password = new JPasswordField();
        
        // Create Buttons for create account and cancel
        btncreate = new JButton("Create");
        btnback = new JButton("Back");
        
        // Add Labels to the frame
        panel.add(heading);
        panel.add(lblmeter);
        panel.add(lblusername);
        panel.add(lblname);
        panel.add(lblpassword);
        
        // Add Text Fields to the frame
        panel.add(accountType);
        panel.add(meter);
        panel.add(username);
        panel.add(name);
        panel.add(password);
        
        // Add Buttons to the frame
        panel.add(btncreate);
        panel.add(btnback);
        
        // Set Bounds for Labels
        heading.setBounds(120,20,120,30);
        lblmeter.setBounds(120,50,120,30);
        lblusername.setBounds(120,80,120,30);
        lblname.setBounds(120,110,120,30);
        lblpassword.setBounds(120,140,120,30);
        
        // Set Bounds for Text Fields
        accountType.setBounds(260,25,200,25);
        meter.setBounds(260,50,200,25);
        username.setBounds(260,80,200,25);
        name.setBounds(260,110,200,25);
        password.setBounds(260,140,200,25);
        
        // Set Bounds for Buttons
        btncreate.setBounds(180,200,100,30);
        btnback.setBounds(310,200,100,30);
        
        // Add Action Listener to the buttons
        btncreate.addActionListener(this);
        btnback.addActionListener(this);
        
        // Adding border to the text fields
        meter.setBorder(new LineBorder(Color.BLACK,1));
        username.setBorder(new LineBorder(Color.BLACK,1));
        name.setBorder(new LineBorder(Color.BLACK,1));
        password.setBorder(new LineBorder(Color.BLACK,1));
        
        // Set Font Color
        heading.setForeground(FontColor);
        lblmeter.setForeground(FontColor);
        lblusername.setForeground(FontColor);
        lblname.setForeground(FontColor);
        lblpassword.setForeground(FontColor);
        
        // Set Font
        heading.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblmeter.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblpassword.setFont(new Font("Tahoma",Font.PLAIN,14));


        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        accountType.addItemListener(new ItemListener() { // 
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        // Set color for buttons
        btncreate.setBackground(btnColor);
        btncreate.setForeground(Color.WHITE);
        btncreate.setBorderPainted(false);
        
        btnback.setBackground(btnColor);
        btnback.setForeground(Color.WHITE);
        btnback.setBorderPainted(false);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btncreate)
        {
            // Create Account
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String smeter = meter.getText();
            String spassword = password.getText();
            
            try {
                Conn c = new Conn();
                
                String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                } else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
                new Login();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == btnback)
        {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] arg)
    {
        new Signup();
    }
}