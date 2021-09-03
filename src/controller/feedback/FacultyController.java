package controller.feedback;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import model.feedback.FacultyModel;
import view.DialogForm;
import view.ErrorPanel;
import view.feedback.FeedbackCard;
import view.feedback.ReviewCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: FacultyController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class FacultyController {

    public static boolean insertFaculty(Dialog parentDialog, String facultyName, String facultyInitial, String facultyImg) {
        if (FacultyModel.insertFaculty(facultyName, facultyInitial, facultyImg)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to add the Faculty. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
}
