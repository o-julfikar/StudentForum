package view;

import view.swap.SwapPanel;
import view.forum.ForumPanel;
import view.feedback.FeedbackPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class Home extends javax.swing.JFrame {
    
    private static final int FORUM = 0, FEEDBACK = 1, SWAP = 2;
    public static Frame mainFrame;
    
    int mouseX, mouseY, selectedTab = FORUM;
    CardLayout contentLayout;
    
    public Home() {
        initComponents();
        if (mainFrame == null) mainFrame = this;        
        contentLayout = (CardLayout) containerPanel.getLayout();
        
        LoginPanel loginPanel = new LoginPanel();
        DialogForm loginForm = new DialogForm(this, true, loginPanel, "Login");
        loginForm.panelMain.setBackground(loginPanel.getBackground());
        loginForm.setSize(loginPanel.getPreferredSize().width + 24, loginPanel.getPreferredSize().height + 18 + 37);
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
        if (!User.isSignedIn()) System.exit(0);
        customInit();
    }
    
    private void customInit() {
        titlePanel.add(new TitlePanel(this, "BRACU Student Portal | by Zulfikar"), "titlePanel");
        containerPanel.add(new ForumPanel(), "forumPanel");
        containerPanel.add(new FeedbackPanel(), "feedbackPanel");
        containerPanel.add(new SwapPanel(), "swapPanel");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        forumMenuPanel = new javax.swing.JPanel();
        btnForum = new javax.swing.JLabel();
        feedbackMenuPanel = new javax.swing.JPanel();
        btnFeedback = new javax.swing.JLabel();
        swapMenuPanel = new javax.swing.JPanel();
        btnSwap = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(908, 623));
        setName("Home"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(0, 680));

        panelMain.setBackground(new java.awt.Color(102, 0, 102));

        titlePanel.setBackground(new java.awt.Color(51, 0, 51));
        titlePanel.setLayout(new java.awt.CardLayout());

        menuPanel.setBackground(new java.awt.Color(40, 40, 40));

        forumMenuPanel.setBackground(new java.awt.Color(102, 0, 51));

        btnForum.setBackground(new java.awt.Color(153, 153, 153));
        btnForum.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        btnForum.setForeground(new java.awt.Color(153, 0, 0));
        btnForum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnForum.setText("FORUM");
        btnForum.setOpaque(true);
        btnForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnForumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnForumMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnForumMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnForumMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout forumMenuPanelLayout = new javax.swing.GroupLayout(forumMenuPanel);
        forumMenuPanel.setLayout(forumMenuPanelLayout);
        forumMenuPanelLayout.setHorizontalGroup(
            forumMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnForum, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        forumMenuPanelLayout.setVerticalGroup(
            forumMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnForum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        feedbackMenuPanel.setBackground(new java.awt.Color(0, 102, 102));

        btnFeedback.setBackground(new java.awt.Color(204, 204, 204));
        btnFeedback.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        btnFeedback.setForeground(new java.awt.Color(51, 51, 51));
        btnFeedback.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFeedback.setText("FEEDBACK");
        btnFeedback.setOpaque(true);
        btnFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFeedbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFeedbackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFeedbackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFeedbackMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout feedbackMenuPanelLayout = new javax.swing.GroupLayout(feedbackMenuPanel);
        feedbackMenuPanel.setLayout(feedbackMenuPanelLayout);
        feedbackMenuPanelLayout.setHorizontalGroup(
            feedbackMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedbackMenuPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );
        feedbackMenuPanelLayout.setVerticalGroup(
            feedbackMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFeedback, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        swapMenuPanel.setBackground(new java.awt.Color(153, 102, 0));

        btnSwap.setBackground(new java.awt.Color(204, 204, 204));
        btnSwap.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        btnSwap.setForeground(new java.awt.Color(0, 102, 153));
        btnSwap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSwap.setText("SWAP");
        btnSwap.setOpaque(true);
        btnSwap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSwapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSwapMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSwapMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSwapMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout swapMenuPanelLayout = new javax.swing.GroupLayout(swapMenuPanel);
        swapMenuPanel.setLayout(swapMenuPanelLayout);
        swapMenuPanelLayout.setHorizontalGroup(
            swapMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSwap, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        swapMenuPanelLayout.setVerticalGroup(
            swapMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSwap, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(forumMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(feedbackMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(swapMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(forumMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(feedbackMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(swapMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        containerPanel.setBackground(new java.awt.Color(0, 0, 0));
        containerPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        containerPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // </editor-fold>
       
    private void btnForumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseEntered
        btnForum.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btnForumMouseEntered

    private void btnForumMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMousePressed
        btnForum.setBackground(new Color(135,135,135)); 
        contentLayout.show(containerPanel, "forumPanel");
        selectedTab = FORUM;
        btnFeedback.setBackground(new Color(204,204,204));
        btnSwap.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btnForumMousePressed

    private void btnForumMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseReleased
        btnForum.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btnForumMouseReleased

    private void btnForumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseExited
        btnForum.setBackground(new Color(204,204,204));
        if (selectedTab == FORUM) {
            btnForum.setBackground(new Color(135,135,135));
            btnFeedback.setBackground(new Color(204,204,204));
            btnSwap.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_btnForumMouseExited

    private void btnFeedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackMouseEntered
        btnFeedback.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btnFeedbackMouseEntered

    private void btnFeedbackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackMousePressed
        btnFeedback.setBackground(new Color(135,135,135));
        contentLayout.show(containerPanel, "feedbackPanel");
        selectedTab = FEEDBACK;
        btnForum.setBackground(new Color(204,204,204));
        btnSwap.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btnFeedbackMousePressed

    private void btnFeedbackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackMouseReleased
        btnFeedback.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btnFeedbackMouseReleased

    private void btnFeedbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackMouseExited
        btnFeedback.setBackground(new Color(204,204,204));
        if (selectedTab == FEEDBACK) {
            btnFeedback.setBackground(new Color(135,135,135));
            btnForum.setBackground(new Color(204,204,204));
            btnSwap.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_btnFeedbackMouseExited

    private void btnSwapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSwapMouseEntered
        btnSwap.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btnSwapMouseEntered

    private void btnSwapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSwapMousePressed
        btnSwap.setBackground(new Color(135,135,135));
        contentLayout.show(containerPanel, "swapPanel");
        selectedTab = SWAP;
        btnFeedback.setBackground(new Color(204,204,204));
        btnForum.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btnSwapMousePressed

    private void btnSwapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSwapMouseReleased
        btnSwap.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btnSwapMouseReleased

    private void btnSwapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSwapMouseExited
        btnSwap.setBackground(new Color(204,204,204));
        if (selectedTab == SWAP) {
            btnSwap.setBackground(new Color(135,135,135));
            btnFeedback.setBackground(new Color(204,204,204));
            btnForum.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_btnSwapMouseExited

    // <editor-fold defaultstate="collapsed" desc="Main method">
    public static void main(String args[]) {
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            //</editor-fold>

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables declarations">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFeedback;
    private javax.swing.JLabel btnForum;
    private javax.swing.JLabel btnSwap;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel feedbackMenuPanel;
    private javax.swing.JPanel forumMenuPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel swapMenuPanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
