package Models;


import Beans.Recipe;
import Utility.DatabaseConnection;

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
public class RecipeModel {
    int recipeID;
    int userID;
    String title;
    String thumbUrl;
    int recipeDetailsID;

    public static int createRecipe(int userID, String title) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "INSERT INTO recipe (UserID, Title) VALUES (?, ?)";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, userID);
        preparedStatement.setString(2, title);
        int insertedRows = preparedStatement.executeUpdate();
        if (insertedRows == 0) {
            throw new RuntimeException("Creating recipe failed, no rows affected.");
        }
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }

    public static boolean addRecipeDetail(int recipeID, int recipeDetailsID) throws  SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "UPDATE recipe SET recipeDetailsID = ? WHERE recipeID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, recipeDetailsID);
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
}
