package view;

import controller.AccountController;
import java.awt.Dialog;
import javax.swing.SwingUtilities;
import model.User;

public class SecurityPanel extends javax.swing.JPanel {

    Runnable updateUserPasswordProcess = new Runnable() {
        @Override
        public void run() {
            DialogForm parent = (DialogForm) SwingUtilities.getWindowAncestor(me);
            DialogTitlePanel titlePanel = (DialogTitlePanel) parent.panelTitleBar.getComponent(0);
            titlePanel.btnClose.setVisible(false);
            if (AccountController.updateUserPassword(parentDialog)){
                SuccessPanel successPanel = new SuccessPanel("Password updated successfully");
                new DialogForm(parentDialog, true, successPanel, "Password changed", true, true, true).setVisible(true);
            }
            titlePanel.btnClose.setVisible(true);
        }
    };
    Thread updateUserPasswordThread;
    
    SecurityPanel me;
    Dialog parentDialog;
    
    public SecurityPanel() {
        initComponents();
        me = this;
    }
    
    public boolean isPasswordValid() {
        return String.valueOf(txtNewPassword.getPassword()).equals(String.valueOf(txtConfirmPassword.getPassword()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurrentPassword = new javax.swing.JLabel();
        txtCurrentPassword = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        btnSave = new FlatButton();

        setBackground(new java.awt.Color(60, 50, 50));

        lblCurrentPassword.setBackground(new java.awt.Color(204, 204, 204));
        lblCurrentPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblCurrentPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblCurrentPassword.setText("Current password");

        txtCurrentPassword.setBackground(new java.awt.Color(67, 67, 67));
        txtCurrentPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtCurrentPassword.setForeground(new java.awt.Color(255, 255, 255));

        lblNewPassword.setBackground(new java.awt.Color(204, 204, 204));
        lblNewPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblNewPassword.setText("New password");

        lblConfirmPassword.setBackground(new java.awt.Color(204, 204, 204));
        lblConfirmPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblConfirmPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblConfirmPassword.setText("Confirm password");

        txtConfirmPassword.setBackground(new java.awt.Color(67, 67, 67));
        txtConfirmPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));

        txtNewPassword.setBackground(new java.awt.Color(67, 67, 67));
        txtNewPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtNewPassword.setForeground(new java.awt.Color(255, 255, 255));

        btnSave.setBackground(new java.awt.Color(204, 204, 204));
        btnSave.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 153, 51));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setOpaque(true);
        ((FlatButton) btnSave).addListeners();
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 278, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCurrentPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurrentPassword)
                            .addComponent(lblNewPassword)
                            .addComponent(lblConfirmPassword))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurrentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfirmPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (String.valueOf(txtCurrentPassword.getPassword()).equals(User.getUser().getPassword())) {
            if (String.valueOf(txtNewPassword.getPassword()).trim().length() < 6) {
                ErrorPanel errorPanel = new ErrorPanel("Password must be at least 6 length");
                DialogForm dialogForm = new DialogForm(parentDialog, true, errorPanel, "Invalid Password", true, true, true);
                dialogForm.setVisible(true);
            } else if (isPasswordValid()) {
                User.getUser().setPassword(String.valueOf(txtNewPassword.getPassword()));
                if (updateUserPasswordThread == null || updateUserPasswordThread.getState() == Thread.State.TERMINATED) (updateUserPasswordThread = new Thread(updateUserPasswordProcess)).start();
            } else {
                ErrorPanel errorPanel = new ErrorPanel("New password did not match");
                DialogForm dialogForm = new DialogForm(parentDialog, true, errorPanel, "Password mismatch", true, true, true);
                dialogForm.setVisible(true);
            }
        } else {
            ErrorPanel errorPanel = new ErrorPanel("Current password does not match");
            DialogForm dialogForm = new DialogForm(parentDialog, true, errorPanel, "Password did not match", true, true, true);
            dialogForm.setVisible(true);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    @Override
    public void addNotify() {
        super.addNotify();
        parentDialog = (Dialog) SwingUtilities.getWindowAncestor(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCurrentPassword;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtNewPassword;
    // End of variables declaration//GEN-END:variables
}
