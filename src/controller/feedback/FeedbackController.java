package controller.feedback;

// <editor-fold defaultstate="collapsed" desc="Imports">

import controller.swap.Course;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import model.feedback.FacultyModel;
import model.feedback.FeedbackModel;
import view.DialogForm;
import view.ErrorPanel;
import view.feedback.FeedbackCard;
import view.feedback.ReviewCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: FeedbackController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class FeedbackController {
    
    public static double getReviewPoint(Frame parentFrame, Dialog parentDialog, String facultyInitial) {
        double review = FeedbackModel.getReviewPoint(facultyInitial);
        if (review < 0) {
            ErrorPanel errorPanel = new ErrorPanel("Failed to get review. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return 0;
        }
        return review;
    }
    
    public static LinkedList<ReviewCard> getReviewCards(Frame parentFrame, Dialog parentDialog, String facultyInitial) {
        LinkedList<ReviewCard> reviewCards = FeedbackModel.getReviewCards(facultyInitial);
        if (reviewCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Failed to get the reviews. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return reviewCards;
    }
    
    public static boolean insertFeedback(Dialog parentDialog, int userID, String facultyInitial, Course course, String feedbackString, double point) {
        if (FeedbackModel.insertFeedback(userID, facultyInitial, course, feedbackString, point)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to insert the feedback. Please try again!");
        new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);        
        return false;
    }
    
    public static LinkedList<FeedbackCard> getFeedbackCards(Frame parentFrame, Dialog parentDialog, String searchText) {
        LinkedList<FeedbackCard> feedbackCards = FeedbackModel.getFeedbackCards(searchText);
        if (feedbackCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Failed to get the feebacks. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }        
        return feedbackCards;        
    }

}
