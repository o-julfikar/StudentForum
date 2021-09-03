package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JDialog;

public class DialogTitlePanel extends TitlePanel {

    JDialog parent;
    int mouseX, mouseY;
    
    public DialogTitlePanel(JDialog parent, String title) {
        super(null, title);
        this.parent = parent;
        btnMinimize.setVisible(false);
        btnMaximize.setVisible(false);
    }
    
    public DialogTitlePanel(JDialog parent) {
        this(parent, parent.getName());
    }
    
    public DialogTitlePanel() {
        this(null);
    }     
    
    public void mouseHover(JComponent component) {
        component.setForeground(Color.WHITE);
    }
    
    public void mouseLeave(JComponent component) {
        component.setForeground(component.getBackground());
    }
    
    public void mouseDown(JComponent component) {
        Color color = component.getBackground();
        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
        component.setBackground(new Color(r + 40, g + 40, b + 40));
    }
    
    public void mouseUp(JComponent component) {
        Color color = component.getBackground();
        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
        component.setBackground(new Color(r - 40, g - 40, b - 40));
    }
    
    public void maximizeWindow() {
        boolean isMaximized = windowMaximized();
        
        System.out.println(isMaximized);
        if (isMaximized) {
            parent.setSize(parent.getPreferredSize());
            parent.setLocationRelativeTo(null);
        } else {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            parent.setLocation(0, 0);
            parent.setPreferredSize(parent.getSize());
            parent.setSize(screenSize);
        }
    }
    
    public boolean windowMaximized() {
        Point parentLocation = parent.getLocation();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        System.out.println(screenSize);
        
        return parentLocation.x + parentLocation.y == 0 && parent.getWidth() == screenSize.width && parent.getHeight() == screenSize.height;
    }
    
    public void titlePanelMouseDrag() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        parent.setLocation(point.x - mouseX, point.y - mouseY);
    }    
    
    public void titlePanelMousePress(MouseEvent evt) {
        mouseX = evt.getX();
        mouseY = evt.getY();
    }
    
    public void titlePanelMouseRelease(MouseEvent evt) {
//        if (MouseInfo.getPointerInfo().getLocation().y < 3) parent.setExtendedState(parent.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }    
    
    public void btnCloseMouseClick() {
        for (float i = 1; i >= 0; i -= 0.1) {
            parent.setOpacity(i);
            try {
                Thread.sleep(20);
            } catch (Exception e) {

            }
        }
        parent.dispose();
        parent.setOpacity(1);
    }

}
