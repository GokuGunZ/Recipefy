package it.unipv.po.recipefy.Factory;

import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Views.FavoritePanel;
import it.unipv.po.recipefy.Views.MainFrame.MainPanel;
import it.unipv.po.recipefy.Views.SearchPanel;
import it.unipv.po.recipefy.Views.User.UserPanel;

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
