package Controllers;

import Beans.Recipe;
import Beans.RecipeDetail;
import Models.RecipeDetailsModel;
import Models.RecipeModel;
import Views.Recipe.CreatePanel;
import Views.Recipe.ReadPanel;
import Views.User.UserPanel;

import javax.swing.*;
import java.sql.SQLException;

public class RecipeController {
    public static boolean createRecipe(CreatePanel cP) throws SQLException{
        int recipeID = RecipeModel.createRecipe(cP.mfc.getUser().getUserID(), cP.getTitle());
        int recipeDetailsID = RecipeDetailsModel.createRecipeDetail(recipeID, cP);
        RecipeModel.addRecipeDetail(recipeID, recipeDetailsID);
        JOptionPane.showMessageDialog(null, "Created successfully!");
        return true;
    }

    public static void showRecipe(MainFrameController mfc, int recipeID, UserPanel userPanel) throws SQLException {
        Recipe recipe = RecipeModel.getRecipeByID(recipeID);
        RecipeDetail recipeDetail = RecipeDetailsModel.getRecipeDetailByRecipeID(recipeID);
        recipe.setRecipeDetail(recipeDetail);
        userPanel.updateCenterPanel(new ReadPanel(mfc, recipe));
    }
}
