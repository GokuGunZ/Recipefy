package Views.User;

import Beans.User;
import Controllers.MainFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPanel extends JPanel {
    private MainFrameController mfc;
    private User user;
    public ReadPanel(UserPanel userPanel, MainFrameController mfc){
        this.mfc = mfc;
        user = mfc.getUser();
        this.setLayout(new BorderLayout());
        JPanel updatePanel = new JPanel(new BorderLayout());
        JButton updateBtn = new JButton("Update your information");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.updateCenterPanel(new UpdatePanel(user, mfc));
            }
        });
        updatePanel.add(updateBtn, BorderLayout.EAST);
        this.add(updatePanel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(5,2));
        infoPanel.add(new JLabel("Nome"));
        infoPanel.add(new JLabel(user.getName()));
        infoPanel.add(new JLabel("Bio"));
        infoPanel.add(new JLabel(user.getBio()));
        infoPanel.add(new JLabel("Preferenze"));
        infoPanel.add(new JLabel("To be implemented"));
        infoPanel.add(new JLabel("Allergeni"));
        infoPanel.add(new JLabel("To be implemented"));
        infoPanel.add(new JLabel("eMail"));
        infoPanel.add(new JLabel(user.getEmail()));
        this.add(infoPanel, BorderLayout.CENTER);

    }
}
