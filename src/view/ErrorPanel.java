package view;

public class ErrorPanel extends javax.swing.JPanel {

    public ErrorPanel(String msg) {
        initComponents();
        txtMsg.setText(msg);
    }
    
    public ErrorPanel() {
        this("No message");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMsg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(108, 44, 44));

        txtMsg.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtMsg.setForeground(new java.awt.Color(255, 255, 255));
        txtMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMsg.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtMsg;
    // End of variables declaration//GEN-END:variables
}
