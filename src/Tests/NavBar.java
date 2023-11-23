package Tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBar extends JPanel {
    private MainFrame mainFrame;
    private JPanel sidebar;
    private JPanel buttonPanel;


    public NavBar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;


        this.setLayout(new GridLayout(3, 1)); // Adjust rows as needed

        this.add(new JLabel(""));


        buttonPanel = new JPanel(new GridLayout(3, 1));

        JButton button1 = new JButton("Personal Cookbook");
        JButton button2 = new JButton("Search Page");
        JButton button3 = new JButton("Favorites");

        // Add action listeners to the buttons to handle navigation
        button1.addActionListener(new NavigationListener());
        button2.addActionListener(new NavigationListener());
        button3.addActionListener(new NavigationListener());

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        this.add(buttonPanel);

        this.add(new JLabel(""));
    }

    // ActionListener to handle button clicks for navigation
    private class NavigationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("Personal Cookbook")) {
                mainFrame.updateMainPanel("Displaying Option 1 content");
            } else if (source.getText().equals("Search Page")) {
                mainFrame.updateMainPanel("Displaying Option 2 content");
            } else if (source.getText().equals("Favorites")) {
                mainFrame.updateMainPanel("Displaying Option 3 content");
            }
        }
    }
}
