import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements Custom, ActionListener {
    JFrame home;
    String atype, meter;
    
    Project(String atype, String meter) {
        home = new JFrame("Electricity Billing System");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // home.setSize(screenSize.width, screenSize.height);
        
        // Create the background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("assets/bg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        home.add(image);
        
        // Create a panel to hold the masterMenu bar at center of frame
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(0, 450, (screenSize.width), (screenSize.height / 10));
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setOpaque(false);
        image.add(menuPanel);
        
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(false);
        menuPanel.add(menuBar);
        menuBar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        // Create a Master menu
        JMenu masterMenu = new JMenu("MASTER");
        masterMenu.setForeground(Color.WHITE);
        masterMenu.setBackground(Color.BLACK);
        masterMenu.setOpaque(true);
        masterMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        // Create menu items
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.addActionListener(this);
        newcustomer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        newcustomer.setFont(new Font("Tahoma", Font.BOLD, 13));
        masterMenu.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.addActionListener(this);
        customerdetails.setBackground(Color.BLACK);
        customerdetails.setForeground(Color.WHITE);
        customerdetails.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        customerdetails.setFont(new Font("Tahoma", Font.BOLD, 13));
        masterMenu.add(customerdetails);
        
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.addActionListener(this);
        depositdetails.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        depositdetails.setFont(new Font("Tahoma", Font.BOLD, 13));
        masterMenu.add(depositdetails);
        
        JMenuItem calculatebil = new JMenuItem("Calculate Bill");
        calculatebil.addActionListener(this);
        calculatebil.setBackground(Color.BLACK);
        calculatebil.setForeground(Color.WHITE);
        calculatebil.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        calculatebil.setFont(new Font("Tahoma", Font.BOLD, 13));
        masterMenu.add(calculatebil);
        
        // Create a Info menu
        JMenu infoMenu = new JMenu("INFO");
        infoMenu.setForeground(Color.WHITE);
        infoMenu.setBackground(Color.BLACK);
        infoMenu.setOpaque(true);
        infoMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        
        // Create menu items
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.addActionListener(this);
        updateinformation.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        updateinformation.setFont(new Font("Tahoma", Font.BOLD, 13));
        infoMenu.add(updateinformation);
        
        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.addActionListener(this);
        viewinformation.setBackground(Color.BLACK);
        viewinformation.setForeground(Color.WHITE);
        viewinformation.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        viewinformation.setFont(new Font("Tahoma", Font.BOLD, 13));
        infoMenu.add(viewinformation);
        
        // Create a User menu
        JMenu userMenu = new JMenu("USER");
        userMenu.setForeground(Color.WHITE);
        userMenu.setBackground(Color.BLACK);
        userMenu.setOpaque(true);
        userMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.addActionListener(this);
        paybill.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        paybill.setFont(new Font("Tahoma", Font.BOLD, 13));
        userMenu.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.addActionListener(this);
        billdetails.setBackground(Color.BLACK);
        billdetails.setForeground(Color.WHITE);
        billdetails.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        billdetails.setFont(new Font("Tahoma", Font.BOLD, 13));
        userMenu.add(billdetails);
        
        // Create a Report menu
        JMenu reportMenu = new JMenu("REPORT");
        reportMenu.setForeground(Color.WHITE);
        reportMenu.setBackground(Color.BLACK);
        reportMenu.setOpaque(true);
        reportMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.addActionListener(this);
        generatebill.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        generatebill.setFont(new Font("Tahoma", Font.BOLD, 13));
        reportMenu.add(generatebill);
        
        if (atype.equals("Admin")) {
            masterMenu.setBorder(BorderFactory.createEmptyBorder(10, 35, 10, 35));
            menuBar.add(Box.createHorizontalGlue()); // Pushes the menu to the right
            menuBar.add(Box.createHorizontalStrut(50));
            menuBar.add(masterMenu);
        } else {
            infoMenu.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
            menuBar.add(Box.createHorizontalGlue()); // Pushes the menu to the right
            menuBar.add(Box.createHorizontalStrut(50));
            menuBar.add(infoMenu);
            
            userMenu.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
            menuBar.add(Box.createHorizontalGlue());
            menuBar.add(Box.createHorizontalStrut(50));
            menuBar.add(userMenu);
            
            reportMenu.setBorder(BorderFactory.createEmptyBorder(10, 35, 10, 35));
            menuBar.add(Box.createHorizontalGlue());
            menuBar.add(Box.createHorizontalStrut(50));
            menuBar.add(reportMenu);
        }
        
        home.setVisible(true);
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setMinimumSize(screenSize.getSize());
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateInformation(meter);
        } else if (msg.equals("Bill Details")) {
            new BillDetails(meter);
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meter);
        }
    }
    
    public static void main(String[] args) {
        new Project("", "");
    }
}