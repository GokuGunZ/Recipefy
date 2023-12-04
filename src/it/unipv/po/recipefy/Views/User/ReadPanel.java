package it.unipv.po.recipefy.Views.User;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Views.UIComponents.AttributeShower;

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
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JPanel updatePanel = new JPanel(new BorderLayout());
        JButton updateBtn = new JButton("Update your information");


        add(new AttributeShower("Name", user.getName(), 25));
        add(new AttributeShower("Bio", user.getBio(), 20));
        add(new AttributeShower("Preferenze", "To be implemented", 20));
        add(new AttributeShower("Allergeni", "To be implemented", 20));
        add(new AttributeShower("eMail", user.getEmail(), 20));
        setBorder(new EmptyBorder(15,110,30,110));

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserPanel userPanel = (UserPanel) mfc.getMainPanel();
                userPanel.updateCenterPanel(new UpdatePanel(user, mfc));
            }
        });
        updatePanel.add(updateBtn, BorderLayout.SOUTH);
        add(updatePanel);


    }
}
