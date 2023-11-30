package Views.Recipe;

import Models.RecipeModel;
import Views.User.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CardGridShower extends JPanel {
    private final UserPanel userPanel;
    private List<RecipeModel> allRecipes;
    public CardGridShower(UserPanel userPanel){this.userPanel = userPanel;}
    public void displayRecipes() throws IOException {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));
        for (RecipeModel recipe: allRecipes)
        {
            this.add(new CardPanel(recipe.getRecipeID(), recipe.getTitle(), recipe.getThumbUrl(), userPanel));
        }
    }
    public void setAllRecipes(List<RecipeModel> allRecipes){
        this.allRecipes = allRecipes;
    }
}
