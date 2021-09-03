package controller;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import model.swap.CourseModel;
import view.DialogForm;
import view.ErrorPanel;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: CourseController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class CourseController {
    
    public static boolean addCourse(Dialog parentDialog, String courseCode, String courseTitle) {
        if (CourseModel.addCourse(courseCode, courseTitle)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to add the course. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean addCourseWithSection(Dialog parentDialog, String courseCode, String courseTitle, String courseSection) {
        if (CourseModel.addCourseWithSection(courseCode, courseTitle, courseSection)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to add the course and section. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean addCourseSection(Dialog parentDialog, String courseCode, String courseSection) {
        if (CourseModel.addCourseSection(courseCode, courseSection)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to add sections(s). Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }

}
