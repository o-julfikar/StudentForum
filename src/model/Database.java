package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class Database {
    private static String connectionURL = "jdbc:mysql://localhost:3306/bspdb?autoReconnect=true", username = "root", password = "";
    private static Connection connection;
    private static Statement statement;
    
    private static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) connection = DriverManager.getConnection(connectionURL, username, password);
        return connection;
    }
    
    private static Statement getStatement() throws SQLException {
        return statement = getConnection().createStatement();
    }
    
    public static ResultSet getResultOf(String query) throws SQLException {
        return getStatement().executeQuery(query);
    }
    
    public static boolean updateWith(String query) {
        try {
            getStatement().executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println("#" + e.getErrorCode() + ": " + e.getMessage() + " (updateWith())");
            return false;
        }
    }
    
    public static boolean updateWithTransaction(String selectQuery, String... updateQueries) {
        try (Connection con = getConnection()) {
            con.setAutoCommit(false);
            getStatement().executeQuery(selectQuery);
            for (String updateQuery : updateQueries) getStatement().executeUpdate(updateQuery);
            con.commit();
            con.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (failedToRollback())");
            }
            System.out.println("#" + e.getErrorCode() + ": " + e.getMessage() + " (updateWithTransaction())");
            return false;
        }
    }
}
