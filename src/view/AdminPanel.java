package view;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import model.User;

public class AdminPanel extends javax.swing.JPanel {
    
    Frame parentFrame;
    Dialog parentDialog;
    @SuppressWarnings("LeakingThisInConstructor")
    public AdminPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnConsole = new FlatButton();
        btnAddCourse = new FlatButton();

        setBackground(new java.awt.Color(60, 50, 50));

        jScrollPane1.setBackground(new java.awt.Color(60, 50, 50));
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));

        jPanel1.setBackground(new java.awt.Color(60, 50, 50));

        btnConsole.setBackground(new java.awt.Color(200, 200, 200));
        btnConsole.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnConsole.setForeground(new java.awt.Color(0, 0, 0));
        btnConsole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsole.setText("Open Console");
        btnConsole.setOpaque(true);
        btnConsole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsoleMouseClicked(evt);
            }
        });

        btnAddCourse.setBackground(new java.awt.Color(200, 200, 200));
        btnAddCourse.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnAddCourse.setForeground(new java.awt.Color(0, 0, 0));
        btnAddCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddCourse.setText("Add Course");
        btnAddCourse.setOpaque(true);
        btnAddCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCourseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCourseMouseClicked
        AddCoursePanel addCoursePanel = new AddCoursePanel();
        if (parentDialog == null) new DialogForm(parentFrame, true, addCoursePanel, "Add Course", true, true, true).setVisible(true);
        else new DialogForm(parentDialog, true, addCoursePanel, "Add Course", true, true, true).setVisible(true);
    }//GEN-LAST:event_btnAddCourseMouseClicked

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void btnConsoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsoleMouseClicked
        if (User.getUser().getRole() > User.POWER_ADMIN) {
            ErrorPanel errorPanel = new ErrorPanel("This feature is only available to Power Admin");
            if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Unauthorised access", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, errorPanel, "Unauthorised access", true, true, true).setVisible(true);
        } else {
            if (parentDialog == null) new DialogForm(parentFrame, true, new ConsolePanel(), "Console", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, new ConsolePanel(), "Console", true, true, true).setVisible(true);
        }
    }//GEN-LAST:event_btnConsoleMouseClicked
    
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddCourse;
    private javax.swing.JLabel btnConsole;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
