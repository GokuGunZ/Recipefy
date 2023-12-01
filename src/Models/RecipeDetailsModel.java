package Models;

import Beans.RecipeDetail;
import Utility.DatabaseConnection;
import Views.Recipe.CreatePanel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RecipeDetailsModel {

    public static int createRecipeDetail(int recipeID, CreatePanel createPanel) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "INSERT INTO recipeDetail (RecipeID, Title, Description, Ingredients, Instruction, PreparationTime, CookingTime, DifficultyLevel, CuisineType, NutritionalAttribute, CaloricInfo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, recipeID);
        preparedStatement.setString(2, createPanel.getTitle());
        preparedStatement.setString(3, createPanel.getDescription());
        JSONArray ingredientsArray = collectIngredientsData(createPanel.getIngredientPanel());
        preparedStatement.setString(4, ingredientsArray.toString());
        JSONArray instructionsArray = collectInstructionsData(createPanel.getInstructionPanel());
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

    public static RecipeDetail getRecipeDetailByRecipeID(int recipeID) throws SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM recipeDetail WHERE recipeID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setInt(1, recipeID);
        ResultSet resultSet = preparedStatement.executeQuery();
        RecipeDetail recipeDetail = null;
        while (resultSet.next()) {
            recipeDetail = new RecipeDetail(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return recipeDetail;
    }

    // Inside your RecipeCreationView class
    private static JSONArray collectIngredientsData(JPanel ingredientPanel) {
        JSONArray ingredientsArray = new JSONArray();

        for (Component component : ingredientPanel.getComponents()) {
            if (component instanceof JPanel) {
                JSONObject ingredientObject = new JSONObject();
                JPanel ingredientComponent = (JPanel) component;
                String fieldLabel = "";
                for (Component field : ingredientComponent.getComponents()) {
                    if (field instanceof JLabel){
                        fieldLabel = ((JLabel) field).getText();
                    }
                    if (field instanceof JTextField) {
                        JTextField textField = (JTextField) field;
                        ingredientObject.put(fieldLabel, textField.getText());
                    }
                }
                ingredientsArray.put(ingredientObject);
            }
        }
        return ingredientsArray;
    }
    private static JSONArray collectInstructionsData(JPanel instructionPanel) {
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

    public static class RecipeIngredients{
        public RecipeIngredients(String jsonIngredients){
            JSONArray ingredientsArray = new JSONArray(jsonIngredients);
        }


    }
}
