package Views.User;

import Controllers.MainFrameController;
import Controllers.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class UserNavBar extends JPanel {
    MainFrameController mfc;

    public UserNavBar(MainFrameController mfc){
        this.mfc = mfc;
        this.setLayout(new BorderLayout());
        JPanel userInfoPanel = new JPanel();
        JButton UserInfoBtn = new JButton("User Information");
        UserInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserPanel userPanel = (UserPanel) mfc.getMainPanel();
                userPanel.updateCenterPanel(new ReadPanel(mfc));
            }
        });
        userInfoPanel.add(UserInfoBtn);
        this.add(UserInfoBtn, BorderLayout.WEST);

        JPanel navPanel = new JPanel(new BorderLayout());
        JButton allBtn = new JButton("All");
        JButton catBtn = new JButton("Category");
        JButton dietBtn = new JButton("Diet");
        allBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserPanel userPanel = (UserPanel) mfc.getMainPanel();
                    userPanel.updateCenterPanel(new AllPanel(userPanel, mfc));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        catBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController userController = mfc.getUserController();
                userController.setMainFrameController(mfc);
                try {
                    userController.renderCategoryPage();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        dietBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserPanel userPanel = (UserPanel) mfc.getMainPanel();
                userPanel.updateCenterPanel(new DietPanel());
            }
        });
        navPanel.add(allBtn, BorderLayout.WEST);
        navPanel.add(catBtn, BorderLayout.CENTER);
        navPanel.add(dietBtn, BorderLayout.EAST);
        this.add(navPanel, BorderLayout.CENTER);
    }
}
