package view.feedback;

import controller.feedback.FeedbackController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.SwingUtilities;
import model.User;
import view.DialogForm;

public class FeedbackPanel extends javax.swing.JPanel {

    GridLayout gridLayout;
    Frame parentFrame;
    Dialog parentDialog;
    Runnable loadFacultyProcess = new Runnable() {
        @Override
        public void run() {
            panelContent.removeAll();
            FeedbackController.getFeedbackCards(parentFrame, parentDialog, txtSearch.getText()).forEach((feedbackCard) -> {
                panelContent.add(feedbackCard);
            });
            panelContent.revalidate();
        }
    };
    Thread loadFacultyThread;
    
    boolean requestUpdate;
    
    public FeedbackPanel() {
        initComponents();
        if (User.isSignedIn() && User.getUser().getRole() >= User.STUDENT) panelAddFaculty.setVisible(false);
        gridLayout = (GridLayout) panelContent.getLayout();
        loadFeedback();
    }
    
    private void loadFeedback() {
        (loadFacultyThread = new Thread(loadFacultyProcess)).start();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JTextField();
        scrollContent = new javax.swing.JScrollPane();
        panelContent = new javax.swing.JPanel();
        panelAddFaculty = new javax.swing.JPanel();
        btnAddFaculty = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 0));

        panelSearch.setBackground(new java.awt.Color(153, 153, 153));

        txtSearch.setBackground(new java.awt.Color(64, 64, 64));
        txtSearch.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setBorder(null);
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        lblSearch.setBackground(new java.awt.Color(64, 64, 64));
        lblSearch.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(153, 153, 153));
        lblSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblSearch.setText("Search");
        lblSearch.setBorder(null);
        lblSearch.setSelectedTextColor(new java.awt.Color(153, 153, 153));
        lblSearch.setSelectionColor(new java.awt.Color(64, 64, 64));
        lblSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSearchActionPerformed(evt);
            }
        });
        lblSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblSearchKeyPressed(evt);
            }
        });
        lblSearch.setCaretColor(new Color(64, 64, 64));

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtSearch.setVisible(false);

        scrollContent.setBackground(new java.awt.Color(153, 153, 153));
        scrollContent.setBorder(null);
        scrollContent.getVerticalScrollBar().setUnitIncrement(16);

        panelContent.setBackground(new java.awt.Color(153, 153, 153));
        panelContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        panelContent.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        scrollContent.setViewportView(panelContent);

        panelAddFaculty.setBackground(new java.awt.Color(153, 153, 153));

        btnAddFaculty.setBackground(new java.awt.Color(153, 0, 0));
        btnAddFaculty.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAddFaculty.setForeground(new java.awt.Color(255, 255, 255));
        btnAddFaculty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddFaculty.setText("Add New Faculty");
        btnAddFaculty.setOpaque(true);
        btnAddFaculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddFacultyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddFacultyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddFacultyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddFacultyMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddFacultyMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelAddFacultyLayout = new javax.swing.GroupLayout(panelAddFaculty);
        panelAddFaculty.setLayout(panelAddFacultyLayout);
        panelAddFacultyLayout.setHorizontalGroup(
            panelAddFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAddFaculty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        panelAddFacultyLayout.setVerticalGroup(
            panelAddFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAddFaculty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollContent)
                    .addComponent(panelAddFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollContent, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAddFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Add Faculty Button Events">
    int mouseButton = 0;
    private void btnAddFacultyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFacultyMouseEntered
        if (mouseButton == 0) btnAddFaculty.setBackground(new Color(183,0,0));
        else btnAddFaculty.setBackground(new Color(123,0,0));
    }//GEN-LAST:event_btnAddFacultyMouseEntered

    private void btnAddFacultyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFacultyMousePressed
        btnAddFaculty.setBackground(new Color(123,0,0));
        mouseButton = evt.getButton();
    }//GEN-LAST:event_btnAddFacultyMousePressed

    private void btnAddFacultyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFacultyMouseReleased
        if (evt.getX() >= 0 && evt.getX() <= btnAddFaculty.getWidth() && evt.getY() >= 0 && evt.getY() <= btnAddFaculty.getHeight()) btnAddFaculty.setBackground(new Color(183,0,0));
        else btnAddFaculty.setBackground(new Color(153,0,0));
        mouseButton = 0;
    }//GEN-LAST:event_btnAddFacultyMouseReleased

    private void btnAddFacultyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFacultyMouseExited
        btnAddFaculty.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_btnAddFacultyMouseExited

    private void btnAddFacultyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFacultyMouseClicked
        if (User.isSignedIn() && User.getUser().getRole() >= User.STUDENT) return;
        AddFacultyPanel addFacultyPanel = new AddFacultyPanel();
        DialogForm feedbackDialogForm;
        if (parentDialog == null) feedbackDialogForm = new DialogForm(parentFrame, true, addFacultyPanel, "Add Faculty", true, true, true);
        else feedbackDialogForm = new DialogForm(parentDialog, true, addFacultyPanel, "Add Faculty", true, true, true);
        feedbackDialogForm.setVisible(true);
        
        if (addFacultyPanel.numberOfNewFaculty > 0 && (loadFacultyThread == null || loadFacultyThread.getState() == Thread.State.TERMINATED)) 
            (loadFacultyThread = new Thread(loadFacultyProcess)).start();
    }//GEN-LAST:event_btnAddFacultyMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        if (txtSearch.getText().length() > 0) {
            lblSearch.setVisible(false);
            txtSearch.setVisible(true);
        } else {
            lblSearch.setVisible(true);
            txtSearch.setVisible(false);
            lblSearch.requestFocus();
        }
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void lblSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSearchKeyPressed
        char keyChar = evt.getKeyChar();
        if (keyChar == 10) {
            evt.consume();
            if (loadFacultyThread == null || loadFacultyThread.getState() == Thread.State.TERMINATED) (loadFacultyThread = new Thread(loadFacultyProcess)).start();
        } else if (keyChar < 32 || keyChar > 126) {
            evt.consume();
        } else {
            lblSearch.setVisible(false);
            txtSearch.setLocation(0, 0);
            txtSearch.setSize(lblSearch.getSize());
            txtSearch.setVisible(true);
            txtSearch.setText(keyChar + "");
            txtSearch.requestFocus();
        }
    }//GEN-LAST:event_lblSearchKeyPressed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        if (loadFacultyThread == null || loadFacultyThread.getState() == Thread.State.TERMINATED) (loadFacultyThread = new Thread(loadFacultyProcess)).start();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lblSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSearchActionPerformed
        
    }//GEN-LAST:event_lblSearchActionPerformed
    // </editor-fold>
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddFaculty;
    private javax.swing.JTextField lblSearch;
    private javax.swing.JPanel panelAddFaculty;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JScrollPane scrollContent;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
