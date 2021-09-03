package view.forum;

import controller.forum.PostController;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.Arrays;
import javax.swing.SwingUtilities;
import model.User;
import view.DialogForm;
import view.SuccessPanel;

public class WritePostPanel extends javax.swing.JPanel {

    volatile Boolean autoTag = true;
    volatile int tagCaretPosition;
    volatile long timer = System.currentTimeMillis();
    Runnable automatedTagWriter = new Runnable() {
        @Override
        public void run() {
                while (System.currentTimeMillis() - timer <= 10000 && autoTag) {
                    String[] lines = txtPostText.getText().split("\n");
                    StringBuilder tags = new StringBuilder();
                    for (String line : lines) {
                        String[] words = line.split("( )+");
                        for (String word : words) if (word.startsWith("#") && word.length() > 1) tags.append(", " + word.replaceAll("[^A-Za-z0-9]\\.*", ""));
                    }
                    if (tags.length() > 0) txtTags.setText(tags.substring(2));
                    else txtTags.setText("");
                }
            txtTags.setCaretPosition(tagCaretPosition);
        }
    };
    Thread tagFindThread;
    
    Frame parentFrame;
    Dialog parentDialog;
    
    public WritePostPanel() {
        initComponents();
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

        scrollPostText = new javax.swing.JScrollPane();
        txtPostText = new javax.swing.JTextArea();
        txtTags = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPost = new javax.swing.JButton();
        btnRemoveTags = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 51));

        scrollPostText.setBackground(new java.awt.Color(0, 39, 39));

        txtPostText.setBackground(new java.awt.Color(0, 39, 39));
        txtPostText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPostText.setForeground(new java.awt.Color(204, 204, 204));
        txtPostText.setCaretPosition(0);
        txtPostText.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtPostText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostTextKeyTyped(evt);
            }
        });
        scrollPostText.setViewportView(txtPostText);

        txtTags.setBackground(new java.awt.Color(0, 39, 39));
        txtTags.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTags.setForeground(new java.awt.Color(204, 204, 204));
        txtTags.setMargin(new java.awt.Insets(0, 5, 0, 5));
        txtTags.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTagsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTagsFocusLost(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Tags");

        btnPost.setBackground(new java.awt.Color(51, 51, 51));
        btnPost.setForeground(new java.awt.Color(204, 204, 204));
        btnPost.setText("Post");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });

        btnRemoveTags.setBackground(new java.awt.Color(51, 51, 51));
        btnRemoveTags.setForeground(new java.awt.Color(204, 204, 204));
        btnRemoveTags.setText("Remove Tags");
        btnRemoveTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTagsActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(51, 51, 51));
        btnReset.setForeground(new java.awt.Color(204, 204, 204));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPostText)
                    .addComponent(txtTags, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveTags, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                        .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPostText, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveTags, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPostTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostTextKeyTyped
        if (tagFindThread == null || tagFindThread.getState() == Thread.State.TERMINATED) (tagFindThread = new Thread(automatedTagWriter)).start();
        timer = System.currentTimeMillis();
    }//GEN-LAST:event_txtPostTextKeyTyped

    @SuppressWarnings("empty-statement")
    private void btnRemoveTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTagsActionPerformed
        autoTag = false;
        while (tagFindThread.getState() != Thread.State.TERMINATED);
        txtTags.setText("");
        autoTag = true;
    }//GEN-LAST:event_btnRemoveTagsActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtPostText.setText("");
        txtTags.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed
        Thread postThread = new Thread() {
            
            @Override
            public void run() {
                timer = 0;
                if (PostController.insertPost(parentFrame, parentDialog, User.getUser().getId(), txtPostText.getText(), txtTags.getText())) {
                    SuccessPanel successPanel = new SuccessPanel("Posted successfully");
                    if (parentDialog == null) {
                        new DialogForm(parentFrame, true, successPanel, "Successfull", true, true, true).setVisible(true);
                        parentFrame.dispose();
                    } else {
                        new DialogForm(parentDialog, true, successPanel, "Successfull", true, true, true).setVisible(true);
                        parentDialog.dispose();
                    }
                }
            }
        };
        
        postThread.start();
    }//GEN-LAST:event_btnPostActionPerformed

    private void txtTagsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTagsFocusGained
        tagCaretPosition = txtTags.getCaretPosition();
        autoTag = false;
    }//GEN-LAST:event_txtTagsFocusGained

    private void txtTagsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTagsFocusLost
        autoTag = true;
    }//GEN-LAST:event_txtTagsFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRemoveTags;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollPostText;
    private javax.swing.JTextArea txtPostText;
    private javax.swing.JTextField txtTags;
    // End of variables declaration//GEN-END:variables
}
