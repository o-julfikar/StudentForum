package view.forum;

import controller.forum.CommentController;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import model.User;
import view.FlatButton;

public class CommentPanel extends javax.swing.JPanel {

    Runnable loadReplyProcess = new Runnable() {
        @Override
        public void run() {
            panelReply.removeAll();
            CommentController.
                    getReplyCards(parentFrame, parentDialog, User.getUser().getId(), commentCard.postId, commentCard.commentId).
                    forEach((reply) -> {
                        panelReply.add(reply);
                    });
            panelReply.revalidate();
        }
    };
    Thread loadReplyThread;
    
    CommentCard commentCard;
    Frame parentFrame;
    Dialog parentDialog;
    
    public CommentPanel(CommentCard commentCard) {
        initComponents();
        this.commentCard = commentCard;
        panelComment.removeAll();
        panelComment.add(commentCard);
        loadReplies();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    public CommentPanel() {
        initComponents();
    }
    
    public final void loadReplies() {
        if (loadReplyThread == null || loadReplyThread.getState() == Thread.State.TERMINATED) (loadReplyThread = new Thread(loadReplyProcess)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComment = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        imgUser = new javax.swing.JLabel();
        btnReply = new FlatButton();
        btnOpen = new FlatButton();
        jPanel4 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        txtCommentDate = new javax.swing.JLabel();
        btnDelete = new FlatButton();
        scrollComment = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        scrollReply = new javax.swing.JScrollPane();
        panelReply = new javax.swing.JPanel();

        setBackground(new java.awt.Color(141, 70, 0));
        setPreferredSize(new java.awt.Dimension(600, 448));

        panelComment.setBackground(new java.awt.Color(255, 102, 51));
        panelComment.setPreferredSize(new java.awt.Dimension(600, 210));
        panelComment.setLayout(new java.awt.GridLayout(0, 1));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jPanel3.setBackground(new java.awt.Color(25, 25, 25));

        imgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        btnReply.setBackground(new java.awt.Color(20, 100, 150));
        btnReply.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnReply.setForeground(new java.awt.Color(255, 255, 255));
        btnReply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReply.setText("Reply");
        btnReply.setOpaque(true);

        btnOpen.setBackground(new java.awt.Color(120, 120, 20));
        btnOpen.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnOpen.setForeground(new java.awt.Color(255, 255, 255));
        btnOpen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOpen.setText("Open");
        btnOpen.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReply, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReply, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(25, 25, 25));

        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("Mohammed Julfikar Ali Mahbub");

        txtCommentDate.setForeground(new java.awt.Color(204, 204, 204));
        txtCommentDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCommentDate.setText("Friday, June 16, 1990");

        btnDelete.setBackground(new java.awt.Color(150, 20, 20));
        btnDelete.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDelete.setText("Delete");
        btnDelete.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(txtCommentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCommentDate)
                .addContainerGap())
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scrollComment.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollComment.setWheelScrollingEnabled(false);

        txtComment.setBackground(new java.awt.Color(76, 76, 76));
        txtComment.setColumns(20);
        txtComment.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtComment.setForeground(new java.awt.Color(204, 204, 204));
        txtComment.setLineWrap(true);
        txtComment.setRows(5);
        txtComment.setText("In that GSoC company list I can guarantee 90% company wanted python and python related skills, machine learning");
        txtComment.setToolTipText("");
        txtComment.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 3));
        txtComment.setMargin(new java.awt.Insets(2, 2, 2, 2));
        scrollComment.setViewportView(txtComment);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollComment)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollComment))
        );

        panelComment.add(jPanel2);

        scrollReply.getVerticalScrollBar().setUnitIncrement(16);
        scrollReply.setBorder(null);
        scrollReply.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));

        panelReply.setBackground(new java.awt.Color(141, 70, 0));
        panelReply.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        scrollReply.setViewportView(panelReply);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollReply)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollReply, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnOpen;
    private javax.swing.JLabel btnReply;
    private javax.swing.JLabel imgUser;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelComment;
    private javax.swing.JPanel panelReply;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JScrollPane scrollReply;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JLabel txtCommentDate;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
