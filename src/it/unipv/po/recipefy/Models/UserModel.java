package it.unipv.po.recipefy.Models;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Utility.DataValidator;
import it.unipv.po.recipefy.Utility.DatabaseConnection;
import it.unipv.po.recipefy.Views.User.ReadPanel;
import it.unipv.po.recipefy.Views.User.UserPanel;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.List;

/*
 * @Property Int UserID
 * @Property String Username
 * @Property String Email
 * @Property String Password
 * @Property Enumeration UserType
 * @Property Recipe[] RecipeList  <---- Relationship Recipe-User
 *
 * @Method Bool CreateRecipe(UserID)
 * @Method Bool UpdateRecipe(RecipeID)
 * @Method Bool DeleteRecipe(RecipeID)
 * @Method Bool CreateTag(UserID)
 * @Method Bool UpdateTag(TagID)
 * @Method Bool DeleteTag(TagID)
 * @Method Recipe[] GetAllRecipes(UserID)
 * @Method Category[] GetAllTags(UserID)
 * @Method Diet ReadReceivedDietPlan(DietID)
 *
 *
 * ---Specialization---
 * --------Chef-------
 * @Property int RestaurantID
 *
 * @Method Bool CreateRestaurant(UserID)
 * @Method Bool UpdateRestaurant(RestaurantID)
 * @Method Bool DeleteRestaurant(RestaurantID)
 * @Method Menu GetRestaurantMenu(RestaurantID)
 *
 * ------Dietitian-----
 * @Property Diet[] CreatedDietList <---- Relationship Diet-Dietitian
 *
 * @Method Bool CreateDiet(UserID)
 * @Method Bool ShareDiet(UserID, DietID)
 * @Method DietPlan GetDietPlan(DietID)
 *
 */
public class UserModel implements UpdateableModel{
    MainFrameController mfc;
    public String username;
    public UserModel(MainFrameController mfc){
        this.mfc = mfc;
    }

    public static boolean validateUser(String username, String password) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM User WHERE Username = ? AND Password = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isValid = false;
        isValid = resultSet.next();
        return isValid;
    }
    public static User getUserByUsername(String username) throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM User WHERE Username = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        User authedUser = null;
        while (resultSet.next()) {
            authedUser = new User(resultSet.getInt("UserID"), resultSet.getString("Username"), resultSet.getString("eMail"));
        }
        resultSet.close();
        preparedStatement.close();
        return authedUser;
    }

    public static boolean isUsernameValid(String username) throws SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM User WHERE Username = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isValid = false;
        isValid = resultSet.next();
        resultSet.close();
        preparedStatement.close();
        return !isValid;
    }

    public static boolean isEmailValid(String email) throws SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM User WHERE email = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isValid = false;
        isValid = resultSet.next();
        resultSet.close();
        preparedStatement.close();
        return !isValid;
    }

    public static User createUser(String username, String password, String email) throws SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "INSERT INTO user (username, email, password, usertype) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setInt(4, 1);
        int insertedRows = preparedStatement.executeUpdate();
        if (insertedRows == 0) {
            preparedStatement.close();
            throw new RuntimeException("Creating user failed, no rows affected.");
        }
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        User authedUser = null;
        authedUser = new User(generatedKeys.getInt(1), username, email);
        preparedStatement.close();
        return authedUser;
    }

    private boolean checkPassword(int id, String password) throws SQLException{
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM User WHERE UserID = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        String psw = null;
        while(resultSet.next()){
            psw = resultSet.getString("Password");
        }
        resultSet.close();
        preparedStatement.close();
        return psw.equals(password);
    }
    @Override
    public boolean updateModel(List<Object> attributes) throws SQLException {
        User user = mfc.getUser();
        int updatedRows = 0;
        String newPass = (String) attributes.get(5);
        if(newPass.isEmpty()){
            newPass = (String) attributes.get(6);
        } else if (!DataValidator.isStrongPassword(newPass)){
            JOptionPane.showMessageDialog(null, "New password must be 8 character long and contain at least one number!");
            return false;
        }
        String psw = (String) attributes.get(6);
        if (checkPassword(user.getUserID(), psw)){
            Connection DBConn = DatabaseConnection.getInstance();
            String updateUserQuery = "UPDATE user SET name = ?, bio = ?, email = ?, password = ? where UserID = ?";
            PreparedStatement preparedStatement = DBConn.prepareStatement(updateUserQuery);
            preparedStatement.setString(1, (String) attributes.get(0));
            preparedStatement.setString(2, (String) attributes.get(1));
            preparedStatement.setString(3, (String) attributes.get(4));
            preparedStatement.setString(4, newPass);
            preparedStatement.setInt(5, user.getUserID());
            updatedRows = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (updatedRows != 0){
                JOptionPane.showMessageDialog(null, "Information updated correctly!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error during the update");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Inserted old password is incorrect!");
            return false;
        }

    }

    @Override
    public void showModel(MainFrameController mfc) throws SQLException, IOException {
        UserPanel userPanel = (UserPanel) mfc.getMainPanel();
        userPanel.updateCenterPanel(new ReadPanel(mfc));
    }

}

class Chef extends UserModel {
    int RestaurantID;
    public Chef(MainFrameController mfc) {
        super(mfc);
    }
}
