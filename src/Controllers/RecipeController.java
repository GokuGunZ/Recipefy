package Controllers;

import Beans.Recipe;
import Beans.RecipeDetail;
import Models.RecipeDetailsModel;
import Models.RecipeModel;
import Views.Recipe.CreatePanel;
import Views.Recipe.ReadPanel;
import Views.User.UserPanel;

import javax.swing.*;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class RecipeController {
    public static int createRecipe(CreatePanel cP) throws SQLException, URISyntaxException {
        int recipeID = RecipeModel.createRecipe(cP.mfc.getUser().getUserID(), cP.getTitle(), cP.getImagePath());
        int recipeDetailsID = RecipeDetailsModel.createRecipeDetail(recipeID, cP);
        RecipeModel.addRecipeDetail(recipeID, recipeDetailsID);
        cP.saveImage();
        JOptionPane.showMessageDialog(null, "Created successfully!");
        return recipeID;
    }

    public static void showRecipe(MainFrameController mfc, int recipeID, UserPanel userPanel) throws SQLException {
        Recipe recipe = RecipeModel.getRecipeByID(recipeID);
        RecipeDetail recipeDetail = RecipeDetailsModel.getRecipeDetailByRecipeID(recipeID);
        recipe.setRecipeDetail(recipeDetail);
        userPanel.updateCenterPanel(new ReadPanel(mfc, recipe));
    }
}
