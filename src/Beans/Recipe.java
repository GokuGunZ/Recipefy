package Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Recipe {
    int recipeID;
    int userID;
    String title;
    int recipeDetailID;
    int originalRecipeID;
    String imagePath;
    RecipeDetail recipeDetail;

    public Recipe(int recipeID, int userID, String title, int recipeDetailID, String imagePath){
        this.recipeID = recipeID;
        this.userID = userID;
        this.title = title;
        this.recipeDetailID = recipeDetailID;
        this.imagePath = imagePath;
    }

    public Recipe(ResultSet resultSet) throws SQLException {
        this.recipeID = resultSet.getInt("RecipeID");
        this.userID = resultSet.getInt("UserID");
        this.title = resultSet.getString("Title");
        this.recipeDetailID = resultSet.getInt("RecipeDetailID");
        this.originalRecipeID = resultSet.getInt("OriginalRecipeID");
        this.imagePath = resultSet.getString("ImagePath");
    }
    public void setRecipeDetail(RecipeDetail recipeDetail){
        this.recipeDetail = recipeDetail;
    }
    public String getTitle() {return this.title;}
    public int getUserID() {return this.userID;}
    public int getRecipeID() { return this.recipeID;}

    public int getRecipeDetailID() {return this.recipeDetailID;}

    public int getOriginalRecipeID() {return this.originalRecipeID;}

    public String getImagePath() {return this.imagePath;}

    public RecipeDetail getRecipeDetail() {return this.recipeDetail;}

}
