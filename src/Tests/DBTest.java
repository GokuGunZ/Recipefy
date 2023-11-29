package Tests;

import Utility.DatabaseConnection;
import Views.MainFrame.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    public DBTest() throws SQLException {
        Connection DBConn = DatabaseConnection.getInstance();
        String selectUserQuery = "SELECT * FROM User WHERE Username = ? AND Password = ?";
        PreparedStatement preparedStatement = DBConn.prepareStatement(selectUserQuery);
        preparedStatement.setString(1, "JohnDoe");
        preparedStatement.setString(2, "password123");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int retrievedUserID = resultSet.getInt("UserID");
            String username = resultSet.getString("Username");
            System.out.println("User ID: " + retrievedUserID + ", Username: " + username);

        }
        resultSet.close();
        preparedStatement.close();

    }

    public static void main(String[] args) throws SQLException {
        new DBTest();
    }
}
