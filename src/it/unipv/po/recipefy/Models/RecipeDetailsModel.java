package it.unipv.po.recipefy.Models;

import it.unipv.po.recipefy.Beans.RecipeDetail;
import it.unipv.po.recipefy.Utility.DatabaseConnection;
import it.unipv.po.recipefy.Views.Recipe.CreatePanel;
import it.unipv.po.recipefy.Views.UIComponents.FormPanel;
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

    private static JSONArray collectIngredientsData(JPanel ingredientPanel) {
        JSONArray ingredientsArray = new JSONArray();

        for (Component component : ingredientPanel.getComponents()) {


            if (component instanceof JPanel) {
                JSONObject ingredientObject = new JSONObject();
                JPanel ingredientComponent = (JPanel) component;
                String fieldLabel = "";
                for (Component row : ingredientComponent.getComponents()) {
                    if (row instanceof FormPanel){
                        for (Component element : ((FormPanel) row).getComponents()){
                            if (element instanceof JLabel){
                                fieldLabel = ((JLabel) element).getText();
                            }
                            if (element instanceof JTextField) {
                                JTextField textField = (JTextField) element;
                                ingredientObject.put(fieldLabel, textField.getText());
                            }
                        }
                    }
                }
                ingredientsArray.put(ingredientObject);
            }
        }
        return ingredientsArray;
    }
    private static JSONArray collectInstructionsData(JPanel instructionPanel) {
        JSONArray instructionsArray = new JSONArray();
        String fieldLabel = "";
        Component[] components = instructionPanel.getComponents();
        for (Component component : components) {

            if (component instanceof JPanel) {
                JPanel instructionStepPanel = (JPanel) component;

                for (Component row : instructionStepPanel.getComponents()) {
                    if (row instanceof FormPanel){
                        JSONObject ingredientObject = new JSONObject();
                        for (Component element : ((FormPanel) row).getComponents()){
                            if (element instanceof JLabel){
                                fieldLabel = ((JLabel) element).getText();
                            }
                            if (element instanceof JTextField) {
                                JTextField textField = (JTextField) element;
                                String text = textField.getText();
                                ingredientObject.put(fieldLabel, text);
                            }
                        }
                        instructionsArray.put(ingredientObject);
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
