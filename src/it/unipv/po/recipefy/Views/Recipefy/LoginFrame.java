package it.unipv.po.recipefy.Views.Recipefy;

import it.unipv.po.recipefy.Views.MainFrame.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginFrame extends JPanel {
    private final MainFrame mf;

    public LoginFrame(MainFrame mf) {
        this.mf = mf;

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(260, 140, 20, 60)); // Adjust padding

        Border roundedBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                BorderFactory.createLineBorder(Color.GREEN, 4) // Change to match background color
        );

        LoginPanel loginPanel = new LoginPanel(roundedBorder, mf);

        RegisterPanel registerPanel = new RegisterPanel(roundedBorder, mf);

        JPanel formContainer = new JPanel(new GridLayout(1, 2, 120, 0)); // 1 row, 2 columns
        formContainer.add(loginPanel);
        formContainer.add(registerPanel);

        mainPanel.add(formContainer, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

}