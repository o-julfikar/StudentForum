package controller.swap;

import java.sql.Time;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class StudySlot {
    private int id;
    private Course course;
    private String courseCode;
    private String day;
    private Time time;
    
    public StudySlot(int id, Course course, String day, Time time) {
        this.id = id;
        this.course = course;
        this.day = day;
        this.time = time;
    }
    
    public StudySlot(int id, String courseCode, String day, Time time) {
        this.id = id;
        this.courseCode = courseCode;
        this.day = day;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }
    
    public String getCourseCode() {
        return courseCode;
    }

    public String getDay() {
        return day;
    }

    public Time getTime() {
        return time;
    }
    
    public String toString() {
        return String.format("%s (%s - %tI:%<tM %<Tp)", course == null? courseCode : course.getCourseCode(), day, time);
//        return String.format("%s (%s %s)", course.getCourseCode(), day, time);
    }
}
