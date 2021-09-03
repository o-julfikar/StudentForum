package view;

import java.awt.CardLayout;
import model.User;

public class UserProfilePanel extends javax.swing.JPanel {

    public UserProfilePanel() {
        initComponents();
        addPanels();
    }
    
    public void addPanels() {
        AccountPanel accountPanel = new AccountPanel();
        panelContent.add(accountPanel, "accountPanel");
        panelContent.add(new SecurityPanel(), "securityPanel");
        panelContent.add(new AdminPanel(), "adminPanel");
        if (User.getUser().getRole() > User.ADMIN) btnAdminPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSidebar = new javax.swing.JPanel();
        btnAccount = new FlatButton();
        btnSecurity = new FlatButton();
        btnAdminPanel = new FlatButton();
        scrollContent = new javax.swing.JScrollPane();
        panelContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(34, 34, 34));

        panelSidebar.setBackground(new java.awt.Color(51, 51, 51));

        btnAccount.setBackground(new java.awt.Color(0, 102, 51));
        btnAccount.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAccount.setText("Account");
        btnAccount.setOpaque(true);
        ((FlatButton) btnAccount).addListeners();
        btnAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAccountMouseClicked(evt);
            }
        });

        btnSecurity.setBackground(new java.awt.Color(0, 102, 51));
        btnSecurity.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnSecurity.setForeground(new java.awt.Color(255, 255, 255));
        btnSecurity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSecurity.setText("Security");
        btnSecurity.setOpaque(true);
        ((FlatButton) btnSecurity).addListeners();
        btnSecurity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSecurityMouseClicked(evt);
            }
        });

        btnAdminPanel.setBackground(new java.awt.Color(0, 102, 51));
        btnAdminPanel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnAdminPanel.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdminPanel.setText("Admin Panel");
        btnAdminPanel.setOpaque(true);
        ((FlatButton) btnAdminPanel).addListeners();
        btnAdminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(btnSecurity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 277, Short.MAX_VALUE))
        );

        scrollContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        panelContent.setLayout(new java.awt.CardLayout());
        scrollContent.setViewportView(panelContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(scrollContent, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollContent)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccountMouseClicked
        ((CardLayout) panelContent.getLayout()).show(panelContent, "accountPanel");
    }//GEN-LAST:event_btnAccountMouseClicked

    private void btnSecurityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSecurityMouseClicked
        ((CardLayout) panelContent.getLayout()).show(panelContent, "securityPanel");
    }//GEN-LAST:event_btnSecurityMouseClicked

    private void btnAdminPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminPanelMouseClicked
        ((CardLayout) panelContent.getLayout()).show(panelContent, "adminPanel");
    }//GEN-LAST:event_btnAdminPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAccount;
    private javax.swing.JLabel btnAdminPanel;
    private javax.swing.JLabel btnSecurity;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JScrollPane scrollContent;
    // End of variables declaration//GEN-END:variables
}
