import java.io.*;
import javax.swing.*;
import java.awt.*;

class GUI {
    JFrame home;

    void tools()
    {
        JToolBar toolbar = new JToolBar();

        // On button click open Popup()
        JButton InfoBtn = new JButton("Information");
        JButton UserBtn = new JButton("User");
        JButton ReportBtn = new JButton("Report");
        JButton LogoutBtn = new JButton("Log Out");

        toolbar.add(InfoBtn);
        toolbar.addSeparator();
        toolbar.add(UserBtn);
        toolbar.addSeparator();
        toolbar.add(ReportBtn);
        toolbar.addSeparator();
        toolbar.add(LogoutBtn);

        // What is content pane?
        // The content pane is the container that holds the components of a window.
        // The content pane is the only child of the window object.
        Container contentPane = home.getContentPane();   // Get the content pane of the frame
        contentPane.add(toolbar, BorderLayout.NORTH);
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