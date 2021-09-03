package controller;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import java.awt.Frame;
import model.AccountModel;
import view.DialogForm;
import view.ErrorPanel;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: AccountController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class AccountController {
    
    public static boolean userLogin(Frame parentFrame, Dialog parentDialog, String userID, String userPassword) {
        ErrorPanel loginError = AccountModel.getLoginError(userID, userPassword);
        if (loginError == null) return true;
        
        if (parentDialog == null) new DialogForm(parentFrame, true, loginError, "Login failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, loginError, "Login failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean registerUser(Dialog parentDialog, String userID, String userName, 
            String birthDate, String department, String semester, String phone, String email, String password,
            String photo, int role) {
        
        if (AccountModel.registerUser(userID, userName, birthDate, department, semester, phone, email, password, photo, role)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to register the user. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Registration failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean updateUserPassword(Dialog parentDialog) {
        if (AccountModel.updateUserPassword()) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to update the user password. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Password did not changed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean updateUserInfo(Dialog parentDialog) {
        if (AccountModel.updateUserInfo()) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to update the user information. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "User information did not changed", true, true, true).setVisible(true);
        return false;
    }
    
}
