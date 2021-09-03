package model;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class Semester {
    public static final int SPRING = 01, SUMMER = 03, FALL = 02;
    private static final String[] NAME_OF_SEASON = {"Unavailable", "Spring", "Fall", "Summer"};
    
    private int season, year;
    
    public Semester(int season, int year) {
        if (season < 0 || season >= NAME_OF_SEASON.length) season = 0;
        this.season = season;
        this.year = 2000 + year;
    }
    
    public Semester(String seasonString) {
        if (seasonString.toLowerCase().matches("spring [0-9]{4}")) {
            this.season = 1;
            this.year = Integer.parseInt(seasonString.substring(7));
        } else if (seasonString.toLowerCase().matches("fall [0-9]{4}")) {
            this.season = 2;
            this.year = Integer.parseInt(seasonString.substring(7));           
        } else if (seasonString.toLowerCase().matches("summer [0-9]{4}")) {
            this.season = 3;
            this.year = Integer.parseInt(seasonString.substring(7));            
        } else {
            this.season = 0;
            this.year = 0000;
        }
    }
    
    public static int getSeasonCode(String seasonName) {
        if (seasonName.toLowerCase().equals("spring")) return 1;
        else if (seasonName.toLowerCase().equals("fall")) return 2;
        else if (seasonName.toLowerCase().equals("summer")) return 3;
        else return 0;
    }
    
    public static String getSeasonName(int seasonCode) {
        if (seasonCode >= NAME_OF_SEASON.length) return NAME_OF_SEASON[0];
        return NAME_OF_SEASON[seasonCode];
    }
    
    @Override
    public String toString() {
        return NAME_OF_SEASON[season] + " " + year;
    }
}

class SeasonNameMismatchException extends RuntimeException {
    
}