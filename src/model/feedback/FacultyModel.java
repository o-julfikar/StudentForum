package model.feedback;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Database;
import view.feedback.FeedbackCard;
import view.feedback.ReviewCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: FacultyModel.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class FacultyModel {
    
    public static boolean insertFaculty(String facultyName, String facultyInitial, String facultyImg) {            
        String insertFacultyQuery = String.format("INSERT INTO faculty VALUES('%s', '%s', '%s')", facultyInitial, facultyName, facultyImg);
        
        return Database.updateWith(insertFacultyQuery);
    }
    
}
