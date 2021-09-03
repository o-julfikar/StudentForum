package view.feedback;

public class ReviewCard extends javax.swing.JPanel {

    public ReviewCard(String course, String text) {
        initComponents();
        txtFeedbackCourse.setText(course);
        txtFeedbackText.setText(text);
    }
    
    public ReviewCard() {
        this("NULL00", "No review");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFeedbackCourse = new javax.swing.JPanel();
        txtFeedbackCourse = new javax.swing.JLabel();
        scrollFeedbackText = new javax.swing.JScrollPane();
        txtFeedbackText = new javax.swing.JTextArea();

        txtFeedbackCourse.setBackground(new java.awt.Color(0, 102, 204));
        txtFeedbackCourse.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtFeedbackCourse.setForeground(new java.awt.Color(204, 204, 204));
        txtFeedbackCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFeedbackCourse.setText("CSE110");
        txtFeedbackCourse.setOpaque(true);

        javax.swing.GroupLayout panelFeedbackCourseLayout = new javax.swing.GroupLayout(panelFeedbackCourse);
        panelFeedbackCourse.setLayout(panelFeedbackCourseLayout);
        panelFeedbackCourseLayout.setHorizontalGroup(
            panelFeedbackCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFeedbackCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        panelFeedbackCourseLayout.setVerticalGroup(
            panelFeedbackCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFeedbackCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scrollFeedbackText.setBackground(new java.awt.Color(83, 83, 83));

        txtFeedbackText.setEditable(false);
        txtFeedbackText.setBackground(new java.awt.Color(83, 83, 83));
        txtFeedbackText.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtFeedbackText.setForeground(new java.awt.Color(204, 204, 204));
        txtFeedbackText.setLineWrap(true);
        txtFeedbackText.setText("No review");
        txtFeedbackText.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtFeedbackText.setPreferredSize(new java.awt.Dimension(400, 35));
        scrollFeedbackText.setViewportView(txtFeedbackText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFeedbackCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollFeedbackText, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFeedbackCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollFeedbackText, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelFeedbackCourse;
    private javax.swing.JScrollPane scrollFeedbackText;
    private javax.swing.JLabel txtFeedbackCourse;
    private javax.swing.JTextArea txtFeedbackText;
    // End of variables declaration//GEN-END:variables
}
