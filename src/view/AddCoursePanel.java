package view;

import controller.CourseController;
import java.awt.Color;
import java.awt.Dialog;
import javax.swing.SwingUtilities;

public class AddCoursePanel extends javax.swing.JPanel {

    Runnable addCourseProcess = new Runnable() {
        @Override
        public void run() {
            if (txtSection.getText().length() == 0) {
                if (!CourseController.addCourse(parentDialog, txtCourseCode.getText(), txtCourseTitle.getText())) {
                    SuccessPanel successPanel = new SuccessPanel("Course added successfully!");
                    DialogForm dialogForm = new DialogForm(parentDialog, true, successPanel, "Successful", true, true, true);
                    dialogForm.setVisible(true);
                }
            } else if (!isCourseTitleEmpty()) {
                if (CourseController.addCourseWithSection(parentDialog, txtCourseCode.getText(), txtCourseTitle.getText(), txtSection.getText())) {
                    SuccessPanel successPanel = new SuccessPanel("Course and section updated successfully!");
                    DialogForm dialogForm = new DialogForm(parentDialog, true, successPanel, "Successful", true, true, true);
                    dialogForm.setVisible(true);
                }
            } else if (CourseController.addCourseSection(parentDialog, txtCourseCode.getText(), txtSection.getText())) {
                SuccessPanel successPanel = new SuccessPanel("Course section updated successfully!");
                DialogForm dialogForm = new DialogForm(parentDialog, true, successPanel, "Successful", true, true, true);
                dialogForm.setVisible(true);
            }
        }
    };
    Thread addCourseThread;
    Dialog parentDialog;
    
    public AddCoursePanel() {
        initComponents();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        parentDialog = (Dialog) SwingUtilities.getWindowAncestor(this);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Check Valid Method">
    public boolean isCourseCodeValid() {
        return txtCourseCode.getText().matches("[A-Z]{3}[0-9]{3}");
    }
    
    public boolean isCourseTitleValid() {
        return txtCourseTitle.getText().matches("[A-Z][a-z]*(\\.? [A-Z][A-Za-z]*)*( [0-9]*)?");
    }
    
    public boolean isSectionValid() {
        return txtSection.getText().matches("([0-9]{1,2})|([0-9]{1,2}( )*\\-( )*[0-9]{1,2})");
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Check Empty Method">
    public boolean isCourseCodeEmpty() {
        return txtCourseCode.getText().length() == 0;
    }
    
    public boolean isCourseTitleEmpty() {
        return txtCourseTitle.getText().length() == 0;
    }
    
    public boolean isSectionEmpty() {
        return txtSection.getText().length() == 0;
    }
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCourseCode = new javax.swing.JTextField();
        lblCourseCode = new javax.swing.JLabel();
        txtCourseTitle = new javax.swing.JTextField();
        lblCourseTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtSection = new javax.swing.JTextField();
        lblSection = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        txtCourseCode.setBackground(new java.awt.Color(70, 70, 70));
        txtCourseCode.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        txtCourseCode.setForeground(new java.awt.Color(204, 204, 204));
        txtCourseCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCourseCodeKeyReleased(evt);
            }
        });

        lblCourseCode.setBackground(new java.awt.Color(153, 153, 153));
        lblCourseCode.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblCourseCode.setForeground(new java.awt.Color(204, 204, 204));
        lblCourseCode.setText("Course code");

        txtCourseTitle.setBackground(new java.awt.Color(70, 70, 70));
        txtCourseTitle.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        txtCourseTitle.setForeground(new java.awt.Color(204, 204, 204));
        txtCourseTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCourseTitleKeyReleased(evt);
            }
        });

        lblCourseTitle.setBackground(new java.awt.Color(153, 153, 153));
        lblCourseTitle.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblCourseTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblCourseTitle.setText("Course Title");

        btnAdd.setBackground(new java.awt.Color(51, 102, 255));
        btnAdd.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        btnAdd.setText("Add Course");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtSection.setBackground(new java.awt.Color(70, 70, 70));
        txtSection.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        txtSection.setForeground(new java.awt.Color(204, 204, 204));
        txtSection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSectionKeyReleased(evt);
            }
        });

        lblSection.setBackground(new java.awt.Color(153, 153, 153));
        lblSection.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblSection.setForeground(new java.awt.Color(204, 204, 204));
        lblSection.setText("Section");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCourseCode)
                            .addComponent(txtCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCourseTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCourseTitle)
                                .addGap(0, 177, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSection)
                            .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseCode)
                    .addComponent(lblCourseTitle)
                    .addComponent(lblSection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!isCourseCodeEmpty() && isCourseCodeValid() && ((!isCourseTitleEmpty() && isCourseTitleValid()) || (!isSectionEmpty() && isSectionValid()))) {
            if (addCourseThread == null || addCourseThread.getState() == Thread.State.TERMINATED) (addCourseThread = new Thread(addCourseProcess)).start();
        } else {
            ErrorPanel errorPanel = new ErrorPanel("Please correct the value for field(s) in red");
            DialogForm dialogForm = new DialogForm(parentDialog, true, errorPanel, "Please fill required field", true, true, true);
            dialogForm.setVisible(true);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtCourseCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseCodeKeyReleased
        if (isCourseCodeValid()) txtCourseCode.setBackground(new Color(80, 130, 80));
        else txtCourseCode.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtCourseCodeKeyReleased

    private void txtCourseTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseTitleKeyReleased
        if (isCourseTitleValid() || isCourseTitleEmpty()) txtCourseTitle.setBackground(new Color(80, 130, 80));
        else txtCourseTitle.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtCourseTitleKeyReleased

    private void txtSectionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSectionKeyReleased
        if (isSectionValid()) txtSection.setBackground(new Color(80, 130, 80));
        else txtSection.setBackground(new Color(120, 60, 60));
    }//GEN-LAST:event_txtSectionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel lblCourseCode;
    private javax.swing.JLabel lblCourseTitle;
    private javax.swing.JLabel lblSection;
    private javax.swing.JTextField txtCourseCode;
    private javax.swing.JTextField txtCourseTitle;
    private javax.swing.JTextField txtSection;
    // End of variables declaration//GEN-END:variables
}
