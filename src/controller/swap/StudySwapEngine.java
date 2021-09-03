package controller.swap;

import java.util.Arrays;
import model.User;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import model.swap.StudySlotModel;
import view.swap.StudySwapCard;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class StudySwapEngine {
    HashMap<Integer, Queue<Integer>> slotsList; // Key: Teacher ID, Data: Slot ID
    HashMap<Integer, Queue<String>> courseList; // Key: Teacher ID, Data: Course Code
    HashMap<String, Queue<Integer>> learnersList; // Key: Course Code, Data: Learner ID
    Stack<StudySwapShell>[] mem = new Stack[2];
    
    User loggedInUser;
    String preferredCourse;
    int preferredSlot;
    
    public void reset(boolean resetList) {
        mem[0] = new Stack<>();
        mem[1] = new Stack<>();
        if (resetList) resetList();
    }
    
    public void resetList() {
        slotsList = new HashMap<>();
        courseList = new HashMap<>();
        learnersList = new HashMap<>();
    }
    
    public void loadSlotsList() {
        slotsList.clear();
        slotsList.putAll(StudySlotModel.getSlotsList());
    }
    
    public void loadCourseList() {
        courseList.clear();
        courseList.putAll(StudySlotModel.getCourseList());
    }
    
    public void loadLearnersList() {
        learnersList.clear();
        learnersList.putAll(StudySlotModel.getLearnersList());
    }
    
    public StudySwapCard[] runStudySwap(String preferredCourse) {
        reset(true);
        this.loggedInUser = User.getUser();
        this.preferredCourse = preferredCourse;
        loadSlotsList();
        loadCourseList();
        loadLearnersList();
        Queue<Integer> slots = slotsList.get(loggedInUser.getId());
        if (slots != null) {
            for (int i = 0; i < slots.size(); i++) {
                preferredSlot = slots.poll();
                mem[0].clear();
                runStudySwap(loggedInUser.getId());
                slots.offer(preferredSlot);
            }
        }
        
        return getCards();
    }
    
    public void runStudySwap(int teacherId) {
        Queue<Integer> teacherSlots = slotsList.get(teacherId);
        
        for (int i = 0; i < teacherSlots.size(); i++) {
            int teacherSlot = teacherSlots.poll();
            Queue<String> teachingCourses = courseList.get(teacherId);
            if (teachingCourses != null) {
                for (int j = 0; j < teachingCourses.size(); j++) {
                    String teachingCourse = teachingCourses.poll();
                    StudySwapShell teacherShell = new StudySwapShell(teacherId, teacherSlot, teachingCourse, false);
                    mem[0].push(teacherShell);
                    if (teachingCourse.equals(preferredCourse) && teacherSlot == preferredSlot) {
                        StudySwapShell learnerShell = new StudySwapShell(loggedInUser.getId(), teacherSlot, teachingCourse, true);
                        mem[0].push(learnerShell);
                        if (mem[0].size() > mem[1].size()) {
                            mem[1].clear();
                            mem[1].addAll(mem[0]);
                        }
                        mem[0].pop();
                    } else {
                        Queue<Integer> learnerList = this.learnersList.get(teachingCourse);
                        if (learnerList != null) {
                            for (int k = 0; k < learnerList.size(); k++) {
                                int learnerId = learnerList.poll();
                                Queue<Integer> learnerSlots = slotsList.get(learnerId);
                                if (learnerSlots != null) {
                                    for (int l = 0; l < learnerSlots.size(); l++) {
                                        int learnerSlot = learnerSlots.poll();
                                        if (teacherSlot == learnerSlot) {
                                            // Teaching possible
                                            StudySwapShell learnerShell = new StudySwapShell(learnerId, learnerSlot, teachingCourse, true);
                                            mem[0].push(learnerShell);
                                            runStudySwap(learnerId);
                                            mem[0].pop();
                                        }
                                        learnerSlots.offer(learnerSlot);
                                    }
                                }
                                learnerList.offer(learnerId);
                            }
                        }
                    }
                    mem[0].pop();
                    teachingCourses.offer(teachingCourse);
                }
            }
            teacherSlots.offer(teacherSlot);
        }
    }
    
    public StudySwapCard[] getCards() {
        HashMap<Integer, String[]> studentList = new HashMap<>();
        HashMap<Integer, String[]> slotList = new HashMap<>();
        Stack<StudySwapShell> container = new Stack<>();
        StudySwapCard[] cards = new StudySwapCard[mem[1].size() / 2];
        StringBuilder studentPreQuery = new StringBuilder(), slotPreQuery = new StringBuilder();

        // <editor-fold defaultstate="collapsed" desc="Generate Query">
        while (mem[1].size() > 2) {
            StudySwapShell shell1 = mem[1].pop();
            container.push(shell1);
            container.push(mem[1].pop());
            studentPreQuery.append("std_id = ").append(shell1.userId).append(" OR ");
            slotPreQuery.append("slot_id = ").append(shell1.slotId).append(" OR ");
        }
        if (mem[1].size() > 0) {
            StudySwapShell shell1 = mem[1].pop();
            container.push(shell1);
            container.push(mem[1].pop());
            studentPreQuery.append("std_id = ").append(shell1.userId);
            slotPreQuery.append("slot_id = ").append(shell1.slotId);
        } else {
            return cards;
        }
        // </editor-fold>
        // Load student and slot details
        studentList.putAll(StudySlotModel.getStudentList(studentPreQuery));
        slotList.putAll(StudySlotModel.getSlotList(slotPreQuery));

        for (int i = 0; !container.isEmpty(); i++) {
            StudySwapShell shell01 = container.pop();
            StudySwapShell shell02 = container.pop();
            String[] teacher = studentList.get(shell01.userId), learner = studentList.get(shell02.userId);
            String[] slot = slotList.get(shell01.slotId);
            
            StudySwapCard card = new StudySwapCard(shell01.course, slot[0], slot[1], 
                    teacher[0], User.getProfilePhoto(teacher[1]), 
                    learner[0], User.getProfilePhoto(learner[1]));
            
            cards[i] = card;
        }
        return cards;
    }
}
