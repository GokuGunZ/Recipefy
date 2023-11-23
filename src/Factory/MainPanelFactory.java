package Factory;

import Views.FavoritePanel;
import Views.MainFrame.MainPanel;
import Views.SearchPanel;
import Views.User.UserPanel;

public class MainPanelFactory {
    public static MainPanel createUserPanel() {
        return new UserPanel();
    }

    public static MainPanel createSearchPanel() {
        return new SearchPanel();
    }

    public static MainPanel createFavoritePanel() {
        return new FavoritePanel();
    }
}
