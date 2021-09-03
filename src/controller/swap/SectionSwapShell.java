package controller.swap;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class SectionSwapShell {
    int userID, sectionID;
    boolean seeker;
    
    public SectionSwapShell(int userID, int sectionID, boolean seeker) {
        this.userID = userID;
        this.sectionID = sectionID;
        this.seeker = seeker;
    }
    
    public String toString() {
        return String.format("%d %c %d", userID, seeker ? '<' : '>', sectionID);
    }
}
