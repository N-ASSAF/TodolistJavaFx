package appli.todolistjx.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connectDatabase() throws SQLException {
        Connection maConnection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/todolist","root","");
        return maConnection;
    }
}
