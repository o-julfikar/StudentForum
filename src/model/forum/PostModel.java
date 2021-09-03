package model.forum;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import model.Database;
import model.Department;
import model.Semester;
import model.User;
import view.forum.CommentCard;
import view.forum.PostCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: PostModel.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class PostModel {
    
    public static boolean insertPost(int userID, String postText, String tags) {
        String getPostIdQuery = "SELECT (SELECT IFNULL (MAX(post_id), 0) FROM post) INTO @currentID; ";
        String insertTagQuery = "INSERT INTO tag VALUES ";
        StringBuilder tagBuilder = new StringBuilder();

        for (String tag : tags.split(", ")) tagBuilder.append("(@currentID + 1, '" + tag + "'), ");

        insertTagQuery += tagBuilder.substring(0, tagBuilder.length() - 2);

        String insertPostQuery = String.format("INSERT INTO post (`post_id`, `post_text`, `student_id`) "
                                                + "VALUES (@currentID + 1, '%s', %d)", 
                                                postText, userID);

        String[] queries = new String[tags.length() > 0 ? 2 : 1];
        queries[0] = insertPostQuery;
        if (queries.length > 1) queries[1] = insertTagQuery;

        return Database.updateWithTransaction(getPostIdQuery, queries);
    }
    
    public static LinkedList<PostCard> getPostCards(int page) {
        int limit = (page + 1) * 10;
        String defaultPostQuery = "SELECT * FROM (SELECT * FROM (SELECT post_id, post_date, post_text, student.std_id, std_name, std_department, std_semester, std_photo "
                + "FROM post, student "
                + "WHERE post.student_id = student.std_id "
                + "GROUP BY post_id "
                + "ORDER BY post_id DESC "
                + String.format("LIMIT %d) AS result ", limit)
                + "ORDER BY post_id LIMIT 10) AS final_result "
                + "ORDER BY post_id DESC";
        return getPostCards(defaultPostQuery);
    }
    
    public static LinkedList<PostCard> getPostCards(String userID, String userName, String date, String tag, int page) {
        String loadPostQuery;
        StringBuilder queryBuilder = new StringBuilder();
        int limit = (page + 1) * 10;
        if (userID.length() > 0) queryBuilder.append("student.std_id AND student.std_id = ").append(userID);
        else queryBuilder.append("student.std_id");
        if (userName.length() > 0) queryBuilder.append(" AND std_name LIKE '%").append(userName).append("%'");
        if (date.length() > 0) queryBuilder.append(" AND DATE_FORMAT(post_date, '%d/%m/%Y') = '").append(date).append("'");
        if (tag.length() > 0) {
            queryBuilder.append(" AND (").append(getTagQuery(tag)).append(")");
            loadPostQuery = "SELECT * FROM (SELECT * FROM (SELECT post.post_id, post_date, post_text, student.std_id, std_name, std_department, std_semester, std_photo, tag "
                    + "FROM post, student, tag "
                    + "WHERE post.post_id = tag.post_id AND post.student_id = " + queryBuilder.toString() + " "
                    + "GROUP BY post.post_id "
                    + "ORDER BY post_id DESC "
                    + String.format("LIMIT %d) AS result ", limit)
                    + "ORDER BY post_id LIMIT 10) AS final_result "
                    + "ORDER BY post_id DESC";
        } else {
            loadPostQuery = "SELECT* FROM (SELECT * FROM (SELECT * FROM post, student "
                    + "WHERE post.student_id = " + queryBuilder.toString() + " "
                    + "GROUP BY post_id "
                    + "ORDER BY post_id DESC "
                    + String.format("LIMIT %d) AS result ", limit)
                    + "ORDER BY post_id LIMIT 10) AS final_result "
                    + "ORDER BY post_id DESC";
        }
        return getPostCards(loadPostQuery);
    }
    
    public static LinkedList<PostCard> getPostCards(String loadPostQuery) {
        LinkedList<PostCard> postCards = new LinkedList<>();
        try {
            ResultSet resultPost = Database.getResultOf(loadPostQuery);
            while (resultPost.next()) {
                Date postDate = resultPost.getTimestamp("post_date");
                String postText = resultPost.getString("post_text");
                int writerID = resultPost.getInt("std_id");
                int postId = resultPost.getInt("post_id");
                User user = null;
                
                String name, departmentString, semesterString, photoURL;
                name = resultPost.getString("std_name");
                departmentString = resultPost.getString("std_department");
                semesterString = resultPost.getString("std_semester");
                photoURL = resultPost.getString("std_photo");
                Department department = new Department(departmentString);
                Semester semester = new Semester(semesterString);
                user = new User(writerID, name, department, semester, photoURL);
                
                ArrayList<String> tags = new ArrayList<String>();
                
                ResultSet resultTag = Database.getResultOf("SELECT tag FROM tag WHERE post_id = " + postId);
                
                while (resultTag.next()) {
                    tags.add(resultTag.getString("tag"));
                }
                
                PostCard postCard = new PostCard(postId, postText, user, postDate, tags);
                                
                postCards.add(postCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("#" + e.getErrorCode() + ": " + e.getMessage() + " (loadPosts())");
            return null;
        }
        return postCards;
    }
    
    public static LinkedList<CommentCard> getCommentCards(int userID, int postID) {
        String loadCommentQuery = String.format("SELECT comment_id, comment_date, comment_text, comment.student_id, std_name, std_photo "
                + "FROM comment, student "
                + "WHERE comment.student_id = student.std_id AND post_id = %d AND ISNULL(descent_id)"
                + "ORDER BY comment_date "
                + "LIMIT 100", postID);
        LinkedList<CommentCard> commentCards = new LinkedList<>();
        try {
            ResultSet resultComment = Database.getResultOf(loadCommentQuery);
            
            while(resultComment.next()) {
                int commentId = resultComment.getInt("comment_id");
                int studentId = resultComment.getInt("student_id");
                Date commentDate = resultComment.getDate("comment_date");
                String commentText = resultComment.getString("comment_text");
                String studentName = resultComment.getString("std_name");
                String studentPhoto = resultComment.getString("std_photo");

                CommentCard commentCard = new CommentCard(postID, commentId, commentDate, commentText, studentId, studentName, studentPhoto);
                if (userID != studentId) commentCard.btnDelete.setVisible(false);
                commentCards.add(commentCard);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadCommentProcess())");
        }
        return commentCards;
    }
    
    private static String getTagQuery(String txtTag) {
        String tagString = txtTag.replace(" ", "");
        if (tagString.matches("[A-Za-z0-9]*(,[A-Za-z0-9]*)*")) {
            String[] tags = tagString.split(",");
            StringBuilder tagQueryBuilder = new StringBuilder();
            for (String tag : tags) tagQueryBuilder.append(" OR tag = '").append(tag).append("'");
            return tagQueryBuilder.substring(4);
        }
        return "";
    }
}
