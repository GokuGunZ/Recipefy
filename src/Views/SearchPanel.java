package Views;

import Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;

public class SearchPanel implements MainPanel {
    private JPanel panel;

    public SearchPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Search Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel(){
        return panel;
    }
}
