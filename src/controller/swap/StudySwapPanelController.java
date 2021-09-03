package controller.swap;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import model.StringHolder;
import model.swap.StudySlotModel;
import view.DialogForm;
import view.ErrorPanel;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: StudySwapPanelController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class StudySwapPanelController {
    public static LinkedList<Object[]> getSlots(int userID) {
        return StudySlotModel.getSlotObjects(userID);
    }
    
    public static LinkedList<Object[]> getTeachObjects(int userID) {
        return StudySlotModel.getTeachObjects(userID);
    }
    
    public static LinkedList<String> getLearnObjects(int userID) {
        return StudySlotModel.getLearnObjects(userID);
    }
    
    public static boolean insertSlot(Frame parentFrame, Dialog parentDialog, int userID, String dayStr, String timeStr) {
        if (StudySlotModel.insertSlot(userID, dayStr, timeStr)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable insert the slot. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean insertTeach(Frame parentFrame, Dialog parentDialog, int userID, Course course) {
        if (StudySlotModel.insertTeach(userID, course)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable insert the teaching course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean insertLearn(Frame parentFrame, Dialog parentDialog, int userID, Course course) {
        if (StudySlotModel.insertLearn(userID, course)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable insert the learning course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean deleteSlot(Frame parentFrame, Dialog parentDialog, int userID, StringHolder slot) {
        if (StudySlotModel.deleteSlot(userID, slot)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable delete the slot. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean deleteTeach(Frame parentFrame, Dialog parentDialog, int userID, String course) {
        if (StudySlotModel.deleteTeach(userID, course)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable delete the teaching course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean deleteLearn(Frame parentFrame, Dialog parentDialog, int userID, String course) {
        if (StudySlotModel.deleteLearn(userID, course)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable delete the learning course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
}
