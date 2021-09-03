package view;

import java.awt.Frame;
import javax.swing.JComponent;

public class DialogForm extends javax.swing.JDialog {

    // <editor-fold defaultstate="collapsed" desc="Constructors for Frame">
    public DialogForm(java.awt.Frame parent, boolean modal, JComponent component, String title, boolean inheritBackgroundColor, boolean inheritSize, boolean centreScreen) {
        this(parent, modal, component, title);
//        if (inheritBackgroundColor) panelMain.setBackground(component.getBackground());
        if (inheritSize) setSize(component.getPreferredSize().width + 24, component.getPreferredSize().height + panelTitleBar.getPreferredSize().height + 25);
        if (centreScreen) setLocationRelativeTo(null);
        requestFocus();
    }
    
    public DialogForm(java.awt.Frame parent, boolean modal, JComponent component, String title) {
        this(parent, modal);
        panelTitleBar.add(new DialogTitlePanel(this, title), "titlePanel");
        panelContent.add(component);
        panelContent.revalidate();
    }
    
    public DialogForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    // </editor-fold>
    
    public DialogForm() {
        this((Frame) null, true);
        panelTitleBar.add(new DialogTitlePanel(this, "Dialog Form"), "titlePanel");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Constructors for Dialog">
    public DialogForm(java.awt.Dialog parent, boolean modal, JComponent component, String title, boolean inheritBackgroundColor, boolean inheritSize, boolean centreScreen) {
        this(parent, modal, component, title);
//        if (inheritBackgroundColor) panelMain.setBackground(component.getBackground());
        if (inheritSize) setSize(component.getPreferredSize().width + 24, component.getPreferredSize().height + panelTitleBar.getPreferredSize().height + 24);
        if (centreScreen) setLocationRelativeTo(null);
        requestFocus();
    }
    
    public DialogForm(java.awt.Dialog parent, boolean modal, JComponent component, String title) {
        this(parent, modal);
        panelTitleBar.add(new DialogTitlePanel(this, title), "titlePanel");
        panelContent.add(component);
        panelContent.revalidate();
    }
    
    public DialogForm(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitleBar = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        scrollContent = new javax.swing.JScrollPane();
        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 102));
        setUndecorated(true);

        panelTitleBar.setBackground(new java.awt.Color(51, 51, 51));
        panelTitleBar.setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(102, 0, 102));

        scrollContent.setBorder(null);
        scrollContent.getVerticalScrollBar().setUnitIncrement(16);

        panelContent.setLayout(new java.awt.GridLayout(0, 1));
        scrollContent.setViewportView(panelContent);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollContent)
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollContent, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(DialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogForm dialog = new DialogForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContent;
    public javax.swing.JPanel panelMain;
    public javax.swing.JPanel panelTitleBar;
    public javax.swing.JScrollPane scrollContent;
    // End of variables declaration//GEN-END:variables
}
