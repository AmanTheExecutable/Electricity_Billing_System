package electricity_billing_syatem.src;

import javax.swing.*;
import java.awt.*;

class Run_Ebs {
    JFrame home;

    Run_Ebs()
    {
        home = new JFrame("Electricity Billing System");
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setLayout(null);
        home.getContentPane().setBackground(Color.LIGHT_GRAY);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Login();
    }

    public static void main(String[] args) 
    {
        new Run_Ebs();
    }
}