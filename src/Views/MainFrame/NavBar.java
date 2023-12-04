package Views.MainFrame;

import Controllers.NavBarListener.FavoritesListener;
import Controllers.NavBarListener.PersonalCookBookListener;
import Controllers.NavBarListener.SearchPageListener;

import javax.swing.*;
import java.awt.*;

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
        button1.addActionListener(new PersonalCookBookListener(mainFrame.getMainFrameController()));
        button2.addActionListener(new SearchPageListener(mainFrame.getMainFrameController()));
        button3.addActionListener(new FavoritesListener(mainFrame.getMainFrameController()));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        this.add(buttonPanel);

        this.add(new JLabel(""));
    }
}
