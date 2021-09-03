package model.swap;

import model.Database;
import controller.swap.Section;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import javax.swing.JComboBox;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class SectionModel {
    private static HashMap<Integer, Section> sectionList;
    
    public static void reloadSectionsList() {
        String extractSection = "SELECT * FROM section";
        if (sectionList == null) sectionList = new HashMap<>();
        sectionList.clear();
        
        try {
            ResultSet resultSections = Database.getResultOf(extractSection);
        
            while (resultSections.next()) {
                int sectionId = resultSections.getInt("section_id");
                int sectionNumber = resultSections.getInt("section_number");
                String courseCode = resultSections.getString("course_code");
                
                Section section = new Section(sectionId, CourseModel.getCourse(courseCode), sectionNumber);
                sectionList.put(sectionId, section);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (reloadSectionsList())");
        }
    }
    
    public static void fillSections(JComboBox containerComboBox) {
        if (sectionList == null) reloadSectionsList();
        containerComboBox.removeAllItems();
        TreeSet<String> sections = new TreeSet<>();
        for (Section section : sectionList.values()) {
            sections.add(section.toString());
        }
        
        for (String section : sections) containerComboBox.addItem(section);
    }
    
    public static HashMap<Integer, Queue<Integer>> getOffersList() {
        String extractOffersQuery = "SELECT * FROM offers_section";
        HashMap<Integer, Queue<Integer>> offersList = new HashMap<>();
        try {
            ResultSet offersResult = Database.getResultOf(extractOffersQuery);
            while (offersResult.next()) {
                int studentId = offersResult.getInt("student_id");
                int sectionId = offersResult.getInt("section_id");
                Queue queue = offersList.get(studentId);
                if (queue == null) offersList.put(studentId, queue = new LinkedList<>());
                queue.offer(sectionId);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
        }
        return offersList;
    }
    
    public static HashMap<Integer, Queue<Integer>> getPrefersList() {
        String extractPrefersQuery = "SELECT * FROM prefers_section";
        HashMap<Integer, Queue<Integer>> prefersList = new HashMap<>();
        try {
            ResultSet prefersResult = Database.getResultOf(extractPrefersQuery);
            while(prefersResult.next()) {
                int studentId = prefersResult.getInt("student_id");
                int sectionId = prefersResult.getInt("section_id");
                Queue queue = prefersList.get(sectionId);
                if (queue == null) prefersList.put(sectionId, queue = new LinkedList<>());
                queue.offer(studentId);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
        }
        return prefersList;
    }
    
    public static boolean addOffer(int id, String course, String section) {
        String insertOfferQuery = String.format("INSERT INTO offers_section "
                    + "VALUES (%d, (SELECT section_id FROM section "
                    + "WHERE course_code = '%s' AND section_number = %s))", 
                    id, course, section);
        
        return Database.updateWith(insertOfferQuery);
    }
    
    public static boolean addPrefer(int id, String course, String section) {
        String insertPreferQuery = String.format("INSERT INTO prefers_section "
                    + "VALUES (%d, (SELECT section_id FROM section "
                    + "WHERE course_code = '%s' AND section_number = %s))",
                    id, course, section);
        
        return Database.updateWith(insertPreferQuery);
    }
    
    public static boolean deleteOffer(int userID, String course, String section) {
        String deleteOfferQuery = String.format("DELETE FROM offers_section "
                    + "WHERE student_id = %s AND section_id = (SELECT section_id FROM section WHERE course_code = '%s' AND section_number = %s)",
                    userID, course, section);
        
        return Database.updateWith(deleteOfferQuery);
    }
    
    public static boolean deletePrefer(int userID, String course, String section) {
        String deletePreferQuery = String.format("DELETE FROM prefers_section "
                + "WHERE student_id = %s AND section_id = (SELECT section_id FROM section WHERE course_code = '%s' AND section_number = %s)", 
                userID, course, section);
        
        return Database.updateWith(deletePreferQuery);
    }
    
    public static LinkedList<Object[]> getOfferObjects(int userID) {
        String extractOffers = "SELECT course_code, section_number FROM offers_section INNER JOIN section "
                    + "ON section.section_id = offers_section.section_id AND offers_section.student_id = " + 
                    userID + " ORDER BY course_code, section_number";
        LinkedList<Object[]> offers = new LinkedList<>();
        try {
            ResultSet resultOffers = Database.getResultOf(extractOffers);
            while (resultOffers.next()) {
                String courseCode = resultOffers.getString("course_code");
                int sectionNumber = resultOffers.getInt("section_number");

                offers.add(new Object[] {String.format("%s (%02d)", courseCode, sectionNumber)});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
        }
        return offers;
    }
    
    public static LinkedList<String> getPreferObjects(int userID) {
        String extractOffers = "SELECT course_code, section_number FROM prefers_section INNER JOIN section ON "
                + "section.section_id = prefers_section.section_id AND prefers_section.student_id = " + 
                userID + " ORDER BY course_code, section_number";
        LinkedList<String> prefers = new LinkedList<>();
        try {
            ResultSet resultOffers = Database.getResultOf(extractOffers);
            while (resultOffers.next()) {
                int sectionNumber = resultOffers.getInt("section_number");
                String courseCode = resultOffers.getString("course_code");
                String section = String.format("%s (%02d)", courseCode, sectionNumber);
                prefers.add(section);
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
        }
        return prefers;
    }
    
    public static HashMap<Integer, String[]> getStudentList(StringBuilder studentPreQuery) {
        String extractStudentQuery = "SELECT std_id, std_name, std_photo FROM student WHERE " + studentPreQuery.toString();
        HashMap<Integer, String[]> studentList = new HashMap<>();
        try {
            ResultSet studentResult = Database.getResultOf(extractStudentQuery);
            while (studentResult.next()) {
                String name = studentResult.getString("std_name");
                String imgLoc = studentResult.getString("std_photo");
                int studentId = studentResult.getInt("std_id");
                
                studentList.put(studentId, new String[]{name, imgLoc});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getCards())");
        }
        return studentList;
    }
    
    public static HashMap<Integer, String[]> getSectionList(StringBuilder sectionPreQuery) {
        String extractSectionQuery = "SELECT section_id, course_code, section_number FROM section WHERE " + sectionPreQuery.toString();
        HashMap<Integer, String[]> sectionsList = new HashMap<>();
        try {
            ResultSet sectionResult = Database.getResultOf(extractSectionQuery);
            while (sectionResult.next()) {
                int sectionId = sectionResult.getInt("section_id");
                String sectionNumber = String.valueOf(sectionResult.getInt("section_number"));
                String courseCode = sectionResult.getString("course_code");
                
                sectionsList.put(sectionId, new String[]{courseCode, sectionNumber});
            }
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getCards())");
        }
        return sectionsList;
    }
    
    public static Section getSection(int sectionId) {
        if (sectionList == null) reloadSectionsList();
        Section section = sectionList.get(sectionId);
        if (section == null) {
            reloadSectionsList();
            return getSection(sectionId);
        }
        return sectionList.get(sectionId);
    }
    
    public static Section getSection(String sectionString) {
        int sectionId = -1;
        sectionString = sectionString.replaceAll("[^A-Z0-9 ]", "").trim();
        String[] sectionSegment = sectionString.split("\\s+");
        String extractSectionQuery = "SELECT section_id FROM section WHERE course_code = '" + sectionSegment[0] + "' AND section_number = " + sectionSegment[1];
        try {
            ResultSet sectionResult = Database.getResultOf(extractSectionQuery);
        
            if (sectionResult.next()) sectionId = sectionResult.getInt("section_id");
        } catch (SQLException ex) {
            System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getSection(String sectionString))");
        }
        
        return sectionList.get(sectionId);
    }
}
