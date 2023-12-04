package Beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    String difficultyLevel;
    //Enumeration DifficultyLevel;
    String cuisineType;
    //Enumeration CuisineType;
    String nutritionalAttributes;
    //Enumeration MealType;
    String caloricInfo;
    double ratings;

    public RecipeDetail(ResultSet resultSet) throws SQLException{
        this.recipeDetailID = resultSet.getInt(1);
        this.recipeID = resultSet.getInt(2);
        this.description = resultSet.getString(4);
        this.ingredients = resultSet.getString(6);
        this.instruction = resultSet.getString(7);
        this.preparationTime = resultSet.getString(8);
        this.cookingTime = resultSet.getString(9);
        this.totalTime = resultSet.getString(10);
        this.difficultyLevel = resultSet.getString(11);
        this.cuisineType = resultSet.getString(12);
        this.nutritionalAttributes = resultSet.getString(13);
        this.caloricInfo = resultSet.getString(14);
        this.ratings = resultSet.getInt(15);

    }

    public static class Ingredient {
        private String Qty;
        private String Unit;
        private String Entity;

        public String getQty() {return Qty;}

        public void setQty(String qty) {Qty = qty;}

        public String getUnit() {return Unit;}

        public void setUnit(String unit) {Unit = unit;}

        public String getEntity() {return Entity;}

        public void setEntity(String entity) {Entity = entity;}
        @JsonCreator
        public Ingredient(
                @JsonProperty("Qty:") String qty,
                @JsonProperty("Unit:") String unit,
                @JsonProperty("Entity:") String entity) {
            this.Qty = qty;
            this.Unit = unit;
            this.Entity = entity;
        }
    }
    public int getRecipeDetailID() { return this.recipeDetailID; }
    public int getRecipeID() { return this.recipeID; }
    public String getDescription() { return this.description; }
    public String getIngredients() { return this.ingredients; }
    public String getInstruction() { return this.instruction; }
    public String getPreparationTime() { return this.preparationTime; }
    public String getCookingTime() { return this.cookingTime; }
    public String getTotalTime() { return this.totalTime; }
    public String getDifficultyLevel() { return this.difficultyLevel; }
    public String getCuisineType() { return this.cuisineType; }
    public String getNutritionalAttributes() { return this.nutritionalAttributes; }
    public String getCaloricInfo() { return this.caloricInfo; }
    public double getRatings() { return this.ratings; }

}
