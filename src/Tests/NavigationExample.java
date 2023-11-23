package Tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationExample {
    private JFrame frame;
    private JPanel sidebar;
    private JPanel mainPanel;
    private JPanel buttonPanel;


    public NavigationExample() {
        frame = new JFrame("Lateral Navigation");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the sidebar panel for navigation
        sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(3, 1)); // Adjust rows as needed

        sidebar.add(new JLabel(""));


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

        sidebar.add(buttonPanel);

        sidebar.add(new JLabel(""));

        frame.add(sidebar, BorderLayout.WEST);

        // Create the main content panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JLabel defaultLabel = new JLabel("Select an option from the sidebar");
        defaultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(defaultLabel, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // ActionListener to handle button clicks for navigation
    private class NavigationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            // Perform action based on the button clicked
            if (source.getText().equals("Option 1")) {
                // Update the main panel content for Option 1
                mainPanel.removeAll();
                JLabel optionLabel = new JLabel("Displaying Option 1 content");
                optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                mainPanel.add(optionLabel, BorderLayout.CENTER);
            } else if (source.getText().equals("Option 2")) {
                // Update the main panel content for Option 2
                mainPanel.removeAll();
                JLabel optionLabel = new JLabel("Displaying Option 2 content");
                optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                mainPanel.add(optionLabel, BorderLayout.CENTER);
            }
            // Add more else-if blocks for other button options

            // Refresh the main panel
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NavigationExample());
    }
}
