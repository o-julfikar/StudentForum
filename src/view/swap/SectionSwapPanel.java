package view.swap;

import controller.swap.SectionSwapEngine;
import controller.swap.SectionSwapPanelController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.User;
import model.swap.SectionModel;
import view.DialogForm;
import view.SuccessPanel;

public class SectionSwapPanel extends javax.swing.JPanel {

    // <editor-fold defaultstate="collapsed" desc="Table Models">
    DefaultTableModel offerModel = new DefaultTableModel(new Object[] {"Offer"}, 0) {
        @Override
        public boolean isCellEditable(int column, int row) {
            return false;
        }
    };
    DefaultTableModel preferModel = new DefaultTableModel(new Object[] {"Prefer"}, 0) {
        @Override
        public boolean isCellEditable(int column, int row) {
            return false;
        }
    };
    DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Runnable and Thread Variables">
    Runnable addOfferProcess = new Runnable() {
        @Override
        public void run() {
            String selectedCourse = cboOffer.getSelectedItem().toString();
            
            if (SectionSwapPanelController.addOffer(parentFrame, parentDialog, 
                    User.getUser().getId(), selectedCourse.substring(0, 6), 
                    selectedCourse.substring(8, selectedCourse.length() - 1))) {
                offerModel.addRow(new Object[] {selectedCourse});
            }
        }
    };
    Runnable addPreferProcess = new Runnable() {
        @Override
        public void run() {
            String selectedCourse = cboPrefer.getSelectedItem().toString();

            if (SectionSwapPanelController.addPrefer(parentFrame, parentDialog, 
                    User.getUser().getId(), selectedCourse.substring(0, 6), 
                    selectedCourse.substring(8, selectedCourse.length() - 1))) {
                preferModel.addRow(new Object[] {selectedCourse});
                cboPreferFilter.addItem(selectedCourse);
            }
        }
    };
    Runnable loadOffersProcess = new Runnable() {
        @Override
        public void run() {
            SectionSwapPanelController.getOfferObjects(User.getUser().getId()).forEach((row) -> {
                offerModel.addRow(row);
            });
        }
    };
    Runnable loadPrefersProcess = new Runnable() {
        @Override
        public void run() {
            SectionSwapPanelController.getPreferObjects(User.getUser().getId()).forEach((row) -> {
                preferModel.addRow(new Object[] {row});
                cboPreferFilter.addItem(row);
            });
        }
    };
    Runnable runSectionSwapProcess = new Runnable() {
        @Override
        public void run() {
            SectionSwapEngine sectionSwapEngine = new SectionSwapEngine();
            panelResult.removeAll();
            int matches = 0;
            for (SectionSwapCard card : sectionSwapEngine.runSectionSwap(SectionModel.getSection(cboPreferFilter.getSelectedItem().toString()))) {
                panelResult.add(card);
                matches++;
            }
            SuccessPanel successPanel;
            if (matches > 0) {
                successPanel = new SuccessPanel("Number of swaps require: " + matches);
            } else {
                successPanel = new SuccessPanel("Sorry, unable to find a match for you. Please try again later!");
            }             
            panelResult.revalidate();
            if (parentDialog == null) new DialogForm(parentFrame, true, successPanel, "Operation complete", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, successPanel, "Operation complete", true, true, true).setVisible(true);
        }
    };
    Runnable deleteOfferProcess = new Runnable() {
        @Override
        public void run() {
            String selectedSection = tableOffer.getValueAt(tableOfferSelectedRow, 0).toString();
            String course = selectedSection.substring(0, 6);
            String section = selectedSection.substring(8, 10);
            
            if (SectionSwapPanelController.deleteOffer(parentFrame, parentDialog, User.getUser().getId(), course, section)) {
                ((DefaultTableModel) tableOffer.getModel()).removeRow(tableOfferSelectedRow);
            }
        }
    };
    Runnable deletePreferProcess = new Runnable() {
        @Override
        public void run() {
            String selectedSection = tablePrefer.getValueAt(tablePreferSelectedRow, 0).toString();
            String course = selectedSection.substring(0, 6);
            String section = selectedSection.substring(8, 10);
            
            if (SectionSwapPanelController.deletePrefer(parentFrame, parentDialog, User.getUser().getId(), course, section)) {
                ((DefaultTableModel) tablePrefer.getModel()).removeRow(tablePreferSelectedRow);
                cboPreferFilter.removeItemAt(tablePreferSelectedRow);
            }
        }
    };
    Thread addOfferThread, addPreferThread, 
            loadOffersThread, loadPrefersThread, 
            runSectionSwapThread,
            deleteOfferThread, deletePreferThread;
    // </editor-fold>
    
