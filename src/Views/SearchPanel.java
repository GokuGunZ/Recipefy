package Views;

import Beans.User;
import Controllers.MainFrameController;
import Views.MainFrame.MainPanel;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel implements MainPanel {
    private User authedUser;

    public SearchPanel(MainFrameController mfc) {
        this.authedUser = mfc.getUser();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Search Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel(){
        return this;
    }
}
