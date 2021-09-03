package view.forum;

import controller.forum.PostController;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;
import model.User;
import view.DialogForm;
import view.FlatButton;
import view.Home;
import view.SuccessPanel;
import view.UserProfilePanel;

public class ForumPanel extends javax.swing.JPanel {
    
    Frame parentFrame;
    Dialog parentDialog;
    int page = 0;
    
    Runnable loadPostProcess = new Runnable() {
        @Override
        public void run() {
            
        }
    };
    
    Thread loadPostThread;
    
    public ForumPanel() {
        initComponents();
        loadPosts();
        loadUserInfo();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    private void loadUserInfo() {
        if (User.isSignedIn()) {
            imgUser.setIcon(User.getUser().getPhoto());
            String userName = User.getUser().getName();
            txtName.setText(userName.length() > 28? userName.substring(0, 25) + "..." : userName);
            txtDepartment.setText(User.getUser().getDepartment().getAcronym());
            txtSemeter.setText(User.getUser().getSemester().toString());
        }
    }
    
    private void loadPosts() {
        if (loadPostThread == null || loadPostThread.getState() == Thread.State.TERMINATED) {
            (loadPostThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    panelPost.removeAll();
                    SuccessPanel loadingPanel = new SuccessPanel("Loading posts...");
                    panelPost.add(loadingPanel);
                    panelPost.revalidate();
                    LinkedList<PostCard> postCards = PostController.getPostCards(parentFrame, parentDialog);
                    panelPost.removeAll();
                    postCards.forEach((post) -> {
                        panelPost.add(post);
                    });
                    panelPost.revalidate();
                }
            })).start();
        }
    }
    
    public void loadPosts(String tag) {
        if (loadPostThread == null || loadPostThread.getState() == Thread.State.TERMINATED) {
            (loadPostThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    panelPost.removeAll();
                    SuccessPanel loadingPanel = new SuccessPanel("Loading posts...");
                    panelPost.add(loadingPanel);
                    panelPost.revalidate();
                    LinkedList<PostCard> postCards = PostController.getPostCards(parentFrame,
                            parentDialog,
                            "",
                            "",
                            "",
                            tag);
                    panelPost.removeAll();
                    postCards.forEach((post) -> {
                                panelPost.add(post);
                            });
                    txtTag.setText(tag);
                    panelPost.revalidate();
                    scrollPanelPost.getVerticalScrollBar().setValue(0);
                }
            })).start();
        }
    }
    
    public void loadPosts(int page) {
        if (loadPostThread == null || loadPostThread.getState() == Thread.State.TERMINATED) {
            (loadPostThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    panelPost.removeAll();
                    SuccessPanel loadingPanel = new SuccessPanel("Loading posts...");
                    panelPost.add(loadingPanel);
                    panelPost.revalidate();
                    LinkedList<PostCard> postCards = null;
                    boolean isFilterOn = txtID.getText().length() + txtNameFilter.getText().length() + txtDate.getText().length() + txtTag.getText().length() > 0;
                    if (isFilterOn) {
                        postCards = PostController.getPostCards(parentFrame,
                                parentDialog,
                                txtID.getText(),
                                txtNameFilter.getText(),
                                txtDate.getText(),
                                txtTag.getText(), 
                                page);
                    } else {
                        postCards = PostController.getPostCards(parentFrame,
                                parentDialog,
                                page);
                    }
                    panelPost.removeAll();
                    postCards.forEach((post) -> {
                                    panelPost.add(post);
                    });
                    panelPost.revalidate();
                    scrollPanelPost.getVerticalScrollBar().setValue(0);
                }
            })).start();
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        sideBarPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnNewPost = new javax.swing.JButton();
        separatorLogout = new javax.swing.JSeparator();
        separatorFilter = new javax.swing.JSeparator();
        panelFilterButtons = new javax.swing.JPanel();
        btnFilter = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtNameFilter = new javax.swing.JTextField();
        lblTag = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnProfile = new javax.swing.JButton();
        txtTag = new javax.swing.JTextField();
        imgUser = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JLabel();
        txtSemeter = new javax.swing.JLabel();
        scrollPanelPost = new javax.swing.JScrollPane();
        panelPost = new javax.swing.JPanel();
        btnRecentPost = new FlatButton();
        btnPastPost = new FlatButton();

        setBackground(new java.awt.Color(153, 153, 153));

        panelMain.setBackground(new java.awt.Color(153, 153, 153));

        sideBarPanel.setBackground(new java.awt.Color(51, 51, 51));
        sideBarPanel.setPreferredSize(new java.awt.Dimension(207, 481));

        btnLogout.setBackground(new java.awt.Color(255, 51, 51));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnNewPost.setBackground(new java.awt.Color(51, 102, 255));
        btnNewPost.setForeground(new java.awt.Color(255, 255, 255));
        btnNewPost.setText("New Post");
        btnNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPostActionPerformed(evt);
            }
        });

        separatorLogout.setForeground(new java.awt.Color(255, 255, 255));

        separatorFilter.setForeground(new java.awt.Color(255, 255, 255));

        panelFilterButtons.setBackground(new java.awt.Color(51, 51, 51));
        panelFilterButtons.setLayout(new java.awt.GridLayout(1, 2));

        btnFilter.setBackground(new java.awt.Color(0, 102, 204));
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        panelFilterButtons.add(btnFilter);

        btnClear.setBackground(new java.awt.Color(204, 102, 0));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        panelFilterButtons.add(btnClear);

        lblID.setForeground(new java.awt.Color(204, 204, 204));
        lblID.setLabelFor(txtID);
        lblID.setText("BRACU ID");

        txtID.setBackground(new java.awt.Color(73, 73, 73));
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblName.setForeground(new java.awt.Color(204, 204, 204));
        lblName.setText("Name");

        txtNameFilter.setBackground(new java.awt.Color(73, 73, 73));
        txtNameFilter.setForeground(new java.awt.Color(255, 255, 255));
        txtNameFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblTag.setForeground(new java.awt.Color(204, 204, 204));
        lblTag.setText("Tag");

        lblDate.setForeground(new java.awt.Color(204, 204, 204));
        lblDate.setText("Date");

        txtDate.setBackground(new java.awt.Color(73, 73, 73));
        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnProfile.setBackground(new java.awt.Color(0, 102, 102));
        btnProfile.setForeground(new java.awt.Color(204, 204, 204));
        btnProfile.setText("Open Profile");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        txtTag.setBackground(new java.awt.Color(73, 73, 73));
        txtTag.setForeground(new java.awt.Color(255, 255, 255));
        txtTag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        imgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        txtName.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("Name");

        txtDepartment.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtDepartment.setForeground(new java.awt.Color(255, 255, 255));
        txtDepartment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDepartment.setText("Department");

        txtSemeter.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtSemeter.setForeground(new java.awt.Color(255, 255, 255));
        txtSemeter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSemeter.setText("Semester");

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separatorLogout)
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorFilter)
                            .addComponent(txtID)
                            .addComponent(txtNameFilter)
                            .addComponent(txtDate)
                            .addComponent(txtTag)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSemeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addComponent(lblTag)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblID)
                            .addComponent(lblName)
                            .addComponent(lblDate)
                            .addComponent(panelFilterButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewPost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(separatorFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(panelFilterButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(separatorLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSemeter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        scrollPanelPost.setBackground(new java.awt.Color(153, 153, 153));
        scrollPanelPost.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPanelPost.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPanelPost.getVerticalScrollBar().setUnitIncrement(16);

        panelPost.setBackground(new java.awt.Color(153, 153, 153));
        panelPost.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        panelPost.setLayout(new java.awt.GridLayout(0, 1, 5, 15));
        scrollPanelPost.setViewportView(panelPost);

        btnRecentPost.setBackground(new java.awt.Color(20, 102, 153));
        btnRecentPost.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnRecentPost.setForeground(new java.awt.Color(204, 204, 204));
        btnRecentPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRecentPost.setText("View earlier post");
        btnRecentPost.setOpaque(true);
        btnRecentPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecentPostMouseClicked(evt);
            }
        });

        btnPastPost.setBackground(new java.awt.Color(102, 102, 102));
        btnPastPost.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnPastPost.setForeground(new java.awt.Color(204, 204, 204));
        btnPastPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPastPost.setText("View older post");
        btnPastPost.setOpaque(true);
        btnPastPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPastPostMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanelPost)
                    .addComponent(btnRecentPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPastPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRecentPost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanelPost)
                .addGap(12, 12, 12)
                .addComponent(btnPastPost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        User.logout();
        new Home().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnNewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPostActionPerformed
        WritePostPanel postPanel = new WritePostPanel();
        if (parentDialog == null) new DialogForm(parentFrame, true, postPanel, "New Post", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, postPanel, "New Post", true, true, true).setVisible(true);
        loadPosts();
    }//GEN-LAST:event_btnNewPostActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        UserProfilePanel userProfilePanel = new UserProfilePanel();
        if (parentDialog == null) new DialogForm(parentFrame, true, userProfilePanel, txtName.getText() + "'s Profile", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, userProfilePanel, txtName.getText() + "'s Profile", true, true, true).setVisible(true);
        loadUserInfo();
        loadPosts();
        User.getUser().updateComplete();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (loadPostThread == null || loadPostThread.getState() == Thread.State.TERMINATED) {
            (loadPostThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    panelPost.removeAll();
                    SuccessPanel loadingPanel = new SuccessPanel("Loading posts...");
                    panelPost.add(loadingPanel);
                    panelPost.revalidate();
                    LinkedList<PostCard> postCards = PostController.getPostCards(parentFrame, parentDialog,
                            txtID.getText(), txtNameFilter.getText(), txtDate.getText(), txtTag.getText());
                    panelPost.removeAll();
                    postCards.forEach((post) -> { panelPost.add(post); });
                    panelPost.revalidate();
                }
            })).start();
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtID.setText("");
        txtNameFilter.setText("");
        txtDate.setText("");
        txtTag.setText("");
        loadPosts();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRecentPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecentPostMouseClicked
        if (page == 0) {
            loadPosts(page);
//            SuccessPanel reachedOrigin = new SuccessPanel("No new posts are available at the moment. You are already viewing the most recent posts. Keep posting!");
//            if (parentDialog == null) new DialogForm(parentFrame, true, reachedOrigin, "Already viewing most recent posts", true, true, true).setVisible(true);
//            else new DialogForm(parentDialog, true, reachedOrigin, "Already viewing most recent posts", true, true, true).setVisible(true);
        } else {
            loadPosts(page = page - 1);
        }
        
    }//GEN-LAST:event_btnRecentPostMouseClicked

    private void btnPastPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPastPostMouseClicked
        PostCard lastPostCard = (PostCard) panelPost.getComponent(panelPost.getComponentCount() - 1);
        if (lastPostCard.postId > 0) {
            loadPosts(page = (page + 1));
        } else {
            SuccessPanel reachedOrigin = new SuccessPanel("No more posts available. You have reached to the first post.");
            if (parentDialog == null) new DialogForm(parentFrame, true, reachedOrigin, "No more posts to load", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, reachedOrigin, "No more posts to load", true, true, true).setVisible(true);
        }
    }//GEN-LAST:event_btnPastPostMouseClicked

    // <editor-fold defaultstate="collapsed" desc="Variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewPost;
    private javax.swing.JLabel btnPastPost;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel btnRecentPost;
    private javax.swing.JLabel imgUser;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTag;
    private javax.swing.JPanel panelFilterButtons;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelPost;
    private javax.swing.JScrollPane scrollPanelPost;
    private javax.swing.JSeparator separatorFilter;
    private javax.swing.JSeparator separatorLogout;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JTextField txtDate;
    private javax.swing.JLabel txtDepartment;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtName;
    private javax.swing.JTextField txtNameFilter;
    private javax.swing.JLabel txtSemeter;
    private javax.swing.JTextField txtTag;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
