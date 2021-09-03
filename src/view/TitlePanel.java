package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class TitlePanel extends javax.swing.JPanel {

    JFrame parent;
    int mouseX, mouseY;
    
    public TitlePanel(JFrame parent, String title) {
        initComponents();
        this.parent = parent;
        this.txtTitle.setText(title);
    }
    
    public TitlePanel(JFrame parent) {
        this(parent, parent.getName());
    }
    
    public TitlePanel() {
        this(null, "Untitled");
    }
    
    public void setTitle(String title) {
        txtTitle.setText(title);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Control Buttons Functions">
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
        if (parent.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            parent.setExtendedState(JFrame.NORMAL);
        } else {
            parent.setExtendedState(parent.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        }
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
        if (MouseInfo.getPointerInfo().getLocation().y < 3) parent.setExtendedState(parent.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
    }
    
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        btnClose = new FlatButton();
        btnMinimize = new FlatButton();
        btnMaximize = new FlatButton();
        txtTitle = new javax.swing.JLabel();

        titlePanel.setBackground(new java.awt.Color(102, 0, 102));
        titlePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlePanelMouseDragged(evt);
            }
        });
        titlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlePanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                titlePanelMouseReleased(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(204, 0, 51));
        btnClose.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(102, 0, 0));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setText("X");
        btnClose.setOpaque(true);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(0, 102, 204));
        btnMinimize.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(0, 51, 102));
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setText("-");
        btnMinimize.setToolTipText("");
        btnMinimize.setOpaque(true);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        btnMaximize.setBackground(new java.awt.Color(0, 204, 102));
        btnMaximize.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnMaximize.setForeground(new java.awt.Color(0, 102, 51));
        btnMaximize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMaximize.setText("[ ]");
        btnMaximize.setOpaque(true);
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseClicked(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(204, 204, 204));
        txtTitle.setText("BRACU Student Portal");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnMaximize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Control Buttons Event">
    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        btnCloseMouseClick();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        for (float i = 1; i >= 0; i -= 0.1) {
            parent.setOpacity(i);
            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
        }
        parent.setState(Frame.ICONIFIED);
        parent.setOpacity(1);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseClicked
        maximizeWindow();
    }//GEN-LAST:event_btnMaximizeMouseClicked

    private void titlePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlePanelMouseDragged
        titlePanelMouseDrag();
    }//GEN-LAST:event_titlePanelMouseDragged

    private void titlePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlePanelMousePressed
        titlePanelMousePress(evt);
    }//GEN-LAST:event_titlePanelMousePressed

    private void titlePanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlePanelMouseReleased
        titlePanelMouseRelease(evt);
    }//GEN-LAST:event_titlePanelMouseReleased
    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnClose;
    public javax.swing.JLabel btnMaximize;
    public javax.swing.JLabel btnMinimize;
    private javax.swing.JPanel titlePanel;
    protected javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
