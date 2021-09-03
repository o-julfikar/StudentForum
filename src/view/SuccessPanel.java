package view;

public class SuccessPanel extends javax.swing.JPanel {

    public SuccessPanel(String msg) {
        initComponents();
        txtMsg.setText(msg);
    }
    
    public SuccessPanel() {
        this("No message");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMsg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 150, 70));
        setForeground(new java.awt.Color(255, 255, 255));

        txtMsg.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtMsg.setForeground(new java.awt.Color(255, 255, 255));
        txtMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMsg.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtMsg;
    // End of variables declaration//GEN-END:variables
}
