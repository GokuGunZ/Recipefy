package Controllers;

import Models.RecipeModels;
import Views.Recipe.CreatePanel;

import javax.swing.*;
import java.sql.SQLException;

public class RecipeController {
    public static boolean createRecipe(CreatePanel cP) throws SQLException{
        int recipeID = RecipeModels.createRecipe(cP.getTitle());
        JOptionPane.showMessageDialog(null, "Created successfully!"+recipeID);
        return true;
    }
}
