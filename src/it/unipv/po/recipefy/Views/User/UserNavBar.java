package it.unipv.po.recipefy.Views.User;

import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Factory.UserNavBarFactory.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserNavBar extends JPanel {
    MainFrameController mfc;
    UserPanel userPanel;

    public UserNavBar(MainFrameController mfc) throws SQLException, IOException {
        this.mfc = mfc;
        this.setLayout(new BorderLayout());


        JPanel userInfoPanel = new JPanel();
        JButton userInfoBtn = new JButton("Account Information");
        userInfoBtn.addActionListener(UserNavBarActionListenerFactory.getActionListener(mfc, ReadPanelListener.class));
        userInfoPanel.add(userInfoBtn);
        this.add(userInfoBtn, BorderLayout.WEST);

        JPanel navPanel = new JPanel(new BorderLayout());
        JButton allBtn = new JButton("My recipes");
        JButton catBtn = new JButton("Category");
        JButton dietBtn = new JButton("Diet");

        allBtn.addActionListener(UserNavBarActionListenerFactory.getActionListener(mfc, AllPanelListener.class));
        catBtn.addActionListener(UserNavBarActionListenerFactory.getActionListener(mfc, CategoryPanelListener.class));
        dietBtn.addActionListener(UserNavBarActionListenerFactory.getActionListener(mfc, DietPanelListener.class));

        navPanel.add(allBtn, BorderLayout.WEST);
        navPanel.add(catBtn, BorderLayout.CENTER);
        navPanel.add(dietBtn, BorderLayout.EAST);
        this.add(navPanel, BorderLayout.EAST);
    }
}
