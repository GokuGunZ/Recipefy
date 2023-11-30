package Views.User;

import Controllers.MainFrameController;
import Views.Recipe.CreatePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllPanel extends JPanel {
    MainFrameController mfc;
    public AllPanel(UserPanel userPanel, MainFrameController mfc){
        this.mfc=mfc;
        this.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton newRecipe = new JButton("New Recipe");
        newRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.updateCenterPanel(new CreatePanel(mfc));
            }
        });
        buttonPanel.add(newRecipe, BorderLayout. EAST);
        this.add(buttonPanel, BorderLayout.NORTH);

        JPanel recipePanel = new JPanel(new GridLayout());

        this.add(recipePanel, BorderLayout.CENTER);
    }
}
