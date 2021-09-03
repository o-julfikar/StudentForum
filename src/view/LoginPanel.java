package view;

import controller.AccountController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class LoginPanel extends javax.swing.JPanel {
    
    int radius = 30;
    Thread loginThread;
    Runnable loginProcess = new Runnable() {
            
            @Override
            public void run() {
                setCursor(Cursor.WAIT_CURSOR);
                if (AccountController.userLogin(parentFrame, parentDialog, txtId.getText(), String.valueOf(txtPassword.getPassword()))) {
                    closeWindow();
                }
                setCursor(Cursor.DEFAULT_CURSOR);
            }
        };
    
    Frame parentFrame;
    Dialog parentDialog;
    
    public LoginPanel() {
        initComponents();
    }
    
    private void drawString(Graphics g, JComponent component, String string) {
        FontMetrics fontMetrics = g.getFontMetrics(getFont());

        int x = (component.getWidth() - fontMetrics.stringWidth(string)) / 2;
        int y = (component.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();

        g.setFont(component.getFont());
        g.setColor(component.getForeground());
        g.drawString(string, x, y);
    }
    
    private void drawRoundRect(Graphics g, JComponent component, Color color, boolean paintBackground) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(component.getBackground());
        if (paintBackground) graphics.fillRect(0, 0, component.getWidth(), component.getHeight());
        graphics.setColor(color);
        graphics.fillRoundRect(0, 0, component.getWidth() - 1, component.getHeight() - 1, radius, radius);
    }

    public void closeWindow() {
        SwingUtilities.getWindowAncestor(this).dispose();
    }
    
    public void isWorking(boolean working) {
        setEnabled(!working);
    }
    
    public void setCursor(int cursor) {
        setCursor(Cursor.getPredefinedCursor(cursor));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JLabel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintChildren(g);
                drawRoundRect(g, this, new Color(40, 81, 142), true);
                drawString(g, this, getText());
            }
        };
        btnRegister = new javax.swing.JLabel();
        btnForgot = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(51, 51, 51));
        setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("DigifaceWide", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BRACU STUDENT PORTAL");
        jLabel2.setToolTipText("");

        lblId.setBackground(new java.awt.Color(27, 27, 27));
        lblId.setForeground(new java.awt.Color(204, 204, 204));
        lblId.setLabelFor(txtId);
        lblId.setText("BRACU ID");

        txtId.setBackground(new java.awt.Color(62, 62, 62));
        txtId.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtId.setForeground(new java.awt.Color(204, 204, 204));
        txtId.setText("18301264");
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        lblPassword.setBackground(new java.awt.Color(27, 27, 27));
        lblPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblPassword.setLabelFor(txtPassword);
        lblPassword.setText("Password");

        jPanel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(51, 51, 51));
        btnLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogin.setText("LOGIN");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLoginMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLoginMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        btnRegister.setForeground(new java.awt.Color(255, 255, 153));
        btnRegister.setText("Do not have an account?");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        btnForgot.setForeground(new java.awt.Color(255, 255, 153));
        btnForgot.setText("Forgot password?");
        btnForgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPassword.setBackground(new java.awt.Color(62, 62, 62));
        txtPassword.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("123456");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnForgot))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegister)))
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(btnRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(btnForgot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        drawRoundRect(btnLogin.getGraphics(), btnLogin, new Color(40, 101, 162), false);
        drawString(btnLogin.getGraphics(), btnLogin, btnLogin.getText());
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMousePressed
        drawRoundRect(btnLogin.getGraphics(), btnLogin, new Color(40, 61, 122), false);
        drawString(btnLogin.getGraphics(), btnLogin, btnLogin.getText());
    }//GEN-LAST:event_btnLoginMousePressed

    private void btnLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseReleased
        drawRoundRect(btnLogin.getGraphics(), btnLogin, new Color(40, 101, 162), false);
        drawString(btnLogin.getGraphics(), btnLogin, btnLogin.getText());
    }//GEN-LAST:event_btnLoginMouseReleased

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        drawRoundRect(btnLogin.getGraphics(), btnLogin, new Color(40, 81, 142), false);
        drawString(btnLogin.getGraphics(), btnLogin, btnLogin.getText());
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        if (loginThread == null || loginThread.getState() == Thread.State.TERMINATED) (loginThread = new Thread(loginProcess)).start();
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        RegisterPanel registerPanel = new RegisterPanel();
        if (parentDialog == null) new DialogForm(parentFrame, true, registerPanel, "Create a new account", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, registerPanel, "Create a new account", true, true, true).setVisible(true);
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && (loginThread == null || loginThread.getState() == Thread.State.TERMINATED)) (loginThread = new Thread(loginProcess)).start();
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) txtPassword.requestFocus();
    }//GEN-LAST:event_txtIdKeyReleased
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnForgot;
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel btnRegister;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
