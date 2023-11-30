package Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDetail {
    int recipeDetailID;
    int recipeID;
    String description;
    String ingredients;
    String instruction;
    String preparationTime;
    String cookingTime;
    String totalTime;
    String difficultyLeve;
    //Enumeration DifficultyLevel;
    String cuisineType;
    //Enumeration CuisineType;
    String nutritionalAttributes;
    //Enumeration MealType;
    String caloricInfo;
    double Ratings;

    public RecipeDetail(ResultSet resultSet) throws SQLException{
        System.out.println("recipdetailid "+resultSet.getInt(1));
        this.recipeDetailID = resultSet.getInt(1);
        this.recipeID = resultSet.getInt(2);
        this.description = resultSet.getString(3);
        this.ingredients = resultSet.getString(5);
        this.instruction = resultSet.getString(6);
        this.preparationTime = resultSet.getString(7);
        this.cookingTime = resultSet.getString(8);
        this.totalTime = resultSet.getString(9);
        this.difficultyLeve = resultSet.getString(10);
        this.cuisineType = resultSet.getString(12);
        this.nutritionalAttributes = resultSet.getString(13);
        this.caloricInfo = resultSet.getString(14);
        this.Ratings = resultSet.getInt(15);

    }
}
