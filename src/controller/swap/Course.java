package controller.swap;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class Course implements Comparable<Course> {
    private final String courseCode, courseTitle;
    
    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseTitle() {
        return courseTitle;
    }
    
    @Override
    public int compareTo(Course other) {
        return courseCode.compareTo(other.courseCode);
    }
    
    @Override
    public String toString() {
        return courseCode + " ("+ courseTitle + ")";
    }
}
