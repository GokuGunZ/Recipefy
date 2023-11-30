package Controllers;

import Models.RecipeDetailsModel;
import Models.RecipeModels;
import Views.Recipe.CreatePanel;

import javax.swing.*;
import java.sql.SQLException;

public class RecipeController {
    public static boolean createRecipe(CreatePanel cP) throws SQLException{
        int recipeID = RecipeModels.createRecipe(cP.mfc.getUser().getUserID(), cP.getTitle());
        int recipeDetailsID = RecipeDetailsModel.createRecipeDetail(recipeID, cP);
        RecipeModels.addRecipeDetail(recipeID, recipeDetailsID);
        JOptionPane.showMessageDialog(null, "Created successfully!");
        return true;
    }
}
