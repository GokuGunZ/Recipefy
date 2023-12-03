package Factory.UserNavBarFactory;

import Controllers.MainFrameController;
import Views.User.DietPanel;
import Views.User.UserPanel;

import java.awt.event.ActionEvent;

public class DietPanelListener implements UserNavBarActionListenerInterface {
    private MainFrameController mfc;

    public DietPanelListener(MainFrameController mfc) {
        this.mfc = mfc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((UserPanel) mfc.getMainPanel()).updateCenterPanel(new DietPanel());
    }
}
