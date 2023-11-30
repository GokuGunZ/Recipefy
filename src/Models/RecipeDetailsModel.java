package Models;

import Utility.DatabaseConnection;
import Views.Recipe.CreatePanel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RecipeDetailsModel {
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
    String[] nutritionalAttributes;
    //Enumeration MealType;
    String caloricInfo;
    double Ratings;

    public static int createRecipeDetail(int recipeID, CreatePanel createPanel) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "INSERT INTO recipeDetail (RecipeID, Title, Description, Ingredients, Instruction, PreparationTime, CookingTime, DifficultyLevel, CuisineType, NutritionalAttribute, CaloricInfo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, recipeID);
        preparedStatement.setString(2, createPanel.getTitle());
        preparedStatement.setString(3, createPanel.getDescription());
        JSONArray ingredientsArray = collectIngredientsData(createPanel.getIngredientPanel());
        preparedStatement.setString(4, ingredientsArray.toString());
        JSONArray instructionsArray = collectIngredientsData(createPanel.getInstructionPanel());
        preparedStatement.setString(5, instructionsArray.toString());
        preparedStatement.setInt(6, createPanel.getPrepTime());
        preparedStatement.setInt(7, createPanel.getCookTime());
        preparedStatement.setString(8, createPanel.getDifficulty());
        preparedStatement.setString(9, createPanel.getCuisine());
        preparedStatement.setString(10, createPanel.getNutritionalList().getSelectedValuesList().toString());
        preparedStatement.setString(11, createPanel.getCaloricInfo());
        int insertedRows = preparedStatement.executeUpdate();
        if (insertedRows == 0) {
            throw new RuntimeException("Creating recipe failed, no rows affected.");
        }
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }


    // Inside your RecipeCreationView class
    private static JSONArray collectIngredientsData(JPanel ingredientPanel) {
        JSONArray ingredientsArray = new JSONArray();

        for (Component component : ingredientPanel.getComponents()) {
            if (component instanceof JPanel) {
                JSONObject ingredientObject = new JSONObject();
                JPanel ingredientComponent = (JPanel) component;

                for (Component field : ingredientComponent.getComponents()) {
                    if (field instanceof JTextField) {
                        JTextField textField = (JTextField) field;
                        String text = textField.getText();
                        ingredientObject.put("qty", text);
                        textField = (JTextField) field;
                        text = textField.getText();
                        ingredientObject.put("unit", text);
                        textField = (JTextField) field;
                        text = textField.getText();
                        ingredientObject.put("entity", text);
                    }
                }
                ingredientsArray.put(ingredientObject);
            }
        }
        return ingredientsArray;
    }
    private JSONArray collectInstructionsData(JPanel instructionPanel) {
        JSONArray instructionsArray = new JSONArray();

        Component[] components = instructionPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel instructionStepPanel = (JPanel) component;

                for (Component field : instructionStepPanel.getComponents()) {
                    if (field instanceof JTextArea) {
                        JTextArea textArea = (JTextArea) field;
                        String text = textArea.getText();
                        instructionsArray.put(text);
                    }
                }
            }
        }
        return instructionsArray;
    }
}
