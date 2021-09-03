package view.forum;

import controller.forum.CommentController;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import model.User;
import view.DialogForm;
import view.DialogTitlePanel;
import view.FlatButton;

public class NewCommentPanel extends javax.swing.JPanel {

    Runnable insertCommentProcess = new Runnable() {
        @Override
        public void run() {
            DialogForm parent = (DialogForm) SwingUtilities.getWindowAncestor(me);
            DialogTitlePanel titlePanel = (DialogTitlePanel) parent.panelTitleBar.getComponent(0);
            titlePanel.btnClose.setVisible(false);
            if (CommentController.insertComment(parentFrame, parentDialog, txtComment.getText(), User.getUser().getId(), postId)) {
                commentSubmitted = true;
                parent.dispose();
            }
            titlePanel.btnClose.setVisible(true);
        }
    };
    Thread insertCommentThread;
    
    int postId;
    NewCommentPanel me;
    Frame parentFrame;
    Dialog parentDialog;
    public boolean commentSubmitted;
    
    public NewCommentPanel(int postId) {
        initComponents();
        me = this;
        this.postId = postId;
    }
    
    public NewCommentPanel() {
        this(-1);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollComment = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        btnSubmit = new FlatButton();

        setBackground(new java.awt.Color(24, 24, 24));

        txtComment.setBackground(new java.awt.Color(204, 204, 204));
        txtComment.setColumns(20);
        txtComment.setForeground(new java.awt.Color(0, 0, 0));
        txtComment.setRows(5);
        scrollComment.setViewportView(txtComment);

        btnSubmit.setBackground(new java.awt.Color(20, 120, 150));
        btnSubmit.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSubmit.setText("Submit");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setOpaque(true);
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollComment, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
            .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollComment, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        if (insertCommentThread == null || insertCommentThread.getState() == Thread.State.TERMINATED) (insertCommentThread = new Thread(insertCommentProcess)).start();
    }//GEN-LAST:event_btnSubmitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSubmit;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JTextArea txtComment;
    // End of variables declaration//GEN-END:variables
}
