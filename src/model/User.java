package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class User {
    public static final int POWER_ADMIN = 0, ADMIN = 1, STUDENT = 2, OTHER = 3;
    public static final String[] USER_ROLE = {"Power Admin", "Admin", "Student", "Other"};
    
    private static  User loggedInUser;
    
    private int id, role;
    private boolean accountActive, loggedIn, modified;
    private String name, phoneNumber, gmail, password, imgURL;
    private Department department;
    private Semester semester;
    private ImageIcon photo;
    private Date birthdate;
    
    public User() {
        
    }
    
    public User(int id, String name, Department department, Semester semester, String imageURL) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.imgURL = imageURL;
    }
    
    public User(int id, String name, Date birthdate, Department department, Semester semester, String phoneNumber, String gmail, String password, String imageURL, int role, int status) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.department = department;
        this.semester = semester;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.password = password;
        this.imgURL = imageURL;
        this.role = role;
        this.accountActive = status == 1;
    }
    
    public static boolean isSignedIn() {
        return loggedInUser != null && loggedInUser.isLoggedIn();
    }
    
    public static void login(User user) {
        loggedInUser = user;
        loggedInUser.setLoggedIn(true);
    }
    
    public static void logout() {
        loggedInUser = null;
    }
    
    public static User getUser() {
        return loggedInUser;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public boolean isAccountActive() {
        return accountActive;
    }
    
    public boolean isModified() {
        return modified;
    }

    public String getName() {
        return name;
    }

    public String getGmail() {
        return gmail;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Department getDepartment() {
        return department;
    }

    public Semester getSemester() {
        return semester;
    }

    public ImageIcon getPhoto() {
        return getProfilePhoto(imgURL);
    }
    
    public String getImgURL() {
        return imgURL;
    }
    
    public String getUpdateInfoQuery() {
        return String.format("UPDATE student "
                + "SET std_name = '%s', std_birthdate = '%tY/%<tm/%<td', std_department = '%s', std_semester = '%s', std_phone = '%s', std_gmail = '%s', std_photo = '%s' "
                + "WHERE std_id = %d", name, birthdate, department.getName(), semester.toString(), phoneNumber, gmail, imgURL, id);
    }
    
    public String getUpdatePasswordQuery() {
        return String.format("UPDATE student "
                + "SET std_password = '%s'"
                + "WHERE std_id = %d",
                password, id);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }
    
    public void requestUpdate() {
        modified = true;
    }
    
    public void updateComplete() {
        modified = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhoto(String photoURL) {
        imgURL = photoURL;
        photo = new ImageIcon(photoURL);
    }
    // </editor-fold>   
    
    // <editor-fold defaultstate="collapsed" desc="Profile Picture Frame Creator">
    public static void applyQualityRenderingHints(Graphics2D graphics) {
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }
    
    public static ImageIcon getProfilePhoto(String imgLocation) {
        Image image = null;
        try {
            if (imgLocation.startsWith("http")) {
                image = ImageIO.read(new URL(imgLocation)).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            } else 
                image = ImageIO.read(new File(imgLocation)).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            image = ImageResource.userPhoto.getImage();
        }
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 100, 100);
        Area circle = new Area(ellipse);
        
        BufferedImage userImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = userImage.createGraphics();
        applyQualityRenderingHints(graphics);
        graphics.setClip(circle);
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        
        return new ImageIcon(userImage);
    }
    // </editor-fold>
}
