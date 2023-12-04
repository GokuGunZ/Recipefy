package it.unipv.po.recipefy.Models;


import it.unipv.po.recipefy.Beans.Recipe;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Controllers.RecipeController;
import it.unipv.po.recipefy.Utility.DatabaseConnection;
import it.unipv.po.recipefy.Views.User.UserPanel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @Property Int RecipeID
 * @Property Int UserID
 * @Property String Title
 * @Property Int RecipeDetailsID
 * ---- Review[ ] Review List<---- RelationShip Recipe <-> Review
 *
 * @Method RecipeDetails GetRecipeDetails(int RecipeID)
 * @Method Bool ReviewRecipe(int RecipeID)
 * @Method Bool AddTag(int TagID)
 * @Method RecipeID[] FilterByAttribute(string Attribute)
 * @Method ReviewID[] GetReviewList(int Recipe ID)
 *
 */
public class RecipeModel implements UpdateableModel{
    int recipeID;
    int userID;
    String title;
    String thumbUrl;
    int recipeDetailsID;

    public RecipeModel(MainFrameController mfc) {

    }

    public static int createRecipe(int userID, String title, String imagePath) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "INSERT INTO recipe (UserID, Title, ImagePath) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, userID);
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, imagePath);
        int insertedRows = preparedStatement.executeUpdate();
        if (insertedRows == 0) {
            throw new RuntimeException("Creating recipe failed, no rows affected.");
        }
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }

    public static boolean addRecipeDetail(int recipeID, int recipeDetailID) throws  SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "UPDATE recipe SET recipeDetailID = ? WHERE recipeID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, recipeDetailID);
        preparedStatement.setInt(2, recipeID);
        int insertedRows = preparedStatement.executeUpdate();
        return true;
    }

    public static Recipe getRecipeByID(int recipeID) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM recipe WHERE recipeID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setInt(1, recipeID);
        ResultSet resultSet = preparedStatement.executeQuery();
        Recipe recipe = null;
        while (resultSet.next()) {
            recipe = new Recipe(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return recipe;
    }

    public static List<Recipe> retrieveAllRecipes(int userID) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM recipe WHERE UserID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setInt(1, userID);
        return getRecipes(preparedStatement);
    }
    public static List<Integer> getRecipeIDsByTag(int tagID) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM recipetag WHERE tagID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setInt(1, tagID);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> allRecipeIDs = new ArrayList<>();
        while(resultSet.next()){
            allRecipeIDs.add(resultSet.getInt("RecipeID"));
        }
        return allRecipeIDs;
    }

    public static List<Recipe> getRecipeByList(List<Integer> listRecipeIDs) throws  SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM recipe WHERE recipeID IN (");
        for (int i = 0; i < listRecipeIDs.size(); i++) {
            queryBuilder.append("?");
            if (i < listRecipeIDs.size() - 1) {
                queryBuilder.append(", ");
            }
        }
        queryBuilder.append(")");
        PreparedStatement preparedStatement = DBConn.prepareStatement(queryBuilder.toString());
        for (int i = 0; i < listRecipeIDs.size(); i++) {
            preparedStatement.setInt(i + 1, listRecipeIDs.get(i));
        }
        return getRecipes(preparedStatement);
    }

    private static List<Recipe> getRecipes(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Recipe> allRecipe = new ArrayList<>();
        while(resultSet.next()){
            allRecipe.add(new Recipe(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(6)));
        }
        return allRecipe;
    }

    public int getUserID() {return userID;};
    public int getRecipeID() {return recipeID;};
    public String getTitle() {return title;};
    public String getThumbUrl() {return thumbUrl;};
    public int getRecipeDetailsID() {return recipeDetailsID;};

    @Override
    public boolean updateModel(List<Object> attributes) throws SQLException {
        int recipeID = (Integer)attributes.get(0);
        Connection DBConn = DatabaseConnection.getInstance();
        String updateRecipeQuery = "UPDATE recipe SET title = ? where recipeID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(updateRecipeQuery);
        preparedStatement.setInt(2, recipeID);
        preparedStatement.setString(1, (String) attributes.get(1));
        int updatedRows = preparedStatement.executeUpdate();
        if (updatedRows != 1){
            JOptionPane.showMessageDialog(null, "Error during the update");
            preparedStatement.close();
            return false;
        }
        String updateRecipeDetailQuery = "UPDATE recipeDetail SET Title = ?, Description = ?, Ingredients = ?, Instruction = ?, PreparationTime = ?, CookingTime = ?, DifficultyLevel = ?, CuisineType = ?, NutritionalAttribute = ?, CaloricInfo = ? where recipeID = ?";
        preparedStatement = DBConn.prepareStatement(updateRecipeDetailQuery);
        preparedStatement.setInt(11, recipeID);
        preparedStatement.setString(1, (String) attributes.get(1));
        preparedStatement.setString(2, (String) attributes.get(2));
        preparedStatement.setString(3, (String) attributes.get(3));
        preparedStatement.setString(4, (String) attributes.get(4));
        preparedStatement.setInt(5, Integer.parseInt((String) attributes.get(5)));
        preparedStatement.setInt(6, Integer.parseInt((String) attributes.get(6)));
        preparedStatement.setString(7, (String) attributes.get(7));
        preparedStatement.setString(8, (String) attributes.get(8));
        preparedStatement.setString(9, (String) attributes.get(9));
        preparedStatement.setString(10, (String) attributes.get(10));
        updatedRows = preparedStatement.executeUpdate();
        preparedStatement.close();
        if (updatedRows != 0){
            JOptionPane.showMessageDialog(null, "Information updated correctly!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error during the update");
            return false;
        }
    }

    @Override
    public void showModel(MainFrameController mfc) throws SQLException {
        RecipeController.showRecipe(mfc, mfc.getRecipeID(), (UserPanel) mfc.getMainPanel());
    }
}