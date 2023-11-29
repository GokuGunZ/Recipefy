package Controllers;
import Beans.User;
import Factory.MainPanelFactory;
import Models.UserModel;
import Views.MainFrame.MainFrame;
import Views.MainFrame.MainPanel;

import javax.swing.JPanel;

public class MainFrameController {
    private MainFrame mainFrame;
    private User authedUser;

        public MainFrameController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public void displayModule(MainPanel mainPanel) {
        JPanel panel = mainPanel.getPanel();
        mainFrame.updateMainPanel(panel);
    }

    public void createAndDisplayUserPan() {
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

    public User getUser() {return this.authedUser;}
}