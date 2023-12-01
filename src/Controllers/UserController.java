package Controllers;

import Beans.Category;
import Beans.Recipe;
import Models.CategoryModel;
import Models.RecipeModel;
import Views.Recipe.CardGridShower;
import Views.User.CategoryPanel;
import Views.User.UserPanel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private int userID;
    private CardGridShower cardGridShower;
    private MainFrameController mfc;
    public UserController(int userID){
        this.userID = userID;
    }
    public void loadRecipesForUser() throws SQLException, IOException {
        List<Recipe> recipes = RecipeModel.retrieveAllRecipes(userID);
        cardGridShower.setAllRecipes(recipes);
        cardGridShower.displayRecipes();
    }

    public void renderCategoryPage() throws SQLException {
        List<Category> categories = CategoryModel.retrieveAllCategories(userID);
        UserPanel userPanel = (UserPanel) mfc.getMainPanel();
        userPanel.updateCenterPanel(new CategoryPanel(mfc, categories));

    }

    public void setRecipePanel(CardGridShower cgs) {
        this.cardGridShower = cgs;
    }
    public void setMainFrameController(MainFrameController mfc) {this.mfc =mfc;}
}
