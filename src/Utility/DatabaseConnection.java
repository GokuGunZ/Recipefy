package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection instance;
    private static final String url = "jdbc:mysql://localhost:3306/recipefy?serverTimezone=UTC";
    private static final String username = "admin";
    private static final String password = "RecipefyAdmin";

    private DatabaseConnection() {}



    public static Connection getInstance() throws SQLException {
        if (instance == null){
            instance = DriverManager.getConnection(url, username, password);
        }
        return instance;
    }
}
