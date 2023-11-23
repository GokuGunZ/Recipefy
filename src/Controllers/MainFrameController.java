package Controllers;
import Factory.MainPanelFactory;
import Views.MainFrame.MainFrame;
import Views.MainFrame.MainPanel;

import javax.swing.JPanel;

public class MainFrameController {
    private MainFrame mainFrame;

    public MainFrameController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public void displayModule(MainPanel mainPanel) {
        JPanel panel = mainPanel.getPanel();
        mainFrame.updateMainPanel(panel);
    }

    public void createAndDisplayUserPan() {
        MainPanel userPanel = MainPanelFactory.createUserPanel();
        displayModule(userPanel);
    }

    public void createAndDisplaySearchPan() {
        MainPanel searchPanel = MainPanelFactory.createSearchPanel();
        displayModule(searchPanel);
    }

    public void createAndDisplayFavPan() {
        MainPanel favoritePanel = MainPanelFactory.createFavoritePanel();
        displayModule(favoritePanel);
    }
}