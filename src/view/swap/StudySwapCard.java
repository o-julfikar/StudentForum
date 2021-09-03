package view.swap;

import model.ImageResource;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;

public class StudySwapCard extends javax.swing.JPanel {

    public StudySwapCard(String course, String day, String time, String teacherName, Icon teacherImage, String learnerName, Icon learnerImage) {
        initComponents();
        txtCourse.setText(course);
        txtDay.setText(day);
        txtTime.setText(time);
        txtTeacherName.setText("Teacher: " + teacherName);
        imgTeacher.setIcon(teacherImage);
        txtLearnerName.setText("Learner: " + learnerName);
        imgLearner.setIcon(learnerImage);
        setOpaque(false);
    }
    
    public StudySwapCard() {
        this("CSE110", "Saturday", "9:30 AM", "John", ImageResource.userPhoto, "Smith", ImageResource.userPhoto);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cornerRadius = 30;
        Graphics2D graphics = (Graphics2D) g;
        
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        graphics.setColor(getForeground());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgTeacher = new javax.swing.JLabel();
        imgLearner = new javax.swing.JLabel();
        panelStudyInfo = new javax.swing.JPanel();
        txtCourse = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtTeacherName = new javax.swing.JLabel();
        txtLearnerName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 47, 71));

        imgTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        imgLearner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        panelStudyInfo.setBackground(new java.awt.Color(0, 47, 71));

        txtCourse.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtCourse.setForeground(new java.awt.Color(204, 204, 204));
        txtCourse.setText("CSE110");

        txtDay.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtDay.setForeground(new java.awt.Color(204, 204, 204));
        txtDay.setText("Saturday");

        txtTime.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTime.setForeground(new java.awt.Color(204, 204, 204));
        txtTime.setText("9:30 AM");

        javax.swing.GroupLayout panelStudyInfoLayout = new javax.swing.GroupLayout(panelStudyInfo);
        panelStudyInfo.setLayout(panelStudyInfoLayout);
        panelStudyInfoLayout.setHorizontalGroup(
            panelStudyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudyInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourse)
                    .addComponent(txtDay)
                    .addComponent(txtTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelStudyInfoLayout.setVerticalGroup(
            panelStudyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudyInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTime)
                .addContainerGap())
        );

        txtTeacherName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtTeacherName.setForeground(new java.awt.Color(204, 204, 204));
        txtTeacherName.setText("Teacher: John");

        txtLearnerName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtLearnerName.setForeground(new java.awt.Color(204, 204, 204));
        txtLearnerName.setText("Learner: Smith");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(panelStudyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(imgLearner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTeacherName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtLearnerName)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(txtTeacherName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelStudyInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgLearner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLearnerName)
                .addGap(0, 34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLearner;
    private javax.swing.JLabel imgTeacher;
    private javax.swing.JPanel panelStudyInfo;
    private javax.swing.JLabel txtCourse;
    private javax.swing.JLabel txtDay;
    private javax.swing.JLabel txtLearnerName;
    private javax.swing.JLabel txtTeacherName;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
