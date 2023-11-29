package Views.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBar extends JPanel {
    private MainFrame mainFrame;


    public NavBar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;


        this.setLayout(new GridLayout(3, 1)); // Adjust rows as needed

        this.add(new JLabel(""));


        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        JButton button1 = new JButton("Personal Cookbook");
        JButton button2 = new JButton("Search Page");
        JButton button3 = new JButton("Favorites");

        // Add action listeners to the buttons to handle navigation
        button1.addActionListener(new Nav1Listener());
        button2.addActionListener(new Nav2Listener());
        button3.addActionListener(new Nav3Listener());

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        this.add(buttonPanel);

        this.add(new JLabel(""));
    }

    // ActionListener to handle button clicks for navigation
    private class Nav1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.mfc.createAndDisplayUserPan();
        }
    }
    private class Nav2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.mfc.createAndDisplaySearchPan();
        }
    }
    private class Nav3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.mfc.createAndDisplayFavPan();
        }
    }
}
