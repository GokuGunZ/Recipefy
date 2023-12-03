package Factory.UserNavBarFactory;

import Controllers.MainFrameController;
import Views.User.AllPanel;
import Views.User.UserPanel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class AllPanelListener implements UserNavBarActionListenerInterface {
    private MainFrameController mfc;

    public AllPanelListener(MainFrameController mfc) {
        this.mfc = mfc;
    }

    @Override
    public void actionPerformed(ActionEvent e) throws SQLException, IOException {
        ((UserPanel) mfc.getMainPanel()).updateCenterPanel(new AllPanel((UserPanel) mfc.getMainPanel(), mfc));
    }
}
