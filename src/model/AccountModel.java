package model;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JPanel;
import view.ErrorPanel;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: AccountModel.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class AccountModel {

    public static boolean updateUserPassword() {
        return Database.updateWith(User.getUser().getUpdatePasswordQuery());
    }

    public static boolean updateUserInfo() {
        return Database.updateWith(User.getUser().getUpdateInfoQuery());
    }
    
    public static ErrorPanel getLoginError(String userID, String userPassword) {
        String loginQuery = String.format("SELECT * FROM student WHERE std_id = '%s' AND std_password = '%s'", userID, userPassword);
        ErrorPanel loginResult = null;
        User user = null;
        try {
            ResultSet result = Database.getResultOf(loginQuery);
            
            if (result != null && result.next()) {
                String name, departmentString, semesterString, phone, gmail, photoURL;
                int role, status;
                Date birthdate;
                name = result.getString("std_name");
                birthdate = result.getDate("std_birthdate");
                departmentString = result.getString("std_department");
                semesterString = result.getString("std_semester");
                phone = result.getString("std_phone");
                gmail = result.getString("std_gmail");
                photoURL = result.getString("std_photo");
                role = result.getInt("std_role");
                status = result.getInt("acc_status");
                Department department = new Department(departmentString);
                Semester semester = new Semester(semesterString);
                user = new User(Integer.parseInt(userID), name, birthdate, department, semester, phone, gmail, userPassword, photoURL, role, status);
                User.login(user);
            } else if (result == null) {
                loginResult = new ErrorPanel("Failed to connect. Please check your internet connection and try again!");
            } else {
                loginResult = new ErrorPanel("ID and password did not match any record");
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (result.next())");
            loginResult = new ErrorPanel("Failed to connect. Please check your internet connection and try again!");
        } catch (Exception e) {
            return new ErrorPanel(e.getMessage());
        }
        return loginResult;
    }
    
    public static boolean registerUser(String userID, String userName, String birthDate, 
            String department, String semester, String phone, String email, String password,
            String photo, int role) {
        
        String insertQuery = String.format("INSERT INTO student VALUES(%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, 0)", 
                userID, userName, birthDate, department, semester, phone, email, password, photo, role);
        
        return Database.updateWith(insertQuery);
    }
    
}
