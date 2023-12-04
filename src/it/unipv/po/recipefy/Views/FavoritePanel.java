package it.unipv.po.recipefy.Views;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;

public class FavoritePanel extends JPanel implements MainPanel {
    private User authedUser;

    public FavoritePanel(MainFrameController mfc) {
        this.authedUser = mfc.getUser();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Favorite Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel(){
        return this;
    }
}
