package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

// <editor-fold defaultstate="collapsed" desc="Author Information">
// Mohammed Julfikar Ali Mahbub, CSE Department, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
// Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
// </editor-fold>

public class FlatButton extends JLabel {
    
    int r, g, b, mouseButton;
    
    public FlatButton() {
        super();
    }
    
    public void addListeners() {
        r = getBackground().getRed();
        g = getBackground().getGreen();
        b = getBackground().getBlue();
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnMouseEntered(evt);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                btnMouseDown(evt);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                btnMouseUp(evt);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                btnMouseExited(evt);
            }
        });
    }
    
    public void btnMouseEntered(MouseEvent evt) {
        if (mouseButton == 0) setBackground(new Color((r + 20) % 255, (g + 20) % 255, (b + 20) % 255));
        else setBackground(new Color((r + 235) % 255, (g + 235) % 255, (b + 235) % 255));
    }
    
    public void btnMouseDown(MouseEvent evt) {
        setBackground(new Color((r + 235) % 255, (g + 235) % 255, (b + 235) % 255));
        mouseButton = evt.getButton();
    }
    
    public void btnMouseUp(MouseEvent evt) {
        if (evt.getX() >= 0 && evt.getX() <= getWidth() && evt.getY() >= 0 && evt.getY() <= getHeight()) setBackground(new Color((r + 20) % 255, (g + 20) % 255, (b + 20) % 255));
        else setBackground(new Color(r, g, b));
        mouseButton = 0;
    }
    
    public void btnMouseExited(MouseEvent evt) {
        setBackground(new Color(r, g, b));
    }
    
    @Override
    public void setOpaque(boolean aFlag) {
        super.setOpaque(aFlag);
        addListeners();
    }
    
//    public void setVisible(boolean aFlag) {
//        super.setVisible(aFlag);
////        if (aFlag) addListeners();
//    }
}
