package Views.User;

import Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;

public class UserPanel implements MainPanel {
    private JPanel panel;

    public UserPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("User Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel(){
        return panel;
    }
}
