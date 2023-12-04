package Controllers.NavBarListener;

import Controllers.MainFrameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPageListener implements ActionListener {
    private final MainFrameController mfc;

    public SearchPageListener(MainFrameController mfc) {
        this.mfc = mfc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mfc.createAndDisplaySearchPan();
    }
}