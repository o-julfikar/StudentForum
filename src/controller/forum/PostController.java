package controller.forum;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import model.forum.PostModel;
import view.DialogForm;
import view.ErrorPanel;
import view.forum.CommentCard;
import view.forum.PostCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: PostController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class PostController {
    
    public static boolean insertPost(Frame parentFrame, Dialog parentDialog, int userID, String postText, String tags) {
        if (PostModel.insertPost(userID, postText, tags)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Failed to post. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static LinkedList<PostCard> getPostCards(Frame parentFrame, Dialog parentDialog) {
        LinkedList<PostCard> postCards = PostModel.getPostCards(0);
        if (postCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Unable load the posts. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return postCards;
    }
    
    public static LinkedList<PostCard> getPostCards(Frame parentFrame, Dialog parentDialog, int page) {
        LinkedList<PostCard> postCards = PostModel.getPostCards(page);
        if (postCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Unable load the posts. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return postCards;
    }
    
    public static LinkedList<PostCard> getPostCards(Frame parentFrame, Dialog parentDialog, String userID, String userName, String date, String tag) {
        LinkedList<PostCard> postCards = PostModel.getPostCards(userID, userName, date, tag, 0);
        if (postCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Unable load the posts. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return postCards;
    }
    
    public static LinkedList<PostCard> getPostCards(Frame parentFrame, Dialog parentDialog, String userID, String userName, String date, String tag, int page) {
        LinkedList<PostCard> postCards = PostModel.getPostCards(userID, userName, date, tag, page);
        if (postCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Unable load the posts. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return postCards;
    }
    
    public static LinkedList<CommentCard> getCommentCards(Frame parentFrame, Dialog parentDialog, int userID, int postID) {
        LinkedList<CommentCard> commentCards = PostModel.getCommentCards(userID, postID);
        if (commentCards == null) {
            ErrorPanel errorPanel = new ErrorPanel("Unable load the comments. Please try again!");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
            return new LinkedList<>();
        }
        return commentCards;
    }
}
