package view;

import controller.AccountController;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.swing.SwingUtilities;
import model.User;

public class AccountPanel extends javax.swing.JPanel {
    
    Runnable updateStudentInfoProcess = new Runnable() {
        @Override
        public void run() {
            DialogForm parent = (DialogForm) SwingUtilities.getWindowAncestor(me);
            DialogTitlePanel titlePanel = (DialogTitlePanel) parent.panelTitleBar.getComponent(0);
            titlePanel.btnClose.setVisible(false);
            if (AccountController.updateUserInfo(parent)) {
                loggedInUser.requestUpdate();
                SuccessPanel successPanel = new SuccessPanel("User information updated successfully");
                new DialogForm(parent, true, successPanel, "User information changed", true, true, true).setVisible(true);
            }
            titlePanel.btnClose.setVisible(true);
        }
    };
    Thread updateStudentInfoThread;
    
    User loggedInUser;
    AccountPanel me;
    
    public AccountPanel() {
        initComponents();
        me = this;
        loggedInUser = User.getUser();
        txtId.setText(String.valueOf(loggedInUser.getId()));
        txtBirthdate.setText(String.format("%td/%<tm/%<tY", loggedInUser.getBirthdate()));
        txtPhone.setText(loggedInUser.getPhoneNumber());
        txtName.setText(loggedInUser.getName());
        txtDepartment.setText(loggedInUser.getDepartment().toString());
        txtEnrolledSemester.setText(loggedInUser.getSemester().toString());
        txtEmail.setText(loggedInUser.getGmail());
        imgUser.setIcon(loggedInUser.getPhoto());
    }
    
    public boolean isNameValid() {
        return txtName.getText().matches("[A-Z][a-z]*(\\.? [A-Z][a-z]*)*");
    }
    
    public boolean isPhoneValid() {
        return txtPhone.getText().matches("01[0-9]{9}");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgUser = new javax.swing.JLabel();
        btnChange = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtBirthdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEnrolledSemester = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new FlatButton();

        setBackground(new java.awt.Color(60, 50, 50));
        setMinimumSize(new java.awt.Dimension(496, 308));

        imgUser.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        imgUser.setForeground(new java.awt.Color(255, 255, 255));
        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        btnChange.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtId.setText("18301264");
        txtId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BRACU ID");

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        txtName.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtName.setText("Mohammed Julfikar Ali Mahbub");
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        txtBirthdate.setEditable(false);
        txtBirthdate.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtBirthdate.setText("16/06/1990");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date of birth");

        txtPhone.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtPhone.setText("01740894742");
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number");

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Department");

        txtDepartment.setEditable(false);
        txtDepartment.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtDepartment.setText("Department of Computer Science and Engineering");
        txtDepartment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enrolled Semester");

        txtEnrolledSemester.setEditable(false);
        txtEnrolledSemester.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtEnrolledSemester.setText("Summer 2018");
        txtEnrolledSemester.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtEmail.setText("mohammed.julfikar.ali.mahbub");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("@g.bracu.ac.bd");

        btnSave.setBackground(new java.awt.Color(204, 204, 204));
        btnSave.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 153, 0));
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDepartment, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtPhone))))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imgUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEnrolledSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChange))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnrolledSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        FileDialog openFile = new FileDialog((Frame) null, "Choose profile picture", FileDialog.LOAD);
        openFile.setVisible(true);
        
        if (openFile.getFile() != null && openFile.getFile().toLowerCase().matches(".*\\.(jpg|png|jpeg|bmp)")) {
            loggedInUser.setPhoto((openFile.getDirectory() + openFile.getFile()).replace("\\", "/"));
            
            imgUser.setIcon(loggedInUser.getPhoto());
        }
        
        openFile.dispose();
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (isPhoneValid()) loggedInUser.setPhoneNumber(txtPhone.getText());
        if (isNameValid()) loggedInUser.setName(txtName.getText());
        if (updateStudentInfoThread == null || updateStudentInfoThread.getState() == Thread.State.TERMINATED) (updateStudentInfoThread = new Thread(updateStudentInfoProcess)).start();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        if (isPhoneValid()) txtPhone.setBackground(new Color(80, 130, 80));
        else txtName.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        if (isNameValid()) txtName.setBackground(new Color(80, 130, 80));
        else txtName.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtNameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel imgUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnrolledSemester;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
