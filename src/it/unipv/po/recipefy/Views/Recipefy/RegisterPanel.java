package it.unipv.po.recipefy.Views.Recipefy;

import it.unipv.po.recipefy.Controllers.RegisterController;
import it.unipv.po.recipefy.Views.MainFrame.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RegisterPanel extends JPanel {
    public JTextField usernameField;
    public JTextField emailField;
    public JPasswordField passwordField;
    public RegisterPanel(Border roundedBorder, MainFrame mf){
        this.setLayout(new BorderLayout()); // Vertical BoxLayout
        this.setPreferredSize(new Dimension(180, 150)); // Adjust size

        this.add(new JLabel("Register Form"), BorderLayout.NORTH);

        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JPanel formsRegPanel = new JPanel();
        formsRegPanel.setBorder(BorderFactory.createEmptyBorder(80, 40, 40, 40));
        formsRegPanel.add(new JLabel("Insert your username:"));
        formsRegPanel.add(usernameField);
        formsRegPanel.add(new JLabel("Insert your email:"));
        formsRegPanel.add(emailField);
        formsRegPanel.add(new JLabel("Insert your password"));
        formsRegPanel.add(passwordField);

        JButton registerButton = new JButton("Click Here to Register");
        RegisterController registerController = new RegisterController(mf, this);
        registerButton.addActionListener(registerController);

        this.add(formsRegPanel, BorderLayout.CENTER);
        this.add(registerButton, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createCompoundBorder(
                roundedBorder,
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Adjust padding
        ));
    }
}
