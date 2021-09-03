package model.swap;

import controller.swap.Course;
import model.Database;
import controller.swap.StudySlot;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;
import model.StringHolder;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class StudySlotModel {
    private static HashMap<Integer, StudySlot> studySlotList;
    private static final String[] NAME_OF_DAY = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    
    public static void reloadStudySlotList() {
        String extractStudySlotQuery = "SELECT * FROM study_slot";
        if (studySlotList == null) studySlotList = new HashMap<>();
        studySlotList.clear();
        
        try {
            ResultSet resultStudySlot = Database.getResultOf(extractStudySlotQuery);
        
            while (resultStudySlot.next()) {
                int slotId = resultStudySlot.getInt("slot_id");
                String courseCode = resultStudySlot.getString("course_code");
                String slotDay = resultStudySlot.getString("slot_day");
                Time slotTime = resultStudySlot.getTime("slot_time");
                
                StudySlot studySlot = new StudySlot(slotId, CourseModel.getCourse(courseCode), slotDay, slotTime);
                
                studySlotList.put(slotId, studySlot);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
        }
    }
    
    public static void fillStudySlot(DefaultTableModel containerModel) {
        if (studySlotList == null) reloadStudySlotList();
        
        containerModel.setRowCount(0);
        
        for (StudySlot studySlot : studySlotList.values()) {
            containerModel.addRow(new Object[] {studySlot});
        }
    }
    
    public static HashMap<Integer, Queue<Integer>> getSlotsList() {
        String extractCourseQuery = "SELECT * FROM available_slot";
        HashMap<Integer, Queue<Integer>> slotsList = new HashMap<>();
        try {
            ResultSet courseResult = Database.getResultOf(extractCourseQuery);
            while (courseResult.next()) {
                int teacherId = courseResult.getInt("student_id");
                int slotId = courseResult.getInt("slot_id");
                Queue queue = slotsList.get(teacherId);
                if (queue == null) slotsList.put(teacherId, queue = new LinkedList<>());
                queue.offer(slotId);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadCourseList())");
        }
        return slotsList;
    }
    
    public static HashMap<String, Queue<Integer>> getLearnersList() {
        String extractLearnerQuery = "SELECT * FROM wants_to_learn";
        HashMap<String, Queue<Integer>> learnersList = new HashMap<>();
        try {
            ResultSet learnerResult = Database.getResultOf(extractLearnerQuery);
            while (learnerResult.next()) {
                int learnerId = learnerResult.getInt("student_id");
                String courseCode = learnerResult.getString("course_code");
                Queue queue = learnersList.get(courseCode);
                if (queue == null) learnersList.put(courseCode, queue = new LinkedList<>());
                queue.offer(learnerId);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (StudSlotModel.getLearnersList())");
        }
        return learnersList;
    }
    
    public static HashMap<Integer, Queue<String>>  getCourseList() {
        String extractLearnerQuery = "SELECT * FROM wants_to_teach";
        HashMap<Integer, Queue<String>> courseList = new HashMap<>();
        try {
            ResultSet rsCourse = Database.getResultOf(extractLearnerQuery);
            while (rsCourse.next()) {
                int teacherId = rsCourse.getInt("student_id");
                String courseCode = rsCourse.getString("course_code");
                Queue queue = courseList.get(teacherId);
                if (queue == null) courseList.put(teacherId, queue = new LinkedList<>());
                queue.offer(courseCode);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (StudSlotModel.getCourseList())");
        }
        return courseList;
    }
    
    public static HashMap<Integer, String[]> getStudentList(StringBuilder studentPreQuery) {
        HashMap<Integer, String[]> studentList = new HashMap<>();
        
        try {
            ResultSet studentResult = Database.getResultOf("SELECT std_id, std_name, std_photo FROM student WHERE " + studentPreQuery.toString());
        
            while (studentResult.next()) {
                int studentId = studentResult.getInt("std_id");
                String studentName = studentResult.getString("std_name");
                String studentPhoto = studentResult.getString("std_photo");
                
                studentList.put(studentId, new String[]{studentName, studentPhoto});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getCards())");
        }
        return studentList;
    }
    
    public static HashMap<Integer, String[]> getSlotList(StringBuilder slotPreQuery) {
        HashMap<Integer, String[]> slotList = new HashMap<>();
        
        try {
            ResultSet slotResult = Database.getResultOf("SELECT * FROM study_slot WHERE " + slotPreQuery.toString());
            
            while (slotResult.next()) {
                int slotId = slotResult.getInt("slot_id");
                int slotDay = slotResult.getInt("slot_day");
                Date slotTime = slotResult.getTime("slot_time");
                
                slotList.put(slotId, new String[]{StudySlotModel.getNameOfDay(slotDay), String.format("%tI:%<tM %<Tp", slotTime)});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getCards())");
        }
        return slotList;
    }
    
    public static LinkedList<Object[]> getSlotObjects(int userID) {
        String loadSlotQuery = "SELECT study_slot.slot_id, slot_day, slot_time "
                + "FROM study_slot, available_slot "
                + "WHERE available_slot.slot_id = study_slot.slot_id AND student_id = " + userID
                + " ORDER BY slot_day, slot_time";
        LinkedList<Object[]> slotObjects = new LinkedList<>();
        try {
            ResultSet rsSlot = Database.getResultOf(loadSlotQuery);
            while (rsSlot.next()) {
                int slotId = rsSlot.getInt("slot_id");
                int slotDay = rsSlot.getInt("slot_day");
                Time slotTime = rsSlot.getTime("slot_time");
                
                @SuppressWarnings("MalformedFormatString")
                StringHolder slot = new StringHolder(slotId, String.format("%s - %tI:%<tM %<Tp", StudySlotModel.getShortNameOfDay(slotDay), slotTime));
                slotObjects.add(new Object[] {slot});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadSlotProcess)");
        }
        return slotObjects;
    }
    
    public static LinkedList<Object[]> getTeachObjects(int userID) {
        String loadWantsToTeachQuery = "SELECT course_code FROM wants_to_teach WHERE student_id = " + userID;
        LinkedList<Object[]> teachObjects = new LinkedList<>();
        try {
            ResultSet rsTeach = Database.getResultOf(loadWantsToTeachQuery);
            while (rsTeach.next()) {
                String courseCode = rsTeach.getString("course_code");
                
                teachObjects.add(new Object[] {courseCode});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadWantsToTeachProcess)");
        }
        return teachObjects;
    }
    
    public static LinkedList<String> getLearnObjects(int userID) {
        String loadWantsToLearnQuery = "SELECT course_code FROM wants_to_learn WHERE student_id = " + userID;
        LinkedList<String> learnObjects = new LinkedList<>();
        try {
            ResultSet rsLearn = Database.getResultOf(loadWantsToLearnQuery);
            while (rsLearn.next()) {
                String courseCode = rsLearn.getString("course_code");
                learnObjects.add(courseCode);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (loadWantsToLearnProcess)");
        }
        return learnObjects;
    }
    
    public static boolean insertSlot(int userID, String dayStr, String timeStr) {
        int day = getDayNumber(dayStr);
        String time = convertToMilitaryTime(timeStr);
        String insertSlotQuery = String.format("INSERT INTO study_slot "
            + "SELECT (SELECT IFNULL (MAX(slot_id), -1) FROM study_slot AS current_study_slot_state) + 1, %d, '%s' "
            + "WHERE NOT EXISTS (SELECT * FROM study_slot WHERE slot_day = %d AND slot_time = '%s')"
            , day, time, day, time);
        String insertAvailableSlotQuery = String.format("INSERT INTO available_slot "
                + "VALUES ('%d', (SELECT slot_id FROM study_slot WHERE slot_day = %d AND slot_time = '%s'))"
                , userID, day, time);

        return Database.updateWith(insertSlotQuery) && Database.updateWith(insertAvailableSlotQuery);
    }
    
    public static boolean insertTeach(int userID, Course course) {
        String courseCode = course.getCourseCode();
        String insertWantsToTeachQuery = String.format("INSERT INTO wants_to_teach VALUES(%d, '%s')",
                userID, courseCode);

        return Database.updateWith(insertWantsToTeachQuery);
    }
    
    public static boolean insertLearn(int userID, Course course) {
        String courseCode = course.getCourseCode();
        String insertWantsToLearnQuery = String.format("INSERT INTO wants_to_learn VALUES(%d, '%s')",
                userID, courseCode);

        return Database.updateWith(insertWantsToLearnQuery);
    }
    
    public static boolean deleteSlot(int userID, StringHolder slot) {
        int slotId = slot.getId();
        String deleteSlotQuery = String.format("DELETE FROM available_slot "
                + "WHERE student_id = %d AND slot_id = %d", userID, slotId);
        
        return Database.updateWith(deleteSlotQuery);
    }
    
    public static boolean deleteTeach(int userID, String courseCode) {
        String deleteWantsToTeachQuery = String.format("DELETE FROM wants_to_teach " +
                "WHERE student_id = %d AND course_code = '%s'", userID, courseCode);

        return Database.updateWith(deleteWantsToTeachQuery);
    }
    
    public static boolean deleteLearn(int userID, String courseCode) {
        String deleteWantsToLearnQuery = String.format("DELETE FROM wants_to_learn " +
                "WHERE student_id = %d AND course_code = '%s'", userID, courseCode);

        return Database.updateWith(deleteWantsToLearnQuery);
    }
    
    public static String getNameOfDay(int dayNumber) {
        if (dayNumber < 0 || dayNumber > NAME_OF_DAY.length) return "NULL";
        return NAME_OF_DAY[dayNumber];
    }
    
    public static String getShortNameOfDay(int dayNumber) {
        if (dayNumber < 0 || dayNumber > NAME_OF_DAY.length) return "NULL";
        return NAME_OF_DAY[dayNumber].substring(0, 3);
    }
    
    public static String convertFromMilitaryTime(String militaryTime) {
        return null;
    }
    
    public static String convertToMilitaryTime(String meridiemTime) {
        int hours = 0, minutes = 0;
        if (meridiemTime.matches("0?[1-9]:[0-5][0-9] AM")) {
            String[] time = meridiemTime.split(":");
            hours = Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1].substring(0, 2));
        } else if (meridiemTime.matches("1[0-2]:[0-5][0-9] AM")) {
            String[] time = meridiemTime.split(":");
            hours = Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1].substring(0, 2));
        } else if (meridiemTime.matches("0?[1-9]:[0-5][0-9] PM")) {
            String[] time = meridiemTime.split(":");
            hours = 12 + Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1].substring(0, 2));
        } else if (meridiemTime.matches("1[0-2]:[0-5][0-9] PM")) {
            String[] time = meridiemTime.split(":");
            hours = 12 + Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1].substring(0, 2));
        } else {
            return "null";
        }
        
        if (hours == 12) hours = 00;
        else if (hours == 24) hours = 12;
        
        return String.format("%02d:%02d", hours, minutes);
    }
    
    public static int getDayNumber(String day) {
        day = day.toLowerCase();
        if (day.startsWith("sat")) return 0;
        else if (day.startsWith("sun")) return 1;
        else if (day.startsWith("mon")) return 2;
        else if (day.startsWith("tue")) return 3;
        else if (day.startsWith("wed")) return 4;
        else if (day.startsWith("thu")) return 5;
        else if (day.startsWith("fri")) return 6;
        else return -1;
    }
    
    public static StudySlot getStudySlot(int slotId) {
        if (studySlotList == null) reloadStudySlotList();
        
        StudySlot studySlot = studySlotList.get(slotId);
        if (studySlot == null) {
            reloadStudySlotList();
            return getStudySlot(slotId);
        }
        
        return studySlot;
    }
}
