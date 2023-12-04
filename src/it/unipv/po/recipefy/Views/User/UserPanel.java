package it.unipv.po.recipefy.Views.User;

import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserPanel extends JPanel implements MainPanel {
    private JScrollPane scrollPane;
    private JPanel viewport;

    public UserPanel(MainFrameController mfc) throws IOException, SQLException {
        this.setLayout(new BorderLayout());

        // Create UserNavBar
        UserNavBar userNavBar = new UserNavBar(mfc);

        // Create an empty panel to serve as the scrollable viewport
        viewport = new JPanel();
        viewport.setLayout(new BorderLayout());

        // Create a JScrollPane and set the viewport
        scrollPane = new JScrollPane(viewport);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        updateCenterPanel(new AllPanel(this, mfc));
        // Add UserNavBar to the NORTH of the JScrollPane
        scrollPane.setColumnHeaderView(userNavBar);

        // Add the JScrollPane to the UserPanel
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void updateCenterPanel(JPanel panel) {
        viewport.removeAll();
        viewport.add(panel, BorderLayout.CENTER);
        viewport.revalidate();
        viewport.repaint();
    }

    @Override
    public JPanel getPanel() {
        return this;
    }
}
