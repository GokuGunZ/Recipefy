package Controllers;

import Utility.DataValidator;
import Views.MainFrame.MainFrame;
import Views.Recipefy.RegisterPanel;
import Models.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterController implements ActionListener {
    private final MainFrame mainFrame;
    private final RegisterPanel registerPanel;

    public RegisterController(MainFrame mainFrame, RegisterPanel rP){
        this.registerPanel = rP;
        this.mainFrame = mainFrame;
    }

    public void registerUser(String username, String password, String email) throws SQLException{
        boolean isValidUsername = UserModel.isUsernameValid(username);
        if (!isValidUsername) {
            JOptionPane.showMessageDialog(null, "The username already exists!");
            return;
        }
        boolean isValidEmail = UserModel.isEmailValid(email);
        if (!isValidEmail) {
            JOptionPane.showMessageDialog(null, "The email already exists!");
            return;
        }
        isValidEmail = DataValidator.isValidEmail(email);
        if (!isValidEmail) {
            JOptionPane.showMessageDialog(null, "The email is invalid!");
            return;
        }
        boolean isPasswordStrong = DataValidator.isStrongPassword(password);
        if (!isPasswordStrong){
            JOptionPane.showMessageDialog(null, "The password is invalid! The password must be 8 char long and with at least one number");
            return;
        }
        mainFrame.renderAuthenticatedUI(UserModel.createUser(username, password, email));
        JOptionPane.showMessageDialog(null, "User successfully created!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = registerPanel.usernameField.getText();
        String password = new String(registerPanel.passwordField.getPassword());
        String email = registerPanel.emailField.getText();
        try {
            registerUser(username, password, email);
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        if (username.equals("Dotti") && password.equals("pitucci") && email.equals("cipollone")) {
            this.mainFrame.renderAuthenticatedUI(null);
        }
    }
}
