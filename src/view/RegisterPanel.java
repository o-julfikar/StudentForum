package view;

import controller.AccountController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.swing.SwingUtilities;
import model.Department;
import model.ImageResource;
import model.Semester;
import model.User;

public class RegisterPanel extends javax.swing.JPanel {

    private long depTimer;
    private String imgLocation = "";
    private Runnable idParser = new Runnable() {
        @Override
        public void run() {
            while (System.currentTimeMillis() - depTimer <= 10000) {
                if (txtId.getText().matches("[0-9]{5}[0-9]*")) {
                    String dept = Department.getDepartment(Integer.parseInt(txtId.getText().substring(3, 5)));
                    if(!txtDepartment.isFocusOwner()) txtDepartment.setText(dept == null? "Unavailable" : dept);
                    txtSemester.setText(new Semester(Integer.parseInt(txtId.getText().substring(2, 3)), Integer.parseInt(txtId.getText().substring(0, 2))).toString());
                } else if (txtId.getText().matches("[0-9]{3}[0-9]*")) {
                    if(!txtDepartment.isFocusOwner()) txtDepartment.setText("Unavailable");
                    txtSemester.setText(new Semester(Integer.parseInt(txtId.getText().substring(2, 3)), Integer.parseInt(txtId.getText().substring(0, 2))).toString());
                }
            }
        }
    };
    
    private Thread idParserThread = new Thread(idParser);
    Dialog parentDialog;
    String rs = "";
    
    public RegisterPanel() {
        initComponents();
    }
    
    public void clearAll() {
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtBirthdate.setText("");
        txtPhone.setText("");
        txtDepartment.setText("");
        txtSemester.setText("");
        txtPassword.setText("");
        txtConfirm.setText("");
        cboRole.setSelectedIndex(2);
        imgUser.setIcon(ImageResource.userPhoto);
    }

    // <editor-fold defaultstate="collapsed" desc="isValid Methods">
    public boolean isIDValid() {
        return txtId.getText().matches("[0-9]{8}");
    }
    
    public boolean isNameValid() {
        return txtName.getText().matches("[A-Z][a-z]*(\\.? [A-Z][a-z]*)*");
    }
    
    public boolean isEmailValid() {
        return txtEmail.getText().matches("[a-z0-9]+(\\.[a-z0-9]+)*");
    }
    
    public boolean isBirthdateValid() {
        return txtBirthdate.getText().matches("((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/\\d{4}");
    }
    
    public boolean isPhoneValid() {
        return txtPhone.getText().matches("01[0-9]{9}");
    }
    
