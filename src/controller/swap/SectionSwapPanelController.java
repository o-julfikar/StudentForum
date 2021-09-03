package controller.swap;

// <editor-fold defaultstate="collapsed" desc="Imports">

import view.DialogForm;
import view.ErrorPanel;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import model.swap.SectionModel;

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// File: SectionSwapPanelController.java
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.">
// </editor-fold>

public class SectionSwapPanelController {
    
    public static boolean addOffer(Frame parentFrame, Dialog parentDialog, int id, String course, String section) {
        if (SectionModel.addOffer(id, course, section)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable add offered course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean addPrefer(Frame parentFrame, Dialog parentDialog, int id, String course, String section) {
        if (SectionModel.addPrefer(id, course, section)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable add prefered course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static boolean deleteOffer(Frame parentFrame, Dialog parentDialog, int userID, String course, String section) {
        if (SectionModel.deleteOffer(userID, course, section)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable delete offered course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);        
        return false;
    }
    
    public static boolean deletePrefer(Frame parentFrame, Dialog parentDialog, int userID, String course, String section) {
        if (SectionModel.deletePrefer(userID, course, section)) return true;
        
        ErrorPanel errorPanel = new ErrorPanel("Unable delete prefered course. Please try again!");
        if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
        return false;
    }
    
    public static LinkedList<Object[]> getOfferObjects(int userID) {
        return SectionModel.getOfferObjects(userID);
    }
    
    public static LinkedList<String> getPreferObjects(int userID) {
        return SectionModel.getPreferObjects(userID);
    }

}
