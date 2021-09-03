package controller.forum;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import javax.swing.SwingUtilities;
import model.forum.CommentModel;
import view.DialogForm;
import view.ErrorPanel;
import view.forum.CommentCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: CommentController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class CommentController {
    
    public static boolean insertComment(Frame parentFrame, Dialog parentDialog, String commentText, int userID, int postID) {
        if (CommentModel.insertComment(commentText, userID, postID)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to submit the comment. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean insertReply(Frame parentFrame, Dialog parentDialog, String replyText, int userID, int postID, int commentID) {
        if (CommentModel.insertReply(replyText, userID, postID, commentID)) return true;
                
        ErrorPanel errorPanel = new ErrorPanel("Failed to submit the reply. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }

    public static boolean deleteComment(Frame parentFrame, Dialog parentDialog, int commentID) {
        if (CommentModel.deleteComment(commentID)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable delete the comment. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static LinkedList<CommentCard> getReplyCards(Frame parentFrame, Dialog parentDialog, int userID, int postID, int commentID) {
        LinkedList<CommentCard> replyCards = CommentModel.getReplyCards(userID, postID, commentID);
        if (replyCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Unable load the replies. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return replyCards;
    }
}
