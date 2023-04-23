import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements Custom,ActionListener {
    JFrame home;
    Project()
    {
        home = new JFrame("Electricity Billing System");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // home.setSize(screenSize.width, screenSize.height);
        
        // Create the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/bg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        home.add(image);

        // JMenuBar menuBar = new JMenuBar();
        // home.add(menuBar);

        // JPanel menuPanel = new JPanel();
        // home.add(menuPanel);
        // menuPanel.setLayout(null);
        // menuPanel.setSize(home.getSize(screenSize));

        // menuBar.setSize(screenSize.width, 30);
        // // menuBar.setLocation();







        
        home.setVisible(true);
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setMinimumSize(screenSize.getSize());
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
    public static void main(String[] args) {
        new Project();
    }
}