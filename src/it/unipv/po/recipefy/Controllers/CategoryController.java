package it.unipv.po.recipefy.Controllers;

import it.unipv.po.recipefy.Beans.Category;
import it.unipv.po.recipefy.Beans.Recipe;
import it.unipv.po.recipefy.Models.RecipeModel;
import it.unipv.po.recipefy.Views.Category._Manage;
import it.unipv.po.recipefy.Views.Recipe.CardGridShower;
import it.unipv.po.recipefy.Views.User.UserPanel;

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
