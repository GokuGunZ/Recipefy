package Models;


import Beans.Recipe;
import Utility.DatabaseConnection;

import java.sql.*;

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
    public RecipeModel(int recipeID, int userID, String title, String thumbUrl, int recipeDetailsID){
        this.recipeID = recipeID;
        this.userID = userID;
        this.title = title;
        this.thumbUrl = thumbUrl;
        this.recipeDetailsID = recipeDetailsID;
    }
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
    public int getUserID() {return userID;};
    public int getRecipeID() {return recipeID;};
    public String getTitle() {return title;};
    public String getThumbUrl() {return thumbUrl;};
    public int getRecipeDetailsID() {return recipeDetailsID;};
}
