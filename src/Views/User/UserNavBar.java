package Views.User;

import Controllers.MainFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserNavBar extends JPanel {
    MainFrameController mfc;

    public UserNavBar(UserPanel userPanel, MainFrameController mfc){
        this.mfc = mfc;
        this.setLayout(new BorderLayout());
        JPanel userInfoPanel = new JPanel();
        JButton UserInfoBtn = new JButton("User Information");
        UserInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.updateCenterPanel(new ReadPanel(userPanel, mfc));
            }
        });
        userInfoPanel.add(UserInfoBtn);
        this.add(UserInfoBtn, BorderLayout.WEST);

        JPanel navPanel = new JPanel(new BorderLayout());
        JButton allPanel = new JButton("All");
        JButton catPanel = new JButton("Category");
        JButton dietPanel = new JButton("Diet");
        allPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.updateCenterPanel(new AllPanel(userPanel, mfc));
            }
        });
        catPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.updateCenterPanel(new CategoryPanel());
            }
        });
        dietPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.updateCenterPanel(new DietPanel());
            }
        });
        navPanel.add(allPanel, BorderLayout.WEST);
        navPanel.add(catPanel, BorderLayout.CENTER);
        navPanel.add(dietPanel, BorderLayout.EAST);
        this.add(navPanel, BorderLayout.CENTER);
    }
}
