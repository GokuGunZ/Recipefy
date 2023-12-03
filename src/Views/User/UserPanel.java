package Views.User;

import Controllers.MainFrameController;
import Views.MainFrame.MainPanel;

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
        scrollPane.setSize(new Dimension(1000, 800));
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
