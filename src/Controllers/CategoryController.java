package Controllers;

import Beans.Category;
import Beans.Recipe;
import Models.RecipeModel;
import Views.Category._Manage;
import Views.Recipe.CardGridShower;
import Views.User.UserPanel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryController {
    public static void renderCategoryManager(List<Category> categories){
        new _Manage(categories);
    }

    public static void renderRecipeCategory(MainFrameController mfc, int tagID, UserPanel userPanel) throws SQLException, IOException {
        List<Integer> recipeIDsList = RecipeModel.getRecipeIDsByTag(tagID);
        if(!recipeIDsList.isEmpty()){
            List<Recipe> recipeList = RecipeModel.getRecipeByList(recipeIDsList);
            CardGridShower cgs = new CardGridShower(mfc, userPanel);
            cgs.setAllRecipes(recipeList);
            cgs.displayRecipes();
        }

    }
}