    int tableOfferSelectedRow, tablePreferSelectedRow;
    
    Frame parentFrame;
    Dialog parentDialog;
    
    public SectionSwapPanel() {
        initComponents();
        SectionModel.fillSections(cboOffer);
        SectionModel.fillSections(cboPrefer);
        tableOffer.setModel(offerModel);
        tablePrefer.setModel(preferModel);
        tableOffer.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        tablePrefer.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        scrollOffer.getViewport().setBackground(new Color(80, 80, 80));
        scrollPrefer.getViewport().setBackground(new Color(80, 80, 80));
        headerRenderer.setBackground(new Color(50, 50, 50));
        headerRenderer.setForeground(Color.LIGHT_GRAY);
        (loadOffersThread = new Thread(loadOffersProcess)).start();
        (loadPrefersThread = new Thread(loadPrefersProcess)).start();        
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

        panelContent = new javax.swing.JPanel();
        panelFind = new javax.swing.JPanel();
        cboPreferFilter = new javax.swing.JComboBox<>();
        btnFind = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        scrollResult = new javax.swing.JScrollPane();
        panelResult = new javax.swing.JPanel();
        panelSIdeBar = new javax.swing.JPanel();
        scrollOffer = new javax.swing.JScrollPane();
        tableOffer = new javax.swing.JTable();
        cboOffer = new javax.swing.JComboBox<>();
        btnOfferAdd = new javax.swing.JButton();
        scrollPrefer = new javax.swing.JScrollPane();
        tablePrefer = new javax.swing.JTable();
        cboPrefer = new javax.swing.JComboBox<>();
        btnPreferAdd = new javax.swing.JButton();

        setBackground(new java.awt.Color(50, 100, 0));

        panelContent.setBackground(new java.awt.Color(51, 102, 0));

        panelFind.setBackground(new java.awt.Color(51, 102, 0));

        cboPreferFilter.setBackground(new java.awt.Color(0, 102, 51));
        cboPreferFilter.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cboPreferFilter.setForeground(new java.awt.Color(204, 204, 204));

        btnFind.setBackground(new java.awt.Color(3, 70, 36));
        btnFind.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(0, 0, 0));
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFindLayout = new javax.swing.GroupLayout(panelFind);
        panelFind.setLayout(panelFindLayout);
        panelFindLayout.setHorizontalGroup(
            panelFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFindLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cboPreferFilter, 0, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addGap(0, 0, 0))
        );
        panelFindLayout.setVerticalGroup(
            panelFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFindLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPreferFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addContainerGap())
        );

        btnRequest.setBackground(new java.awt.Color(3, 70, 36));
        btnRequest.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnRequest.setForeground(new java.awt.Color(0, 0, 0));
        btnRequest.setText("Request");

        scrollResult.setBackground(new java.awt.Color(51, 102, 0));
        scrollResult.setBorder(null);
        scrollResult.getVerticalScrollBar().setUnitIncrement(16);

        panelResult.setBackground(new java.awt.Color(51, 102, 0));
        panelResult.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        panelResult.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        scrollResult.setViewportView(panelResult);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollResult)
                    .addComponent(panelFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRequest)
                .addContainerGap())
        );

        panelSIdeBar.setBackground(new java.awt.Color(12, 72, 42));
        panelSIdeBar.setPreferredSize(new java.awt.Dimension(207, 158));

        scrollOffer.getVerticalScrollBar().setUnitIncrement(16);

        tableOffer.setBackground(new java.awt.Color(80, 80, 80));
        tableOffer.setForeground(new java.awt.Color(255, 255, 255));
        tableOffer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Offer"
            }
        ));
        tableOffer.setGridColor(new java.awt.Color(102, 0, 0));
        tableOffer.setSelectionBackground(new java.awt.Color(255, 204, 51));
        tableOffer.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableOffer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOfferMouseClicked(evt);
            }
        });
        scrollOffer.setViewportView(tableOffer);

        cboOffer.setBackground(new java.awt.Color(0, 102, 51));
        cboOffer.setForeground(new java.awt.Color(204, 204, 204));

        btnOfferAdd.setBackground(new java.awt.Color(0, 102, 51));
        btnOfferAdd.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnOfferAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnOfferAdd.setText("Add");
        btnOfferAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfferAddActionPerformed(evt);
            }
        });

        scrollPrefer.getVerticalScrollBar().setUnitIncrement(16);

        tablePrefer.setBackground(new java.awt.Color(80, 80, 80));
        tablePrefer.setForeground(new java.awt.Color(255, 255, 255));
        tablePrefer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prefer"
            }
        ));
        tablePrefer.setSelectionBackground(new java.awt.Color(255, 204, 51));
        tablePrefer.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablePrefer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePreferMouseClicked(evt);
            }
        });
        scrollPrefer.setViewportView(tablePrefer);

        cboPrefer.setBackground(new java.awt.Color(0, 102, 51));
        cboPrefer.setForeground(new java.awt.Color(204, 204, 204));

        btnPreferAdd.setBackground(new java.awt.Color(0, 102, 51));
        btnPreferAdd.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnPreferAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnPreferAdd.setText("Add");
        btnPreferAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreferAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSIdeBarLayout = new javax.swing.GroupLayout(panelSIdeBar);
        panelSIdeBar.setLayout(panelSIdeBarLayout);
        panelSIdeBarLayout.setHorizontalGroup(
            panelSIdeBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSIdeBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSIdeBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollOffer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cboOffer, 0, 195, Short.MAX_VALUE)
                    .addComponent(btnOfferAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPrefer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cboPrefer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPreferAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSIdeBarLayout.setVerticalGroup(
            panelSIdeBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSIdeBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollOffer, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOfferAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPrefer, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPrefer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPreferAdd)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelSIdeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSIdeBar, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(panelContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOfferAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfferAddActionPerformed
        if (addOfferThread == null || addOfferThread.getState() == Thread.State.TERMINATED) (addOfferThread = new Thread(addOfferProcess)).start();
    }//GEN-LAST:event_btnOfferAddActionPerformed

    private void btnPreferAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreferAddActionPerformed
        if (addPreferThread == null || addPreferThread.getState() == Thread.State.TERMINATED) (addPreferThread = new Thread(addPreferProcess)).start();
    }//GEN-LAST:event_btnPreferAddActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (runSectionSwapThread == null || runSectionSwapThread.getState() == Thread.State.TERMINATED) (runSectionSwapThread = new Thread(runSectionSwapProcess)).start();
    }//GEN-LAST:event_btnFindActionPerformed

    private void tableOfferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOfferMouseClicked
        if (evt.getClickCount() == 2) {
            tableOfferSelectedRow = tableOffer.getSelectedRow();
            if (deleteOfferThread == null || deleteOfferThread.getState() == Thread.State.TERMINATED) (deleteOfferThread = new Thread(deleteOfferProcess)).start();
        }
    }//GEN-LAST:event_tableOfferMouseClicked

    private void tablePreferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePreferMouseClicked
        if (evt.getClickCount() == 2) {
            tablePreferSelectedRow = tablePrefer.getSelectedRow();
            if (deletePreferThread == null || deletePreferThread.getState() == Thread.State.TERMINATED) (deletePreferThread = new Thread(deletePreferProcess)).start();
        }
    }//GEN-LAST:event_tablePreferMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnOfferAdd;
    private javax.swing.JButton btnPreferAdd;
    private javax.swing.JButton btnRequest;
    private javax.swing.JComboBox<String> cboOffer;
    private javax.swing.JComboBox<String> cboPrefer;
    private javax.swing.JComboBox<String> cboPreferFilter;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelFind;
    private javax.swing.JPanel panelResult;
    private javax.swing.JPanel panelSIdeBar;
    private javax.swing.JScrollPane scrollOffer;
    private javax.swing.JScrollPane scrollPrefer;
    private javax.swing.JScrollPane scrollResult;
    private javax.swing.JTable tableOffer;
    private javax.swing.JTable tablePrefer;
    // End of variables declaration//GEN-END:variables
}