    public boolean isPasswordValid() {
        return String.valueOf(txtPassword.getPassword()).trim().length() >= 6 && String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtConfirm.getPassword()));
    }
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        imgUser = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirm = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtBirthdate = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JTextField();
        txtSemester = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("BRACU ID");

        jLabel2.setFont(new java.awt.Font("DigifaceWide", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BRACU STUDENT PORTAL");
        jLabel2.setToolTipText("");

        txtId.setBackground(new java.awt.Color(62, 62, 62));
        txtId.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Full name");

        txtName.setBackground(new java.awt.Color(62, 62, 62));
        txtName.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Email");

        txtEmail.setBackground(new java.awt.Color(62, 62, 62));
        txtEmail.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("@g.bracu.ac.bd");

        imgUser.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        btnUpload.setBackground(new java.awt.Color(28, 28, 28));
        btnUpload.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnUpload.setForeground(new java.awt.Color(255, 255, 255));
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Date of birth");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Password");

        txtPassword.setBackground(new java.awt.Color(62, 62, 62));
        txtPassword.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        txtConfirm.setBackground(new java.awt.Color(62, 62, 62));
        txtConfirm.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtConfirm.setForeground(new java.awt.Color(255, 255, 255));
        txtConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Confirm password");

        txtBirthdate.setBackground(new java.awt.Color(62, 62, 62));
        txtBirthdate.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtBirthdate.setForeground(new java.awt.Color(255, 255, 255));
        txtBirthdate.setToolTipText("Date of birth (dd/mm/yyyy)");
        txtBirthdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBirthdateKeyReleased(evt);
            }
        });

        txtPhone.setBackground(new java.awt.Color(62, 62, 62));
        txtPhone.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Phone number");

        txtDepartment.setBackground(new java.awt.Color(62, 62, 62));
        txtDepartment.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtDepartment.setForeground(new java.awt.Color(255, 255, 255));

        txtSemester.setEditable(false);
        txtSemester.setBackground(new java.awt.Color(62, 62, 62));
        txtSemester.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtSemester.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Department");

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Enroll semester");

        cboRole.setBackground(new java.awt.Color(62, 62, 62));
        cboRole.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cboRole.setForeground(new java.awt.Color(255, 255, 255));
        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Power Admin", "Admin", "Student", "Other" }));
        cboRole.setSelectedIndex(2);

        jLabel13.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Role");

        btnSubmit.setBackground(new java.awt.Color(28, 28, 28));
        btnSubmit.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(28, 28, 28));
        btnRemove.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(28, 28, 28));
        btnReset.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imgUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpload, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDepartment)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jLabel9)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgUser)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpload))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Key Realeased Events">
    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        if (txtId.getText().matches("[0-9]{8}")) txtId.setForeground(new Color(0, 150, 0));
        else txtId.setForeground(new Color(200, 60, 60));
        
        if (!idParserThread.isAlive()) (idParserThread = new Thread(idParser)).start();
        depTimer = System.currentTimeMillis();
    }//GEN-LAST:event_txtIdKeyReleased

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        if (txtName.getText().matches("[A-Z][a-z]*(\\.? [A-Z][a-z]*)*")) txtName.setForeground(new Color(0, 150, 0));
        else txtName.setForeground(new Color(200, 60, 60));
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if (txtEmail.getText().matches("[a-z0-9]+(\\.[a-z0-9]+)*")) txtEmail.setForeground(new Color(0, 150, 0));
        else txtEmail.setForeground(new Color(200, 60, 60));
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtBirthdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBirthdateKeyReleased
        if (txtBirthdate.getText().matches("((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/\\d{4}")) txtBirthdate.setForeground(new Color(0, 150, 0));
        else txtBirthdate.setForeground(new Color(200, 60, 60));
    }//GEN-LAST:event_txtBirthdateKeyReleased

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        if (txtPhone.getText().matches("01[0-9]{9}")) txtPhone.setForeground(new Color(0, 150, 0));
        else txtPhone.setForeground(new Color(200, 60, 60));
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (String.valueOf(txtPassword.getPassword()).trim().length() >= 6) txtPassword.setForeground(new Color(0, 150, 0));
        else txtPassword.setForeground(new Color(200, 60, 60));
        
        if (String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtConfirm.getPassword()))) txtConfirm.setForeground(new Color(0, 150, 0));
        else txtConfirm.setForeground(new Color(200, 60, 60));
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtConfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmKeyReleased
        if (String.valueOf(txtConfirm.getPassword()).equals(String.valueOf(txtPassword.getPassword()))) txtConfirm.setForeground(new Color(0, 150, 0));
        else txtConfirm.setForeground(new Color(200, 60, 60));
    }//GEN-LAST:event_txtConfirmKeyReleased
    // </editor-fold>
    
    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        FileDialog openFile = new FileDialog((Frame) null, "Choose a photo", FileDialog.LOAD);
        openFile.setVisible(true);
        
        if (openFile.getFile() != null && openFile.getFile().toLowerCase().matches(".*\\.(jpg|png|jpeg|bmp)")) {
            imgLocation = (openFile.getDirectory() + openFile.getFile()).replace("\\", "/");
            
            imgUser.setIcon(User.getProfilePhoto(imgLocation));
        }
        
        openFile.dispose();
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        imgUser.setIcon(ImageResource.userPhoto);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearAll();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (parentDialog == null) parentDialog = (Dialog) SwingUtilities.getWindowAncestor(this);
        int totalValid = 0;
        Color wrongInputColor = new Color(200, 60, 60);
        if (isIDValid()) totalValid++; else txtId.setForeground(wrongInputColor);
        if (isNameValid()) totalValid++; else txtName.setForeground(wrongInputColor);
        if (isEmailValid()) totalValid++; else txtEmail.setForeground(wrongInputColor);
        if (isBirthdateValid()) totalValid++; else txtBirthdate.setForeground(wrongInputColor);
        if (isPhoneValid()) totalValid++; else txtPhone.setForeground(wrongInputColor);
        if (isPasswordValid()) totalValid++; else { if (txtPassword.getPassword().length < 6) txtPassword.setForeground(wrongInputColor); txtConfirm.setForeground(wrongInputColor); }
        
        if (totalValid == 6) {
            String[] bDate = txtBirthdate.getText().split("/");
            
            if (AccountController.registerUser(parentDialog, txtId.getText(), txtName.getText(), 
                    String.format("%s/%s/%s", bDate[2], bDate[1], bDate[0]), txtDepartment.getText(), 
                    txtSemester.getText(), txtPhone.getText(), txtEmail.getText(), 
                    String.valueOf(txtPassword.getPassword()), imgLocation, cboRole.getSelectedIndex())) {
                
                ErrorPanel successPanel = new ErrorPanel("Account created successfully");
                successPanel.setBackground(new Color(70, 150, 70));
                new DialogForm(parentDialog, true, successPanel, "Successful", true, true, true).setVisible(true);
                clearAll();
            }
        } else {
            ErrorPanel errorPanel = new ErrorPanel("Please enter values for the field(s) in red correctly " + rs);
            new DialogForm((Dialog) SwingUtilities.getWindowAncestor(this), true, errorPanel, "Error", true, true, true).setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JLabel imgUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSemester;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
