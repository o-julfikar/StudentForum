package view.feedback;

import controller.feedback.FeedbackController;
import controller.swap.Course;
import java.awt.Color;
import java.awt.Dialog;
import javax.swing.Icon;
import javax.swing.SwingUtilities;
import model.User;
import model.swap.CourseModel;
import view.DialogForm;
import view.SuccessPanel;

public class WriteFeedbackPanel extends javax.swing.JPanel {

    Runnable insertFeedbackProcess = new Runnable() {
        @Override
        public void run() {
            if (FeedbackController.insertFeedback(parentDialog, User.getUser().getId(), txtFacultyInitial.getText(), (Course) cboCourse.getSelectedItem(), txtFeedback.getText(), getPoint())) {
                SuccessPanel successPanel = new SuccessPanel("Feedback recorded successfulyy!");
                new DialogForm(parentDialog, true, successPanel, "Successful", true, true, true).setVisible(true);
                clear();
            }
        }
    };
    Thread insertFeedbackThread;
    
    Dialog parentDialog;
    
    public WriteFeedbackPanel(String name, String initial, Icon imgFaculty) {
        initComponents();
        this.txtFacultyName.setText(name);
        this.txtFacultyInitial.setText(initial);
        this.imgFaculty.setIcon(imgFaculty);
        CourseModel.fillCourseCode(cboCourse);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        parentDialog = (Dialog) SwingUtilities.getWindowAncestor(this);
    }
    
    public WriteFeedbackPanel() {
        initComponents();
        CourseModel.fillCourseCode(cboCourse);
    }
    
    public int getPoint() {
        return rating1.isSelected() ? 1 : rating2.isSelected() ? 2 : rating3.isSelected() ? 3 : rating4.isSelected() ? 4 : rating5.isSelected() ? 5 : 0;
    }
    
    public void clear() {
        cboCourse.setSelectedIndex(0);
        txtFeedback.setText("");
        rating3.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpRating = new javax.swing.ButtonGroup();
        imgFaculty = new javax.swing.JLabel();
        txtFacultyName = new javax.swing.JLabel();
        txtFacultyInitial = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        rating1 = new javax.swing.JRadioButton();
        rating2 = new javax.swing.JRadioButton();
        rating3 = new javax.swing.JRadioButton();
        rating4 = new javax.swing.JRadioButton();
        rating5 = new javax.swing.JRadioButton();
        panelSubmit = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JLabel();
        scrollFeedback = new javax.swing.JScrollPane();
        txtFeedback = new javax.swing.JTextArea();

        btnGrpRating.add(rating1);
        btnGrpRating.add(rating2);
        btnGrpRating.add(rating3);
        btnGrpRating.add(rating4);
        btnGrpRating.add(rating5);

        setBackground(new java.awt.Color(50, 80, 50));

        imgFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N
        imgFaculty.setToolTipText("");

        txtFacultyName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtFacultyName.setForeground(new java.awt.Color(204, 204, 204));
        txtFacultyName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFacultyName.setText("Default Faculty Name");

        txtFacultyInitial.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtFacultyInitial.setForeground(new java.awt.Color(204, 204, 204));
        txtFacultyInitial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFacultyInitial.setText("DFN");

        cboCourse.setBackground(new java.awt.Color(43, 55, 43));
        cboCourse.setForeground(new java.awt.Color(204, 204, 204));

        rating1.setBackground(new java.awt.Color(50, 80, 50));
        rating1.setForeground(new java.awt.Color(204, 204, 204));
        rating1.setText("Very unhappy");

        rating2.setBackground(new java.awt.Color(50, 80, 50));
        rating2.setForeground(new java.awt.Color(204, 204, 204));
        rating2.setText("Unhappy");

        rating3.setBackground(new java.awt.Color(50, 80, 50));
        rating3.setForeground(new java.awt.Color(204, 204, 204));
        rating3.setSelected(true);
        rating3.setText("Somewhat happy");

        rating4.setBackground(new java.awt.Color(50, 80, 50));
        rating4.setForeground(new java.awt.Color(204, 204, 204));
        rating4.setText("Happy");

        rating5.setBackground(new java.awt.Color(50, 80, 50));
        rating5.setForeground(new java.awt.Color(204, 204, 204));
        rating5.setText("Very happy");

        btnSubmit.setBackground(new java.awt.Color(51, 102, 230));
        btnSubmit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSubmit.setText("Submit");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setOpaque(true);
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSubmitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSubmitMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelSubmitLayout = new javax.swing.GroupLayout(panelSubmit);
        panelSubmit.setLayout(panelSubmitLayout);
        panelSubmitLayout.setHorizontalGroup(
            panelSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubmitLayout.createSequentialGroup()
                .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelSubmitLayout.setVerticalGroup(
            panelSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtFeedback.setBackground(new java.awt.Color(61, 80, 61));
        txtFeedback.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFeedback.setForeground(new java.awt.Color(255, 255, 255));
        txtFeedback.setLineWrap(true);
        txtFeedback.setMargin(new java.awt.Insets(5, 5, 5, 5));
        scrollFeedback.setViewportView(txtFeedback);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollFeedback)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgFaculty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFacultyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFacultyInitial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rating1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rating2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rating3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rating4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rating5)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgFaculty)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFacultyName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFacultyInitial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rating1)
                    .addComponent(rating2)
                    .addComponent(rating3)
                    .addComponent(rating4)
                    .addComponent(rating5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        btnSubmit.setBackground(new Color(51, 88, 250));
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
        btnSubmit.setBackground(new Color(51, 102, 230));
    }//GEN-LAST:event_btnSubmitMouseExited

    private void btnSubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMousePressed
        btnSubmit.setBackground(new Color(51, 102, 210));
    }//GEN-LAST:event_btnSubmitMousePressed

    private void btnSubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseReleased
        btnSubmit.setBackground(new Color(51, 88, 250));
    }//GEN-LAST:event_btnSubmitMouseReleased

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        if (insertFeedbackThread == null || insertFeedbackThread.getState() == Thread.State.TERMINATED) (insertFeedbackThread = new Thread(insertFeedbackProcess)).start();
    }//GEN-LAST:event_btnSubmitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpRating;
    private javax.swing.JLabel btnSubmit;
    private javax.swing.JComboBox<Course> cboCourse;
    private javax.swing.JLabel imgFaculty;
    private javax.swing.JPanel panelSubmit;
    private javax.swing.JRadioButton rating1;
    private javax.swing.JRadioButton rating2;
    private javax.swing.JRadioButton rating3;
    private javax.swing.JRadioButton rating4;
    private javax.swing.JRadioButton rating5;
    private javax.swing.JScrollPane scrollFeedback;
    private javax.swing.JLabel txtFacultyInitial;
    private javax.swing.JLabel txtFacultyName;
    private javax.swing.JTextArea txtFeedback;
    // End of variables declaration//GEN-END:variables
}
