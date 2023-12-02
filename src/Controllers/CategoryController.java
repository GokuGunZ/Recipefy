package Controllers;

import Beans.Category;
import Beans.Recipe;
import Models.RecipeModel;
import Views.Category._Manage;
import Views.Recipe.CardGridShower;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryController {
    public static void renderCategoryManager(List<Category> categories){
        new _Manage(categories);
    }

    public static void renderRecipeCategory(MainFrameController mfc, int tagID, JPanel recipePanel) throws SQLException, IOException {
        List<Integer> recipeIDsList = RecipeModel.getRecipeIDsByTag(tagID);
        List<Recipe> recipeList = RecipeModel.getRecipeByList(recipeIDsList);
        CardGridShower cgs = new CardGridShower(mfc, recipePanel);
        cgs.setAllRecipes(recipeList);
        cgs.displayRecipes();

    }
}
