package model.swap;

import model.Database;
import controller.swap.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeSet;
import javax.swing.JComboBox;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class CourseModel {
    private static HashMap<String, Course> courseList;
    
    public static boolean addCourse(String courseCode, String courseTitle) {
        String insertCourseQuery = String.format("INSERT INTO course VALUES ('%s', '%s')", courseCode, courseTitle);
        
        return Database.updateWith(insertCourseQuery);
    }
    
    public static boolean addCourseWithSection(String courseCode, String courseTitle, String courseSection) {
        String extractMaxSectionId = "SELECT * FROM (SELECT IFNULL (MAX(section_id), -1) FROM section) AS current_section_state INTO @currentSectionId";
        String insertCourseQuery = String.format("INSERT INTO course VALUES ('%s', '%s')", courseCode, courseTitle);
        
        String insertSectionQuery = "INSERT INTO section VALUES ";
        StringBuilder sectionBuilder = new StringBuilder();
        
        if (courseSection.matches("[0-9]{2}")) {
            byte sectionNumber = Byte.parseByte(courseSection);
            sectionBuilder.append("(@currentSectionId + 1, '".concat(courseCode).concat("', ").concat(String.valueOf(sectionNumber)).concat("), "));
        } else {
            String[] preProcessSN = courseSection.split("( )*\\-( )*");
            short startSN = Short.parseShort(preProcessSN[0]), endSN = Short.parseShort(preProcessSN[1]);
            if (startSN > endSN) startSN += endSN - (endSN = startSN);
            for (int i = startSN, j = 1; i <= endSN; i++, j++) {
                String query = "(@currentSectionId + " + j + ", '" + courseCode + "', " + i + "), ";
                sectionBuilder.append(query);
            }
        }
        
        insertSectionQuery += sectionBuilder.substring(0, sectionBuilder.length() - 2);
        
        return Database.updateWithTransaction(extractMaxSectionId, insertCourseQuery, insertSectionQuery);
    }
    
    public static boolean addCourseSection(String courseCode, String courseSection) {
        String extractMaxSectionId = "SELECT * FROM (SELECT IFNULL (MAX(section_id), -1) FROM section) AS current_section_state INTO @currentSectionId";
        
        String insertSectionQuery = "INSERT INTO section VALUES ";
        StringBuilder sectionBuilder = new StringBuilder();
        
        if (courseSection.matches("[0-9]{2}")) {
            byte sectionNumber = Byte.parseByte(courseSection);
            String query = "(@currentSectionId + 1, '" + courseCode + "', " + sectionNumber + "), ";
            sectionBuilder.append(query);
        } else {
            String[] preProcessSN = courseSection.split("( )*\\-( )*");
            short startSN = Short.parseShort(preProcessSN[0]), endSN = Short.parseShort(preProcessSN[1]);
            if (startSN > endSN) startSN += endSN - (endSN = startSN);
            for (int i = startSN, j = 1; i <= endSN; i++, j++) {
                String query = "(@currentSectionId + " + j + ", '" + courseCode + "', " + i + "), ";
                sectionBuilder.append(query);
            }
        }
        
        insertSectionQuery += sectionBuilder.substring(0, sectionBuilder.length() - 2);
        
        return Database.updateWithTransaction(extractMaxSectionId, insertSectionQuery);
    }
    
    public static void reloadCourses() {
        String getCoursesQuery = "SELECT * FROM course";
        if (courseList == null) courseList = new HashMap<>();
        courseList.clear();
        try {
            ResultSet resultCourse = Database.getResultOf(getCoursesQuery);
        
            while (resultCourse.next()) {
                String courseCode = resultCourse.getString("course_code");
                String courseTitle = resultCourse.getString("course_title");
                
                courseList.put(courseCode, new Course(courseCode, courseTitle));
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
        }
    }
    
    public static void fillCourseCode(JComboBox containerComboBox) {
        reloadCourses();
        containerComboBox.removeAllItems();
        TreeSet<Course> courses = new TreeSet<>(courseList.values());
        for (Course course : courses) {
            containerComboBox.addItem(course);
        }
    }
    
    public static Course getCourse(String courseCode) {
        if (courseList == null) reloadCourses();
        return courseList.get(courseCode);
    }
}
