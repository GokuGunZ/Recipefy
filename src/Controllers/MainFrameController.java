package Controllers;

import Beans.User;
import Factory.MainPanelFactory;
import Views.MainFrame.MainFrame;
import Views.MainFrame.MainPanel;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainFrameController {
    private MainFrame mainFrame;
    private User authedUser;
    private UserController userController;
    private MainPanel mainPanel;

    public MainFrameController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public void displayModule(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        JPanel panel = mainPanel.getPanel();
        mainFrame.updateMainPanel(panel);
    }

    public void createAndDisplayUserPan() throws IOException, SQLException {
        MainPanel userPanel = MainPanelFactory.createUserPanel(this);
        displayModule(userPanel);
    }

    public void createAndDisplaySearchPan() {
        MainPanel searchPanel = MainPanelFactory.createSearchPanel(this);
        displayModule(searchPanel);
    }

    public void createAndDisplayFavPan() {
        MainPanel favoritePanel = MainPanelFactory.createFavoritePanel(this);
        displayModule(favoritePanel);
    }


    public void setAuthedUser(User user){
        this.authedUser = user;
    }
    public void setUserController(int userID) {this.userController = new UserController(userID);}

    public User getUser() {return this.authedUser;}

    public UserController getUserController() {return this.userController;}
    public MainPanel getMainPanel() {return this.mainPanel;}
}