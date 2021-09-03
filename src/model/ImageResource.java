package model;

import javax.swing.ImageIcon;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class ImageResource {
    static Class me = ImageResource.class;
    public static String imageLocation = "/resources/images/";
    public static ImageIcon fullStar = new ImageIcon(me.getResource(imageLocation + "star_full - 50px.png"));
    public static ImageIcon halfStar = new ImageIcon(me.getResource(imageLocation + "star_half - 50px.png"));
    public static ImageIcon zeroStar = new ImageIcon(me.getResource(imageLocation + "star_zero - 50px.png"));
    public static ImageIcon userPhoto = new ImageIcon(me.getResource(imageLocation + "userphoto_default - 100px.png"));
}
