package Controllers;

import Models.RecipeModel;
import Models.UserModel;
import Views.Recipe.CardGridShower;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private int userID;
    private CardGridShower cardGridShower;
    public UserController(int userID, CardGridShower cgs){
        this.userID = userID;
        this.cardGridShower = cgs;
    }
    public void loadRecipesForUser() throws SQLException, IOException {
        List<RecipeModel> recipes = UserModel.retrieveAllRecipes(userID);
        cardGridShower.setAllRecipes(recipes);
        cardGridShower.displayRecipes();
    }
}
