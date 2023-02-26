package electricity_billing_syatem;

import javax.swing.*;
import java.awt.*;

class GUI {
    JFrame home;

    GUI()
    {
        home = new JFrame("Electricity Billing System");
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setLayout(null);
        home.getContentPane().setBackground(Color.WHITE);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // new tools();
        new Login();
    }

    public static void main(String[] args) 
    {
        new GUI();
    }
}