package model.forum;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import model.Database;
import view.forum.CommentCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: CommentModel.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class CommentModel {
    
    public static boolean insertComment(String commentText, int userID, int postID) {
        String insertCommentQuery = String.format("INSERT INTO comment (comment_id, comment_text, student_id, post_id) "
                + "VALUES ((SELECT IFNULL(MAX(comment_id), -1) FROM comment AS current_comment_state) + 1, '%s', %s, %s)",
                commentText, userID, postID);
        
        return Database.updateWith(insertCommentQuery);
    }
    
    public static boolean insertReply(String replyText, int userID, int postID, int commentID) {
        String insertCommentQuery = String.format("INSERT INTO comment (comment_id, comment_text, student_id, post_id, descent_id) "
                + "VALUES ((SELECT IFNULL(MAX(comment_id), -1) FROM comment AS current_comment_state) + 1, '%s', %s, %s, %s)",
                replyText, userID, postID, commentID);

        return Database.updateWith(insertCommentQuery);
    }
    
    public static boolean deleteComment(int commentID) {
        String deleteCommentQuery = "DELETE FROM comment WHERE comment_id = " + commentID;

        return Database.updateWith(deleteCommentQuery);
    }
    
    public static LinkedList<CommentCard> getReplyCards(int userID, int postID, int commentID) {
        String loadReplyQuery = String.format("SELECT comment_id, comment_date, comment_text, comment.student_id, std_name, std_photo "
                + "FROM comment, student "
                + "WHERE comment.descent_id = %d AND comment.student_id = student.std_id "
                + "ORDER BY comment_date "
                + "LIMIT 100",
                commentID);
        LinkedList<CommentCard> replyCards = new LinkedList<>();
        try {
            ResultSet resultReply = Database.getResultOf(loadReplyQuery);

            while(resultReply.next()) {
                int replyId = resultReply.getInt("comment_id");
                int studentID = resultReply.getInt("student_id");
                Date replyDate = resultReply.getDate("comment_date");
                String replyText = resultReply.getString("comment_text");
                String studentName = resultReply.getString("std_name");
                String studentPhoto = resultReply.getString("std_photo");

                CommentCard card = new CommentCard(postID, replyId, replyDate, replyText, studentID, studentName, studentPhoto);
                if (userID != studentID) card.btnDelete.setVisible(false);
                replyCards.add(card);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getResultOf())");
            return null;
        }
        return replyCards;
    }
}
