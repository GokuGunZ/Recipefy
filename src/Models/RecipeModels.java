package Models;


import Beans.User;
import Utility.DatabaseConnection;
import Views.Recipe.CreatePanel;

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
public class RecipeModels {
    int RecipeID;
    int UserID;
    String Title;
    int RecipeDetailsID;
    public static int createRecipe(String title) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "INSERT INTO recipe (UserID, Title) VALUES (?, ?)";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, 0);
        preparedStatement.setString(2, title);
        int insertedRows = preparedStatement.executeUpdate();
        if (insertedRows == 0) {
            throw new RuntimeException("Creating recipe failed, no rows affected.");
        }
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }
}
