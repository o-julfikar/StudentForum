package model;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class StringHolder {
    int id;
    String string;
    
    public StringHolder(int id, String string) {
        this.id = id;
        this.string = string;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return string;
    }
}
