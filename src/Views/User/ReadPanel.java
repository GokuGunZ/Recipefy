package Views.User;

import Beans.User;
import Controllers.MainFrameController;
import Views.UIComponents.AttributeShower;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPanel extends JPanel {
    private MainFrameController mfc;
    private User user;
    public ReadPanel(MainFrameController mfc){
        this.mfc = mfc;
        user = mfc.getUser();
        this.setLayout(new BorderLayout());
        JPanel updatePanel = new JPanel(new BorderLayout());
        JButton updateBtn = new JButton("Update your information");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserPanel userPanel = (UserPanel) mfc.getMainPanel();
                userPanel.updateCenterPanel(new UpdatePanel(user, mfc));
            }
        });
        updatePanel.add(updateBtn, BorderLayout.EAST);
        this.add(updatePanel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.Y_AXIS));
        infoPanel.add(new AttributeShower("Nome", user.getName(), 25));
        infoPanel.add(new AttributeShower("Bio", user.getBio(), 20));
        infoPanel.add(new AttributeShower("Preferenze", "To be implemented", 20));
        infoPanel.add(new AttributeShower("Allergeni", "To be implemented", 20));
        infoPanel.add(new AttributeShower("eMail", user.getEmail(), 20));
        infoPanel.setBorder(new EmptyBorder(5,150,30,20));
        this.add(infoPanel, BorderLayout.CENTER);

    }
}
