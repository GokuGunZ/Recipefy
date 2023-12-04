package Views.Recipe;

import Beans.Recipe;
import Controllers.MainFrameController;
import Views.User.UserPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CardGridShower extends JPanel {
    private final UserPanel userPanel;
    private List<Recipe> allRecipes;
    private MainFrameController mfc;
    public CardGridShower(MainFrameController mfc, UserPanel userPanel){
        this.mfc = mfc;
        this.userPanel = userPanel;
        setBorder(new EmptyBorder(30,30,30,30));
    }
    public void displayRecipes() throws IOException {
        this.setLayout(new GridLayout(0, 3, 50, 50));
        for (Recipe recipe: allRecipes)
        {
            this.add(new CardPanel(mfc, recipe.getRecipeID(), recipe.getTitle(), recipe.getImagePath(), userPanel));
        }
    }
    public void setAllRecipes(List<Recipe> allRecipes){
        this.allRecipes = allRecipes;
    }
}