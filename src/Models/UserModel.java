package Models;

import Beans.User;
import Controllers.MainFrameController;
import Utility.DataValidator;
import Utility.DatabaseConnection;

import javax.swing.*;
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
    int userID;
    public String username;
    String email;
    String Password;
    //Enumeration UserType;
    RecipeModels[] RecipeList;
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
            throw new RuntimeException("Creating user failed, no rows affected.");
        }
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        User authedUser = null;
        authedUser = new User(generatedKeys.getInt(1), username, email);
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
        return psw.equals(password);
    }
    @Override
    public void updateModel(List<Object> attributes) throws SQLException {
        User user = mfc.getUser();
        String newPass = (String) attributes.get(5);
        if (!DataValidator.isStrongPassword(newPass)){
            JOptionPane.showMessageDialog(null, "La nuova password deve essere lunga almeno 8 caratteri e contenere un numero!");
            return;
        }
        String psw = (String) attributes.get(6);
        if (checkPassword(user.getUserID(), psw)){
            Connection DBConn = DatabaseConnection.getInstance();
            String selectUserQuery = "UPDATE user SET username = ?, email = ?, password = ? where UserID = ?";
            PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, (String) attributes.get(0));
            preparedStatement.setString(2, (String) attributes.get(4));
            preparedStatement.setString(3, (String) attributes.get(5));
            preparedStatement.setInt(4, user.getUserID());
            int updatedRows = preparedStatement.executeUpdate();
        } else {
            JOptionPane.showMessageDialog(null, "La Password inserita non è corretta!");
        }
    }
}

class Chef extends UserModel {
    int RestaurantID;
    public Chef(MainFrameController mfc) {
        super(mfc);
    }
}
