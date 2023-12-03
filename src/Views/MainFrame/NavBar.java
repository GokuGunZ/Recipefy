package Views.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

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
        button1.addActionListener(new PersonalCookBookListener());
        button2.addActionListener(new SearchPageListener());
        button3.addActionListener(new FavoritesListener());

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        this.add(buttonPanel);

        this.add(new JLabel(""));
    }

    // ActionListener to handle button clicks for navigation
    private class PersonalCookBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                mainFrame.mfc.createAndDisplayUserPan();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    private class SearchPageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.mfc.createAndDisplaySearchPan();
        }
    }
    private class FavoritesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.mfc.createAndDisplayFavPan();
        }
    }
}
