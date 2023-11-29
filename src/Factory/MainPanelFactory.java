package Factory;

import Beans.User;
import Controllers.MainFrameController;
import Views.FavoritePanel;
import Views.MainFrame.MainPanel;
import Views.SearchPanel;
import Views.User.UserPanel;

public class MainPanelFactory {
    public static MainPanel createUserPanel(MainFrameController mfc) {
        return new UserPanel(mfc);
    }

    public static MainPanel createSearchPanel(MainFrameController mfc) {
        return new SearchPanel(mfc);
    }

    public static MainPanel createFavoritePanel(MainFrameController mfc) {
        return new FavoritePanel(mfc);
    }
}
