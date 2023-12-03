package Factory.UserNavBarFactory;

import Controllers.MainFrameController;
import Views.User.ReadPanel;
import Views.User.UserPanel;

import java.awt.event.ActionEvent;

public class ReadPanelListener implements UserNavBarActionListenerInterface {
    private MainFrameController mfc;

    public ReadPanelListener(MainFrameController mfc) {
        this.mfc = mfc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((UserPanel) mfc.getMainPanel()).updateCenterPanel(new ReadPanel(mfc));
    }
}