package view.feedback;

import controller.feedback.FacultyController;
import controller.feedback.FeedbackController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import model.ImageResource;
import model.User;
import view.DialogForm;

public class FeedbackCard extends javax.swing.JPanel {

    double point;
    String facultyInitial;
    
    Runnable loadFacultyProcess = new Runnable() {
        @Override
        public void run() {
            setStarFor(FeedbackController.getReviewPoint(parentFrame, parentDialog, facultyInitial));
            panelStar.revalidate();
        }
    };
    Thread loadFacultyThread;
    Frame parentFrame;
    Dialog parentDialog;
    
    public FeedbackCard(String facultyName, String facultyInitial, String photoURL, double point) {
        initComponents();
        setFacultyName(facultyName);
        setFacultyInitial(this.facultyInitial = facultyInitial);
        setStarFor(point);
        imgFaculty.setIcon(User.getProfilePhoto(photoURL));
        this.point = point;
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    public FeedbackCard() {
        initComponents();
    }
    
    private void setFacultyName(String name) {
        txtFacultyName.setText(name);
    }
    
    private void setFacultyInitial(String initial) {
        txtFacultyInitial.setText(initial);
    }
    
    private void setStarFor(double point) {
        JLabel[] star = {imgStar1, imgStar2, imgStar3, imgStar4, imgStar5};
        double rating = point;
        
        for (int i = 0; i < 5; i++) {
            if (point >= 0.9) {
                star[i].setIcon(ImageResource.fullStar);
            } else if (point >= 0.45) {
                star[i].setIcon(ImageResource.halfStar);
            } else {
                star[i].setIcon(ImageResource.zeroStar);
            }
            point--;
        }
        
        txtRating.setText(String.format("%.1f out of 5.0", rating));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgFaculty = new javax.swing.JLabel();
        txtFacultyName = new javax.swing.JLabel();
        txtFacultyInitial = new javax.swing.JLabel();
        panelButton = new javax.swing.JPanel();
        panelWriteReview = new javax.swing.JPanel();
        btnWriteReview = new javax.swing.JLabel();
        panelReadReview = new javax.swing.JPanel();
        btnReadReview = new javax.swing.JLabel();
        panelStar = new javax.swing.JPanel();
        imgStar1 = new javax.swing.JLabel();
        imgStar2 = new javax.swing.JLabel();
        imgStar3 = new javax.swing.JLabel();
        imgStar4 = new javax.swing.JLabel();
        imgStar5 = new javax.swing.JLabel();
        txtRating = new javax.swing.JLabel();

        setBackground(new java.awt.Color(55, 55, 55));

        imgFaculty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N
        imgFaculty.setToolTipText("");

        txtFacultyName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtFacultyName.setForeground(new java.awt.Color(204, 204, 204));
        txtFacultyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFacultyName.setText("Default Faculty Name");

        txtFacultyInitial.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtFacultyInitial.setForeground(new java.awt.Color(204, 204, 204));
        txtFacultyInitial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFacultyInitial.setText("DFN");

        panelButton.setBackground(new java.awt.Color(24, 24, 24));
        panelButton.setPreferredSize(new java.awt.Dimension(0, 50));

        btnWriteReview.setBackground(new java.awt.Color(51, 102, 0));
        btnWriteReview.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnWriteReview.setForeground(new java.awt.Color(204, 204, 204));
        btnWriteReview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnWriteReview.setText("Write a review");
        btnWriteReview.setMaximumSize(new java.awt.Dimension(120, 24));
        btnWriteReview.setMinimumSize(new java.awt.Dimension(120, 24));
        btnWriteReview.setOpaque(true);
        btnWriteReview.setPreferredSize(new java.awt.Dimension(120, 24));
        btnWriteReview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWriteReviewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnWriteReviewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnWriteReviewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnWriteReviewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnWriteReviewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelWriteReviewLayout = new javax.swing.GroupLayout(panelWriteReview);
        panelWriteReview.setLayout(panelWriteReviewLayout);
        panelWriteReviewLayout.setHorizontalGroup(
            panelWriteReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
            .addGroup(panelWriteReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnWriteReview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
        );
        panelWriteReviewLayout.setVerticalGroup(
            panelWriteReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(panelWriteReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnWriteReview, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        panelReadReview.setPreferredSize(new java.awt.Dimension(200, 50));

        btnReadReview.setBackground(new java.awt.Color(153, 51, 0));
        btnReadReview.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnReadReview.setForeground(new java.awt.Color(204, 204, 204));
        btnReadReview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReadReview.setText("Read reviews");
        btnReadReview.setOpaque(true);
        btnReadReview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReadReviewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReadReviewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReadReviewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReadReviewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnReadReviewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelReadReviewLayout = new javax.swing.GroupLayout(panelReadReview);
        panelReadReview.setLayout(panelReadReviewLayout);
        panelReadReviewLayout.setHorizontalGroup(
            panelReadReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
            .addGroup(panelReadReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnReadReview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );
        panelReadReviewLayout.setVerticalGroup(
            panelReadReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(panelReadReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnReadReview, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addComponent(panelWriteReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelReadReview, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelWriteReview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelReadReview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelStar.setBackground(new java.awt.Color(55, 55, 55));
        panelStar.setPreferredSize(new java.awt.Dimension(274, 50));

        imgStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_half - 50px.png"))); // NOI18N

        javax.swing.GroupLayout panelStarLayout = new javax.swing.GroupLayout(panelStar);
        panelStar.setLayout(panelStarLayout);
        panelStarLayout.setHorizontalGroup(
            panelStarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStarLayout.createSequentialGroup()
                .addComponent(imgStar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgStar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgStar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgStar4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgStar5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelStarLayout.setVerticalGroup(
            panelStarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(imgStar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgStar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(imgStar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imgStar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imgStar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtRating.setForeground(new java.awt.Color(204, 204, 204));
        txtRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRating.setText("4.5 out of 5.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFacultyName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFacultyInitial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelStar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imgFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRating, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgFaculty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFacultyName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFacultyInitial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRating)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnWriteReviewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWriteReviewMouseEntered
        btnWriteReview.setBackground(new Color(51, 120, 0));
    }//GEN-LAST:event_btnWriteReviewMouseEntered

    private void btnWriteReviewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWriteReviewMousePressed
        btnWriteReview.setBackground(new Color(51, 80, 0));
    }//GEN-LAST:event_btnWriteReviewMousePressed

    private void btnWriteReviewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWriteReviewMouseReleased
        btnWriteReview.setBackground(new Color(51, 120, 0));
    }//GEN-LAST:event_btnWriteReviewMouseReleased

    private void btnWriteReviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWriteReviewMouseExited
        btnWriteReview.setBackground(new Color(51, 102, 0));
    }//GEN-LAST:event_btnWriteReviewMouseExited

    private void btnReadReviewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadReviewMouseEntered
        btnReadReview.setBackground(new Color(173, 51, 0));
    }//GEN-LAST:event_btnReadReviewMouseEntered

    private void btnReadReviewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadReviewMousePressed
        btnReadReview.setBackground(new Color(133, 51, 0));
    }//GEN-LAST:event_btnReadReviewMousePressed

    private void btnReadReviewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadReviewMouseReleased
        btnReadReview.setBackground(new Color(173, 51, 0));
    }//GEN-LAST:event_btnReadReviewMouseReleased

    private void btnReadReviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadReviewMouseExited
        btnReadReview.setBackground(new Color(153, 51, 0));
    }//GEN-LAST:event_btnReadReviewMouseExited

    private void btnWriteReviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWriteReviewMouseClicked
        WriteFeedbackPanel activityWriteFeedback = new WriteFeedbackPanel(txtFacultyName.getText(), txtFacultyInitial.getText(), imgFaculty.getIcon());
        if (parentDialog == null) new DialogForm(parentFrame, true, activityWriteFeedback, "Write a review", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, activityWriteFeedback, "Write a review", true, true, true).setVisible(true);
        if (loadFacultyThread == null || loadFacultyThread.getState() == Thread.State.TERMINATED) (loadFacultyThread = new Thread(loadFacultyProcess)).start();
    }//GEN-LAST:event_btnWriteReviewMouseClicked

    private void btnReadReviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadReviewMouseClicked
        ReadFeedbackPanel panelReadFeedback = new ReadFeedbackPanel(txtFacultyName.getText(), txtFacultyInitial.getText(), imgFaculty.getIcon(), new Icon[] {
            imgStar1.getIcon(), imgStar2.getIcon(), imgStar3.getIcon(), imgStar4.getIcon(), imgStar5.getIcon()
        });
        if (parentDialog == null) new DialogForm(parentFrame, true, panelReadFeedback, "Reviews", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, panelReadFeedback, "Reviews", true, true, true).setVisible(true);
    }//GEN-LAST:event_btnReadReviewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnReadReview;
    private javax.swing.JLabel btnWriteReview;
    private javax.swing.JLabel imgFaculty;
    private javax.swing.JLabel imgStar1;
    private javax.swing.JLabel imgStar2;
    private javax.swing.JLabel imgStar3;
    private javax.swing.JLabel imgStar4;
    private javax.swing.JLabel imgStar5;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelReadReview;
    private javax.swing.JPanel panelStar;
    private javax.swing.JPanel panelWriteReview;
    private javax.swing.JLabel txtFacultyInitial;
    private javax.swing.JLabel txtFacultyName;
    private javax.swing.JLabel txtRating;
    // End of variables declaration//GEN-END:variables
}
