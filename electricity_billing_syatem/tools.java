package electricity_billing_syatem;

import javax.swing.*;
import java.awt.*;

public class tools extends JFrame {
    tools()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        JToolBar toolbar = new JToolBar();
        
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
        Container contentPane = getContentPane();   // Get the content pane of the frame
        contentPane.add(toolbar, BorderLayout.NORTH);
    }

    public static void main(String[] args) 
    {
        new tools();
    }
}
