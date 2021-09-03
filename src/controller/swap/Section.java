package controller.swap;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class Section {
    private final int id, sectionNumber;
    private final Course course;
    
    public Section(int id, Course course, int number) {
        this.id = id;
        this.course = course;
        this.sectionNumber = number;
    }
    
    public int getId() {
        return id;
    }
    
    public int getSectionNumber() {
        return sectionNumber;
    }
    
    public Course getCourse() {
        return course;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%02d)", course.getCourseCode(), sectionNumber);
    }
}
