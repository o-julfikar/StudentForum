package controller;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import java.util.LinkedList;
import model.ConsoleModel;
import view.DialogForm;
import view.ErrorPanel;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: ConsoleController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class ConsoleController {
    public static LinkedList<Object[]> getData(Dialog parentDialog, String query) {
        LinkedList<Object[]> dataObjects = ConsoleModel.getData(query);
        if (dataObjects == null) {
            ErrorPanel errorPanel = new ErrorPanel("Failed to get data. Please try again!");
            new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return dataObjects;
    }
    
    public static boolean updateData(Dialog parentDialog, String query) {
        if (ConsoleModel.updateData(query)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to get data. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
}
