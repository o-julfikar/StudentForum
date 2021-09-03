package controller.swap;

import model.User;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import model.swap.SectionModel;
import view.swap.SectionSwapCard;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class SectionSwapEngine {
    HashMap<Integer, Queue<Integer>> offersList; // Key: Student ID, Data: Section Number
    HashMap<Integer, Queue<Integer>> prefersList; // Key: Section Number, Data: Student ID
    User loggedInUser;
    Section preferredSection;
    Stack<SectionSwapShell>[] mem = new Stack[2];
    
    public void reset(boolean resetList) {
        mem[0] = new Stack<>();
        mem[1] = new Stack<>();
        if (resetList) resetOffersPrefers();
    }
    
    public void resetOffersPrefers() {
        offersList = new HashMap<>();
        prefersList = new HashMap<>();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Load Offers List">
    public void loadOffersList() {
        offersList.clear();
        offersList.putAll(SectionModel.getOffersList());
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Prefer List">
    public void loadPrefersList() {
        prefersList.clear();
        prefersList.putAll(SectionModel.getPrefersList());
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Run Section Swap I">
    public SectionSwapCard[] runSectionSwap(Section preferredSection) {
        reset(true);
        this.preferredSection = preferredSection;
        this.loggedInUser = User.getUser();
        loadOffersList();
        loadPrefersList();
        runSectionSwap(loggedInUser.getId());
        return getCards();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Run Section Swap II (Recursive)">
    public void runSectionSwap(int seekerID) {
        Queue<Integer> offerList = offersList.getOrDefault(seekerID, new LinkedList<>());
        Queue<Integer> offerListMemory = new LinkedList<>();
        
        while (!offerList.isEmpty()) {
            Integer sectionId = offerList.poll();
            offerListMemory.offer(sectionId);
            mem[0].push(new SectionSwapShell(seekerID, sectionId, false));
            
            if (sectionId == preferredSection.getId()) {
                mem[0].push(new SectionSwapShell(loggedInUser.getId(), sectionId, true));
                if (mem[0].size() > mem[1].size()) {
                    mem[1].clear();
                    mem[1].addAll(mem[0]);
                }
                mem[0].pop();
            } else {
                Queue<Integer> preferList = prefersList.getOrDefault(sectionId, new LinkedList<>());
                Queue<Integer> preferListMemory = new LinkedList<>();

                while (!preferList.isEmpty()) {
                    int studentID = preferList.poll();
                    preferListMemory.offer(studentID);
                    mem[0].push(new SectionSwapShell(studentID, sectionId, true));
                    runSectionSwap(studentID);
                    mem[0].pop();
                }

                while (!preferListMemory.isEmpty()) preferList.offer(preferListMemory.poll());
            }
            
            mem[0].pop();
        }
        
        while (!offerListMemory.isEmpty()) offerList.offer(offerListMemory.poll());
    }
    // </editor-fold>
    
    public SectionSwapCard[] getCards() {
        HashMap<Integer, String[]> studentList = new HashMap<>();
        HashMap<Integer, String[]> sectionList = new HashMap<>();
        Stack<SectionSwapShell> container = new Stack<>();
        StringBuilder sectionPreQuery = new StringBuilder(), studentPreQuery = new StringBuilder();
        SectionSwapCard[] cards = new SectionSwapCard[mem[1].size() / 2];
        
        // <editor-fold defaultstate="collapsed" desc="Generate Query">
        while (mem[1].size() > 2) {
            SectionSwapShell shell1 = mem[1].pop();
            container.push(shell1);
            container.push(mem[1].pop());
            sectionPreQuery.append("section_id = " + shell1.sectionID + " OR ");
            studentPreQuery.append("std_id = " + shell1.userID + " OR ");
        }
        if (mem[1].size() > 0) {
            SectionSwapShell shell1 = mem[1].pop();
            container.push(shell1);
            container.push(mem[1].pop());
            sectionPreQuery.append("section_id = " + shell1.sectionID);
            studentPreQuery.append("std_id = " + shell1.userID);
        } else {
            return cards;
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Load student and section details">
       studentList.putAll(SectionModel.getStudentList(studentPreQuery));
       sectionList.putAll(SectionModel.getSectionList(sectionPreQuery));
        // </editor-fold>
        
        for (int i = 0; !container.isEmpty(); i++) {
            SectionSwapShell shell01 = container.pop();
            SectionSwapShell shell02 = container.pop();
            String[] student1 = studentList.get(shell01.userID), student2 = studentList.get(shell02.userID);
            String[] section = sectionList.get(shell01.sectionID);
            
            SectionSwapCard card = new SectionSwapCard(section[0], section[1],
                    student1[0], User.getProfilePhoto(student1[1]),
                    student2[0], User.getProfilePhoto(student2[1]));
            
            cards[i] = card;
        }
        
        return cards;
    }
}
