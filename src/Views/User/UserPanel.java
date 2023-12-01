package Views.User;

import Controllers.MainFrameController;
import Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserPanel extends JPanel implements MainPanel{
    private JPanel centerPanel;

    public UserPanel(MainFrameController mfc) throws IOException, SQLException {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("User Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
        this.add(new UserNavBar(mfc), BorderLayout.NORTH);
        centerPanel = new AllPanel(this, mfc);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    public void updateCenterPanel(JPanel panel){
        centerPanel.removeAll();
        centerPanel.add(panel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public JPanel getPanel(){
        return this;
    }
}
