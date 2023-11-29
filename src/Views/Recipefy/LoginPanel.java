package Views.Recipefy;

import Controllers.LoginController;
import Views.MainFrame.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginPanel extends JPanel {
    public JTextField usernameField;
    public JPasswordField passwordField;
    public LoginPanel(Border roundedBorder, MainFrame mf){
        this.setLayout(new BorderLayout()); // Vertical BoxLayout
        this.setPreferredSize(new Dimension(260, 400)); // Adjust size

        this.add(new JLabel("Login Form"), BorderLayout.NORTH);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JPanel formsPanel = new JPanel();
        formsPanel.setBorder(BorderFactory.createEmptyBorder(80, 40, 40, 40));
        formsPanel.add(new JLabel("Insert your username:"));
        formsPanel.add(usernameField);
        formsPanel.add(new JLabel("Insert your password"));
        formsPanel.add(passwordField);

        JButton loginBtn = new JButton("Click Here to Login");
        LoginController loginContr = new LoginController(mf, this);
        loginBtn.addActionListener(loginContr);

        this.add(formsPanel, BorderLayout.CENTER);
        this.add(loginBtn, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createCompoundBorder(
                roundedBorder,
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Adjust padding
        ));
    }
}
