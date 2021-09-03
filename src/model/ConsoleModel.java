package model;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: ConsoleModel.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class ConsoleModel {
    public static LinkedList<Object[]> getData(String query) {
        LinkedList<Object[]> dataObjects = new LinkedList<>();
        try {
            ResultSet rs = Database.getResultOf(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            Object[] column = new Object[rsmd.getColumnCount()];
            for (int i = 0; i < column.length; i++) column[i] = rsmd.getColumnName(i + 1);
            dataObjects.add(column);
            while(rs.next()) {
                Object[] row = new Object[column.length];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                dataObjects.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (txtConsoleKeyReleased())");
        }
        return dataObjects;
    }
    
    public static boolean updateData(String query) {
        return  Database.updateWith(query);
    }
}
