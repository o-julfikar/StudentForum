package model;

import java.util.HashMap;

// <editor-fold defaultstate="collapsed" desc="Author Information">

// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class Department {
    private final static int CSE = 0;
    private final static HashMap<Integer, String> NAME = new HashMap<>();
    
    private String name;
    
    public Department(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static String getDepartment(int departmentCode) {
        return NAME.get(departmentCode);
    }
    
    public String getName() {
        return name;
    }
    
    static {
        NAME.put(1, "Computer Science and Engineering");
        NAME.put(41, "Computer Science");
    }
    
    @Override
    public String toString() {
        return "Department of " + name;
    }
    
    public String getAcronym() {
        String[] depWord = name.split(" ");
        StringBuilder acronym = new StringBuilder();
        for (String wrd : depWord) if (wrd.charAt(0) >= 'A' && wrd.charAt(0) <= 'Z') acronym.append(wrd.charAt(0));
        return acronym.toString();
    }
}
