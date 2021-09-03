package controller.swap;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class StudySwapShell {
    int userId, slotId;
    boolean learner;
    String course;
    
    public StudySwapShell (int userId, int slotId, String course, boolean learner) {
        this.userId = userId;
        this.slotId = slotId;
        this.course = course;
        this.learner = learner;
    }
    
    public String toString() {
        return String.format("%d %c (%s @ %d)", userId, learner? '<' : '>', course, slotId);
    }
}
