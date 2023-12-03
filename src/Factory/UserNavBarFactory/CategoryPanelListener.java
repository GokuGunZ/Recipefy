package Factory.UserNavBarFactory;

import Controllers.MainFrameController;
import Controllers.UserController;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class CategoryPanelListener  implements UserNavBarActionListenerInterface {
    private MainFrameController mfc;

    public CategoryPanelListener(MainFrameController mfc) {
        this.mfc = mfc;
    }

    @Override
    public void actionPerformed(ActionEvent e) throws SQLException, IOException {
        UserController userController = mfc.getUserController();
        userController.setMainFrameController(mfc);
        try {
            userController.renderCategoryPage();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}