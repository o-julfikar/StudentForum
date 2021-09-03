package view.feedback;

import controller.feedback.FacultyController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.swing.SwingUtilities;
import model.ImageResource;
import model.User;
import view.DialogForm;
import view.ErrorPanel;
import view.SuccessPanel;

public class AddFacultyPanel extends javax.swing.JPanel {

    String imgLocation;
    
    Runnable addFacultyProcess = new Runnable() {
        @Override
        public void run() {
            if (FacultyController.insertFaculty(parentDialog, txtFacultyName.getText(), txtInitial.getText(), imgLocation)) {
                SuccessPanel successPanel = new SuccessPanel("Faculty added successfully");
                new DialogForm(parentDialog, true, successPanel, "Successful", true, true, true).setVisible(true);
                numberOfNewFaculty++;
                clearAll();
            }
        }
    };
    
    Thread addFacultyThread;
    Dialog parentDialog;
    
    int numberOfNewFaculty = 0;
    
    public AddFacultyPanel() {
        initComponents();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        parentDialog = (Dialog) SwingUtilities.getWindowAncestor(this);
    }
    
    public boolean isNameValid() {
        return txtFacultyName.getText().matches("[A-Z][a-z]*(\\.? [A-Z][a-z]*)*");
    }
    
    public boolean isInitialValid() {
        return txtInitial.getText().matches("[A-Za-z]{3}");
    }
    
    public void clearAll() {
        imgFaculty.setIcon(ImageResource.userPhoto);        
        txtFacultyName.setText("");
        txtInitial.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgFaculty = new javax.swing.JLabel();
        txtFacultyName = new javax.swing.JTextField();
        lblFacultyName = new javax.swing.JLabel();
        txtInitial = new javax.swing.JTextField();
        lblInitial = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        btnAddFaculty = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setBackground(new java.awt.Color(66, 66, 66));
        setToolTipText("");

        imgFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N
        imgFaculty.setText("jLabel1");

        txtFacultyName.setBackground(new java.awt.Color(86, 86, 86));
        txtFacultyName.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtFacultyName.setForeground(new java.awt.Color(255, 255, 255));
        txtFacultyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFacultyNameKeyReleased(evt);
            }
        });

        lblFacultyName.setForeground(new java.awt.Color(204, 204, 204));
        lblFacultyName.setLabelFor(txtFacultyName);
        lblFacultyName.setText("Name");

        txtInitial.setBackground(new java.awt.Color(86, 86, 86));
        txtInitial.setColumns(3);
        txtInitial.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtInitial.setForeground(new java.awt.Color(255, 255, 255));
        txtInitial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInitialKeyReleased(evt);
            }
        });

        lblInitial.setForeground(new java.awt.Color(204, 204, 204));
        lblInitial.setLabelFor(txtInitial);
        lblInitial.setText("Initial");

        btnUpload.setBackground(new java.awt.Color(23, 60, 42));
        btnUpload.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnUpload.setForeground(new java.awt.Color(255, 255, 255));
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnAddFaculty.setBackground(new java.awt.Color(46, 46, 46));
        btnAddFaculty.setForeground(new java.awt.Color(204, 204, 204));
        btnAddFaculty.setText("Add Faculty");
        btnAddFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultyActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(46, 46, 46));
        btnReset.setForeground(new java.awt.Color(204, 204, 204));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(153, 0, 51));
        btnRemove.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.setToolTipText("");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgFaculty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFacultyName)
                    .addComponent(txtInitial)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFacultyName)
                            .addComponent(lblInitial))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(btnAddFaculty)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemove)
                            .addComponent(btnReset)
                            .addComponent(btnAddFaculty)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFacultyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFacultyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInitial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFacultyActionPerformed
        if (isNameValid() && isInitialValid()) {
            if (addFacultyThread == null || addFacultyThread.getState() == Thread.State.TERMINATED) (addFacultyThread = new Thread(addFacultyProcess)).start();
        } else {
            ErrorPanel errorPanel = new ErrorPanel("Please enter the value of field(s) in red correctly");
            new DialogForm(parentDialog, true, errorPanel, "Please enter correct values", true, true, true).setVisible(true);
        }
    }//GEN-LAST:event_btnAddFacultyActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        FileDialog openFile = new FileDialog((Frame) null, "Choose a photo", FileDialog.LOAD);
        openFile.setVisible(true);
        
        if (openFile.getFile() != null && openFile.getFile().toLowerCase().matches(".*\\.(jpg|png|jpeg|bmp)")) {
            imgLocation = openFile.getDirectory().replace("\\", "/") + openFile.getFile().replace("\\", "/");
                        
            imgFaculty.setIcon(User.getProfilePhoto(imgLocation));
        }
        
        openFile.dispose();
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        imgFaculty.setIcon(ImageResource.userPhoto);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearAll();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtFacultyNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacultyNameKeyReleased
        if (isNameValid()) txtFacultyName.setBackground(new Color(80, 130, 80));
        else txtFacultyName.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtFacultyNameKeyReleased

    private void txtInitialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInitialKeyReleased
        if (isInitialValid()) txtInitial.setBackground(new Color(80, 130, 80));
        else txtInitial.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtInitialKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFaculty;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel imgFaculty;
    private javax.swing.JLabel lblFacultyName;
    private javax.swing.JLabel lblInitial;
    private javax.swing.JTextField txtFacultyName;
    private javax.swing.JTextField txtInitial;
    // End of variables declaration//GEN-END:variables
}
