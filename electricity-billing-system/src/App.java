import javax.swing.*;
import java.awt.*;

public class App {
    JFrame home;

    App()
    {
        // home = new JFrame("Electricity Billing System");
        // home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // home.setLayout(null);
        // home.getContentPane().setBackground(Color.LIGHT_GRAY);
        // home.setVisible(true);
        new Login();
        // home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
