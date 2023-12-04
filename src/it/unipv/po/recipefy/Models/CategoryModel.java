package it.unipv.po.recipefy.Models;


import it.unipv.po.recipefy.Beans.Category;
import it.unipv.po.recipefy.Utility.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * @Property Int TagID
 * @Property Int UserID
 * @Property String CategoryName
 * @Property String Tag
 * ---- Recipe[ ] Recipe <---- Relationship Recipe<->Category
 *
 * @Method Bool AssociateRecipes(int RecipeID)
 *
 */
public class CategoryModel {
    public static List<Category> retrieveAllCategories(int userID) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM categorytag WHERE UserID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setInt(1, userID);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Category> allCategories = new ArrayList<>();
        while(resultSet.next()){
            allCategories.add(new Category(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4)));
        }
        return allCategories;
    }
}
