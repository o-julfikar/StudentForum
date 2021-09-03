package view.feedback;

import controller.feedback.FeedbackController;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ReadFeedbackPanel extends javax.swing.JPanel {

    Runnable loadReviewsProcess = new Runnable() {
        @Override
        public void run() {
            panelContent.removeAll();
            FeedbackController.getReviewCards(parentFrame, parentDialog, txtFacultyInitial.getText()).forEach((reviewCard) -> {
                panelContent.add(reviewCard);
            });
            panelContent.revalidate();
            panelContent.repaint();
        }
    };
    Thread loadReviewsThread;
    Frame parentFrame;
    Dialog parentDialog;
    
    public ReadFeedbackPanel(String facultyName, String facultyInitial, Icon imgFaculty, Icon[] stars) {
        initComponents();
        JLabel[] myStars = {imgStar1, imgStar2, imgStar3, imgStar4, imgStar5};
        
        this.txtFacultyName.setText(facultyName);
        this.txtFacultyInitial.setText(facultyInitial);
        this.imgFaculty.setIcon(imgFaculty);
        for (int i = 0; i < myStars.length; i++) myStars[i].setIcon(stars[i]);
        
        loadReviews();
    }
    
    public ReadFeedbackPanel() {
        initComponents();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    public final void loadReviews() {
        (loadReviewsThread = new Thread(loadReviewsProcess)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneInfo = new javax.swing.JPanel();
        imgFaculty = new javax.swing.JLabel();
        txtFacultyName = new javax.swing.JLabel();
        txtFacultyInitial = new javax.swing.JLabel();
        panelStar = new javax.swing.JPanel();
        imgStar1 = new javax.swing.JLabel();
        imgStar2 = new javax.swing.JLabel();
        imgStar3 = new javax.swing.JLabel();
        imgStar4 = new javax.swing.JLabel();
        imgStar5 = new javax.swing.JLabel();
        scrollReviewContent = new javax.swing.JScrollPane();
        panelContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 0));

        paneInfo.setBackground(new java.awt.Color(102, 51, 0));

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

        panelStar.setBackground(new java.awt.Color(102, 51, 0));
        panelStar.setPreferredSize(new java.awt.Dimension(274, 50));

        imgStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

        imgStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/star_full - 50px.png"))); // NOI18N

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

        javax.swing.GroupLayout paneInfoLayout = new javax.swing.GroupLayout(paneInfo);
        paneInfo.setLayout(paneInfoLayout);
        paneInfoLayout.setHorizontalGroup(
            paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgFaculty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInfoLayout.createSequentialGroup()
                        .addComponent(txtFacultyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(316, 316, 316))
                    .addGroup(paneInfoLayout.createSequentialGroup()
                        .addComponent(txtFacultyInitial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(paneInfoLayout.createSequentialGroup()
                        .addComponent(panelStar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        paneInfoLayout.setVerticalGroup(
            paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneInfoLayout.createSequentialGroup()
                        .addComponent(txtFacultyName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFacultyInitial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelStar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        scrollReviewContent.setBackground(new java.awt.Color(153, 153, 0));
        scrollReviewContent.setBorder(null);
        scrollReviewContent.getVerticalScrollBar().setUnitIncrement(16);

        panelContent.setBackground(new java.awt.Color(153, 102, 0));
        panelContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        panelContent.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        scrollReviewContent.setViewportView(panelContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollReviewContent)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollReviewContent, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgFaculty;
    private javax.swing.JLabel imgStar1;
    private javax.swing.JLabel imgStar2;
    private javax.swing.JLabel imgStar3;
    private javax.swing.JLabel imgStar4;
    private javax.swing.JLabel imgStar5;
    private javax.swing.JPanel paneInfo;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelStar;
    private javax.swing.JScrollPane scrollReviewContent;
    private javax.swing.JLabel txtFacultyInitial;
    private javax.swing.JLabel txtFacultyName;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
