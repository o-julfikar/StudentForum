package view.forum;

import controller.forum.PostController;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import model.User;
import view.DialogForm;
import view.FlatButton;

public class PostPanel extends javax.swing.JPanel {

    Runnable loadCommentProcess = new Runnable() {
        @Override
        public void run() {
            panelComment.removeAll();
            PostController.getCommentCards(parentFrame, parentDialog, User.getUser().getId(), post.postId).forEach((commentCard) -> {
                panelComment.add(commentCard);
            });
            panelComment.revalidate();
        }
    };
    Thread loadCommentThread;
    
    PostCard post;
    Frame parentFrame;
    Dialog parentDialog;
    
    public PostPanel(PostCard post) {
        initComponents();
        this.post = post;
        panelPost.removeAll();
        panelPost.add(post);
        loadComments();
    }
        
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    public PostPanel() {
        initComponents();
    }
    
    public void loadComments() {
        if (loadCommentThread == null || loadCommentThread.getState() == Thread.State.TERMINATED) (loadCommentThread = new Thread(loadCommentProcess)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPost = new javax.swing.JPanel();
        samplePost = new javax.swing.JPanel();
        panelTag = new javax.swing.JPanel();
        imgPhoto = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JLabel();
        txtSemester = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        scrollPost = new javax.swing.JScrollPane();
        txtPost = new javax.swing.JTextArea();
        scrollComment = new javax.swing.JScrollPane();
        panelComment = new javax.swing.JPanel();
        btnNewComment = new FlatButton();

        setBackground(new java.awt.Color(204, 102, 0));
        setPreferredSize(new java.awt.Dimension(900, 700));

        panelPost.setBackground(new java.awt.Color(255, 255, 204));
        panelPost.setPreferredSize(new java.awt.Dimension(500, 212));
        panelPost.setLayout(new java.awt.GridLayout(0, 1));

        samplePost.setBackground(new java.awt.Color(51, 51, 51));

        panelTag.setBackground(new java.awt.Color(51, 51, 51));
        panelTag.setLayout(new java.awt.GridLayout(1, 0, 10, 5));

        imgPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N
        imgPhoto.setText("jLabel1");

        txtName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setText("Mohammed Julfikar Ali Mahbub");

        txtDepartment.setForeground(new java.awt.Color(204, 204, 204));
        txtDepartment.setText("Department of Computer Science and Engineering");

        txtSemester.setForeground(new java.awt.Color(204, 204, 204));
        txtSemester.setText("Summer 2018");

        txtDate.setForeground(new java.awt.Color(204, 204, 204));
        txtDate.setText("Wednesday, March 11, 2020");

        scrollPost.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        scrollPost.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPost.setWheelScrollingEnabled(false);

        txtPost.setEditable(false);
        txtPost.setBackground(new java.awt.Color(51, 51, 51));
        txtPost.setColumns(20);
        txtPost.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtPost.setForeground(new java.awt.Color(204, 204, 204));
        txtPost.setLineWrap(true);
        txtPost.setRows(5);
        txtPost.setText("Create two threads and divide a task between these thread equally. The thread should work concurrently and complete the assigned task. For example, the task is to calculate the sum of numbers from 1-100. Thread one will calculate sum from 1-50 and thread two will calculate sum from 51-100. And finally the total sum from 1-100 will be printed, where the two threads worked equally.");
        txtPost.setWrapStyleWord(true);
        txtPost.setCaretPosition(0);
        txtPost.setMargin(new java.awt.Insets(5, 5, 5, 5));
        scrollPost.setViewportView(txtPost);

        javax.swing.GroupLayout samplePostLayout = new javax.swing.GroupLayout(samplePost);
        samplePost.setLayout(samplePostLayout);
        samplePostLayout.setHorizontalGroup(
            samplePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, samplePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(samplePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPost)
                    .addComponent(panelTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, samplePostLayout.createSequentialGroup()
                        .addComponent(imgPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(samplePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtDepartment)
                            .addComponent(txtSemester)
                            .addComponent(txtDate))
                        .addGap(0, 223, Short.MAX_VALUE)))
                .addContainerGap())
        );
        samplePostLayout.setVerticalGroup(
            samplePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, samplePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(samplePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(samplePostLayout.createSequentialGroup()
                        .addComponent(txtName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSemester)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate)))
                .addGap(18, 18, 18)
                .addComponent(scrollPost, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelTag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelPost.add(samplePost);

        scrollComment.setBackground(new java.awt.Color(51, 51, 51));
        scrollComment.setBorder(null);
        scrollComment.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        scrollComment.getVerticalScrollBar().setUnitIncrement(16);

        panelComment.setBackground(new java.awt.Color(204, 102, 0));
        panelComment.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        scrollComment.setViewportView(panelComment);

        btnNewComment.setBackground(new java.awt.Color(20, 100, 150));
        btnNewComment.setForeground(new java.awt.Color(255, 255, 255));
        btnNewComment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewComment.setText("Write new comment");
        btnNewComment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewComment.setOpaque(true);
        ((FlatButton) btnNewComment).addListeners();
        btnNewComment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewCommentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPost, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addComponent(scrollComment)
                    .addComponent(btnNewComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelPost, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollComment, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewComment, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewCommentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewCommentMouseClicked
        NewCommentPanel commentPanel = new NewCommentPanel(post.postId);
        if (parentDialog == null) new DialogForm(parentFrame, true, commentPanel, "New Comment", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, commentPanel, "New Comment", true, true, true).setVisible(true);
        if (commentPanel.commentSubmitted) loadComments();
    }//GEN-LAST:event_btnNewCommentMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnNewComment;
    private javax.swing.JLabel imgPhoto;
    private javax.swing.JPanel panelComment;
    private javax.swing.JPanel panelPost;
    private javax.swing.JPanel panelTag;
    private javax.swing.JPanel samplePost;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JScrollPane scrollPost;
    public javax.swing.JLabel txtDate;
    public javax.swing.JLabel txtDepartment;
    public javax.swing.JLabel txtName;
    private javax.swing.JTextArea txtPost;
    public javax.swing.JLabel txtSemester;
    // End of variables declaration//GEN-END:variables
}
