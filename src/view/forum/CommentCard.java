package view.forum;

import controller.forum.CommentController;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.SwingUtilities;
import model.ImageResource;
import model.User;
import view.DialogForm;
import view.FlatButton;

public class CommentCard extends javax.swing.JPanel {

    Runnable deleteCommentProcess = new Runnable() {
        @Override
        public void run() {
            if (CommentController.deleteComment(parentFrame, parentDialog, commentId)) {
                Container parent = me.getParent();
                parent.remove(me);
                parent.repaint();
                parent.revalidate();
            }
        }
    };
    Thread deleteCommentThread;
    
    boolean controlPressed;
    int postId, commentId, writerId;
    Date commentDate;
    CommentCard me;
    Frame parentFrame;
    Dialog parentDialog;
    
    public CommentCard(int postId, int commentId, Date commentDate, String commentText, int writerId, String writerName, String writerPhoto) {
        initComponents();
        me = this;
        this.postId = postId;
        this.commentId = commentId;
        this.writerId = writerId;
        this.commentDate = commentDate;
        txtName.setText(writerName);
        txtCommentDate.setText(String.format("%tA, %<tB %<td, %<tY", commentDate));
        txtComment.setText(commentText);
        imgUser.setIcon(User.getProfilePhoto(writerPhoto));
        startKeyListener();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    public CommentCard(int postId, int commentId, Date commentDate, String commentText, int writerId, String writerName, Icon writerPhoto) {
        initComponents();
        me = this;
        this.postId = postId;
        this.commentId = commentId;
        this.writerId = writerId;
        this.commentDate = commentDate;
        txtName.setText(writerName);
        txtCommentDate.setText(String.format("%tA, %<tB %<td, %<tY", commentDate));
        txtComment.setText(commentText);
        imgUser.setIcon(writerPhoto);
        startKeyListener();
    }
    
    public CommentCard() {
        this(-1, -1, new Date(), "No comment", -1, "No writer", ImageResource.userPhoto);
    }
    
    private void startKeyListener() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                synchronized(PostCard.class) {
                    switch(e.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                                controlPressed = true;
                                scrollComment.setWheelScrollingEnabled(true);
                            }
                            break;
                        case KeyEvent.KEY_RELEASED:
                            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                                controlPressed = false;
                                scrollComment.setWheelScrollingEnabled(false);
                            }
                            break;
                    }
                    return false;
                }
            }
        });
    }
    
    private CommentCard copy() {
        CommentCard copy = new CommentCard(postId, commentId, commentDate, txtComment.getText(), writerId, txtName.getText(), imgUser.getIcon());
        copy.btnDelete.setVisible(false);
        copy.btnOpen.setVisible(false);
        return copy;
    }

    public boolean isControlPressed() {
        synchronized(PostCard.class) {
            return controlPressed;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imgUser = new javax.swing.JLabel();
        btnReply = new FlatButton();
        btnOpen = new FlatButton();
        jPanel2 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        txtCommentDate = new javax.swing.JLabel();
        btnDelete = new FlatButton();
        scrollComment = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(102, 255, 102));

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));

        imgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        btnReply.setBackground(new java.awt.Color(20, 100, 150));
        btnReply.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnReply.setForeground(new java.awt.Color(255, 255, 255));
        btnReply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReply.setText("Reply");
        btnReply.setOpaque(true);
        btnReply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReplyMouseClicked(evt);
            }
        });

        btnOpen.setBackground(new java.awt.Color(120, 120, 20));
        btnOpen.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnOpen.setForeground(new java.awt.Color(255, 255, 255));
        btnOpen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOpen.setText("Open");
        btnOpen.setOpaque(true);
        btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReply, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReply, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(25, 25, 25));

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
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(txtCommentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCommentDate)
                .addContainerGap())
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scrollComment.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollComment.setWheelScrollingEnabled(false);
        scrollComment.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                scrollCommentMouseWheelMoved(evt);
            }
        });

        txtComment.setEditable(false);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollComment)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollComment))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void scrollCommentMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_scrollCommentMouseWheelMoved
        if (!isControlPressed()) getParent().dispatchEvent(evt);
    }//GEN-LAST:event_scrollCommentMouseWheelMoved

    private void btnOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseClicked
        if (parentDialog == null) new DialogForm(parentFrame, true, new CommentPanel(copy()), txtName.getText() + "'s Comment", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, new CommentPanel(copy()), txtName.getText() + "'s Comment", true, true, true).setVisible(true);
    }//GEN-LAST:event_btnOpenMouseClicked

    private void btnReplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReplyMouseClicked
        NewReplyPanel replyPanel = new NewReplyPanel(postId, commentId);
        if (parentDialog == null) new DialogForm(parentFrame, true, replyPanel, "Write a reply", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, replyPanel, "Write a reply", true, true, true).setVisible(true);
        if (replyPanel.replySubmitted && getParent().getParent() instanceof CommentPanel)
            ((CommentPanel) getParent().getParent()).loadReplies();
    }//GEN-LAST:event_btnReplyMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        if (evt.getClickCount() == 2 && (deleteCommentThread == null || deleteCommentThread.getState() == Thread.State.TERMINATED)) (deleteCommentThread = new Thread(deleteCommentProcess)).start();
    }//GEN-LAST:event_btnDeleteMouseClicked

    // <editor-fold defaultstate="collapsed" desc="Variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnOpen;
    private javax.swing.JLabel btnReply;
    private javax.swing.JLabel imgUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JLabel txtCommentDate;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
