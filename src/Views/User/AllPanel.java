package Views.User;

import Controllers.MainFrameController;
import Controllers.UserController;
import Views.Recipe.CardGridShower;
import Views.Recipe.CreatePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class AllPanel extends JPanel {
    MainFrameController mfc;
    public AllPanel(UserPanel userPanel, MainFrameController mfc) throws IOException, SQLException {
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

        CardGridShower recipePanel = new CardGridShower(userPanel);
        UserController userController = new UserController(mfc.getUser().getUserID());
        userController.setRecipePanel(recipePanel);
        userController.loadRecipesForUser();

        this.add(recipePanel, BorderLayout.CENTER);
    }
}
