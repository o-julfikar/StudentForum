package view.swap;

import java.awt.CardLayout;
import java.awt.Color;

public class SwapPanel extends javax.swing.JPanel {

    CardLayout cardLayout = new CardLayout();
    
    public SwapPanel() {
        initComponents();
        panelContainer.setLayout(cardLayout);
        panelContainer.add(new SectionSwapPanel(), "panelSectionSwap");
        panelContainer.add(new StudySwapPanel(), "panelStudySwap");
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        panelSectionSwap = new javax.swing.JPanel();
        btnSectionSwap = new javax.swing.JLabel();
        panelStudySwap = new javax.swing.JPanel();
        btnStudySwap = new javax.swing.JLabel();
        scrollContainer = new javax.swing.JScrollPane();
        panelContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));

        panelMenu.setBackground(new java.awt.Color(153, 153, 153));

        panelSectionSwap.setBackground(new java.awt.Color(153, 153, 153));

        btnSectionSwap.setBackground(new java.awt.Color(50, 100, 0));
        btnSectionSwap.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        btnSectionSwap.setForeground(new java.awt.Color(204, 204, 204));
        btnSectionSwap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSectionSwap.setText("Section Swap");
        btnSectionSwap.setOpaque(true);
        btnSectionSwap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSectionSwapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSectionSwapMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSectionSwapMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSectionSwapMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelSectionSwapLayout = new javax.swing.GroupLayout(panelSectionSwap);
        panelSectionSwap.setLayout(panelSectionSwapLayout);
        panelSectionSwapLayout.setHorizontalGroup(
            panelSectionSwapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSectionSwap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSectionSwapLayout.setVerticalGroup(
            panelSectionSwapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSectionSwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelStudySwap.setBackground(new java.awt.Color(153, 153, 153));

        btnStudySwap.setBackground(new java.awt.Color(0, 100, 150));
        btnStudySwap.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        btnStudySwap.setForeground(new java.awt.Color(204, 204, 204));
        btnStudySwap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStudySwap.setText("Study Swap");
        btnStudySwap.setOpaque(true);
        btnStudySwap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStudySwapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStudySwapMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnStudySwapMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnStudySwapMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelStudySwapLayout = new javax.swing.GroupLayout(panelStudySwap);
        panelStudySwap.setLayout(panelStudySwapLayout);
        panelStudySwapLayout.setHorizontalGroup(
            panelStudySwapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnStudySwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelStudySwapLayout.setVerticalGroup(
            panelStudySwapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnStudySwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(panelSectionSwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(panelStudySwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSectionSwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(panelStudySwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0))
        );

        scrollContainer.setBackground(new java.awt.Color(153, 153, 153));
        scrollContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        panelContainer.setBackground(new java.awt.Color(153, 153, 153));
        panelContainer.setPreferredSize(new java.awt.Dimension(607, 0));

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        scrollContainer.setViewportView(panelContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollContainer))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollContainer)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSectionSwapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectionSwapMouseEntered
        btnSectionSwap.setBackground(new Color(50,120,0));
    }//GEN-LAST:event_btnSectionSwapMouseEntered

    private void btnSectionSwapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectionSwapMousePressed
        btnSectionSwap.setBackground(new Color(50,80,0));
        cardLayout.show(panelContainer, "panelSectionSwap");
    }//GEN-LAST:event_btnSectionSwapMousePressed

    private void btnSectionSwapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectionSwapMouseReleased
        btnSectionSwap.setBackground(new Color(50,120,0));
    }//GEN-LAST:event_btnSectionSwapMouseReleased

    private void btnSectionSwapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectionSwapMouseExited
        btnSectionSwap.setBackground(new Color(50,100,0));
    }//GEN-LAST:event_btnSectionSwapMouseExited

    private void btnStudySwapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudySwapMouseEntered
        btnStudySwap.setBackground(new Color(0, 100, 170));
    }//GEN-LAST:event_btnStudySwapMouseEntered

    private void btnStudySwapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudySwapMousePressed
        btnStudySwap.setBackground(new Color(0, 100, 130));
        cardLayout.show(panelContainer, "panelStudySwap");
    }//GEN-LAST:event_btnStudySwapMousePressed

    private void btnStudySwapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudySwapMouseReleased
        btnStudySwap.setBackground(new Color(0, 100, 170));
    }//GEN-LAST:event_btnStudySwapMouseReleased

    private void btnStudySwapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudySwapMouseExited
        btnStudySwap.setBackground(new Color(0, 100, 150));
    }//GEN-LAST:event_btnStudySwapMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSectionSwap;
    private javax.swing.JLabel btnStudySwap;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelSectionSwap;
    private javax.swing.JPanel panelStudySwap;
    private javax.swing.JScrollPane scrollContainer;
    // End of variables declaration//GEN-END:variables
}
