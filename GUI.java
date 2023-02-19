import java.io.*;
import javax.swing.*;
import java.awt.*;

class GUI {
    JFrame home;

    void tools()
    {
        JToolBar toolBar = new JToolBar();

        // On button click open Popup()
        JButton button1 = new JButton("Pay Bill");
        JButton button2 = new JButton("Pay Bill2");
        JButton button3 = new JButton("Pay Bill3");

        toolBar.add(button1);
        toolBar.add(button2);
        toolBar.add(button3);

        Container contentPane = home.getContentPane();
        contentPane.add(toolBar, BorderLayout.NORTH);
    }

    void mainWindow()
    {
        home = new JFrame("Electricity Billing System");
        tools();
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setVisible(true);  
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    public static void main(String[] args) 
    {
        new GUI().mainWindow();
    }
}