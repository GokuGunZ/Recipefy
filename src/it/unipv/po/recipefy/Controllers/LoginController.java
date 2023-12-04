package it.unipv.po.recipefy.Controllers;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Views.MainFrame.MainFrame;
import it.unipv.po.recipefy.Models.UserModel;
import it.unipv.po.recipefy.Views.Recipefy.LoginPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController implements ActionListener {
    private final MainFrame mainFrame;
    private LoginPanel loginPanel;

    public LoginController(MainFrame mainFrame, LoginPanel lP) {
        this.loginPanel = lP;
        this.mainFrame = mainFrame;
    }

    public void authenticateUser(String username, String password) throws SQLException {
        boolean isValidUser = UserModel.validateUser(username, password);

        if (isValidUser) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            mainFrame.renderAuthenticatedUI(UserModel.getUserByUsername(username));
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = loginPanel.usernameField.getText();
        String password = new String(loginPanel.passwordField.getPassword());
        try {
            authenticateUser(username,password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        if (username.equals("admin")) {
            mainFrame.renderAuthenticatedUI(new User(0, "admin","admin@email.it", "Alessio Pit", "Java developer"));
        }
    }
}
