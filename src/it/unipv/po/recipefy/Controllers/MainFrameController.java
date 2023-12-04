package it.unipv.po.recipefy.Controllers;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Factory.MainPanelFactory;
import it.unipv.po.recipefy.Views.MainFrame.MainFrame;
import it.unipv.po.recipefy.Views.MainFrame.MainPanel;

import java.io.IOException;
import java.sql.SQLException;

public class MainFrameController {
    private MainFrame mainFrame;
    private User authedUser;
    private UserController userController;
    private MainPanel mainPanel;
    private int recipeID;

    public MainFrameController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public void displayModule(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        mainFrame.updateMainPanel(mainPanel.getPanel());
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

    public int getRecipeID() {return recipeID;}
    public void setRecipeID(int id) {recipeID=id;}
}