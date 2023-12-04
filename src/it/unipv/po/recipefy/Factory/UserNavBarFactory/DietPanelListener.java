package it.unipv.po.recipefy.Factory.UserNavBarFactory;

import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Views.User.DietPanel;
import it.unipv.po.recipefy.Views.User.UserPanel;

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
