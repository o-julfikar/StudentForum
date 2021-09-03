package model.feedback;

// <editor-fold defaultstate="collapsed" desc="Imports">

import controller.swap.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Database;
import view.feedback.FeedbackCard;
import view.feedback.ReviewCard;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: FeedbackModel.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class FeedbackModel {
    
    public static double getReviewPoint(String facultyInitial) {
        String query = String.format("SELECT IFNULL (avg(feedback_point), 0) AS point "
                + "FROM faculty LEFT JOIN feedback ON faculty.faculty_initial = feedback.faculty_initial "
                + "WHERE faculty.faculty_initial = '%s' "
                , facultyInitial);
        double point = 0;
        try {
            ResultSet resultFaculty = Database.getResultOf(query);
            if (resultFaculty.next()) {
                point = resultFaculty.getDouble("point");
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadFacultyProcess())");
            return -1;
        }
        return point;
    }
    
    public static LinkedList<ReviewCard> getReviewCards(String facultyInitial) {
        String getReviewQuery = String.format("SELECT feedback_text AS text, course_code AS course "
                + "FROM feedback WHERE faculty_initial = '%s' "
                + "ORDER BY feedback_date DESC", 
                facultyInitial);
        LinkedList<ReviewCard> reviewCards = new LinkedList<>();
        try {
            ResultSet resultReview = Database.getResultOf(getReviewQuery);
            while (resultReview.next()) {
                String reviewText = resultReview.getString("text");
                String courseCode = resultReview.getString("course");

                ReviewCard reviewCard = new ReviewCard(courseCode, reviewText);
                reviewCards.add(reviewCard);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadReviewsProcess())");
        }
        return reviewCards;
    }
    
    public static boolean insertFeedback(int userID, String facultyInitial, Course course, String feedbackString, double point) {
        String insertFeebackQuery = String.format(
                "INSERT INTO feedback "
                + "(`feedback_id`, `feedback_text`, `feedback_point`, `student_id`, `course_code`, `faculty_initial`) "
                + "VALUES ((SELECT IFNULL (MAX(feedback_id), 0) FROM feedback as feedback_current_state) + 1, '%s', %s, %d, '%s', '%s')", 
                feedbackString, point, userID, course.getCourseCode(), facultyInitial);

        return Database.updateWith(insertFeebackQuery);
    }
    
    public static LinkedList<FeedbackCard> getFeedbackCards(String searchString) {
        String query = String.format("SELECT faculty.faculty_initial, faculty_name, faculty_photo , IFNULL (avg(feedback_point), 0) AS point "
                + "FROM faculty LEFT JOIN feedback ON faculty.faculty_initial = feedback.faculty_initial "
                + "WHERE faculty.faculty_initial = '%s' OR faculty_name LIKE '%%%<s%%' "
                + "GROUP BY faculty.faculty_initial "
                + "ORDER BY faculty_name "
                + "LIMIT 100",
                searchString);
        LinkedList<FeedbackCard> feedbackCards = new LinkedList<>();
        try {
            ResultSet resultFaculty = Database.getResultOf(query);
            while (resultFaculty.next()) {
                String facultyName = resultFaculty.getString("faculty_name");
                String facultyInitial = resultFaculty.getString("faculty_initial");
                String photoURL = resultFaculty.getString("faculty_photo");
                double point = resultFaculty.getDouble("point");

                FeedbackCard feedbackCard = new FeedbackCard(facultyName, facultyInitial, photoURL, point);
                feedbackCards.add(feedbackCard);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadFacultyProcess())");
            return null;
        }
        return feedbackCards;
    }

}
