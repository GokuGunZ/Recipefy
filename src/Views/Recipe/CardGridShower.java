package Views.Recipe;

import Beans.Recipe;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CardGridShower extends JPanel {
    private final JPanel panel;
    private List<Recipe> allRecipes;
    public CardGridShower(JPanel panel){this.panel = panel;}
    public void displayRecipes() throws IOException {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));
        for (Recipe recipe: allRecipes)
        {
            this.add(new CardPanel(recipe.getRecipeID(), recipe.getTitle(), recipe.getThumbImagePath(), panel));
        }
    }
    public void setAllRecipes(List<Recipe> allRecipes){
        this.allRecipes = allRecipes;
    }
}