package Factory;

import Controllers.MainFrameController;
import Views.FavoritePanel;
import Views.MainFrame.MainPanel;
import Views.SearchPanel;
import Views.User.UserPanel;

import java.io.IOException;
import java.sql.SQLException;

public class MainPanelFactory {
    public static MainPanel createUserPanel(MainFrameController mfc) throws IOException, SQLException {
        return new UserPanel(mfc);
    }

    public static MainPanel createSearchPanel(MainFrameController mfc) {
        return new SearchPanel(mfc);
    }

    public static MainPanel createFavoritePanel(MainFrameController mfc) {
        return new FavoritePanel(mfc);
    }
}
