package it.unipv.po.recipefy.Controllers.NavBarListener;

import it.unipv.po.recipefy.Controllers.MainFrameController;

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