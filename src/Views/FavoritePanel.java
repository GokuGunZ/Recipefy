package Views;

import Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;

public class FavoritePanel  implements MainPanel {
    private JPanel panel;

    public FavoritePanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Favorite Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel(){
        return panel;
    }
}
