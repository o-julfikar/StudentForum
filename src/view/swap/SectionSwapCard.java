package view.swap;

import model.ImageResource;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;

public class SectionSwapCard extends javax.swing.JPanel {

    public SectionSwapCard(String course, String section, String providerName, Icon providerImage, String receiverName, Icon receiverImage) {
        initComponents();
        txtCourse.setText(course);
        txtSection.setText("Section: " + section);
        txtProvider.setText("Provider: " + providerName);
        imgProvider.setIcon(providerImage);
        txtReceiver.setText("Receiver: " + receiverName);
        imgReceiver.setIcon(receiverImage);
        setOpaque(false);
    }
    
    public SectionSwapCard() {
        this("NUL101", "01", "John", ImageResource.userPhoto, "Smith", ImageResource.userPhoto);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cornerRadius = 30;
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.setColor(getForeground());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgProvider = new javax.swing.JLabel();
        imgReceiver = new javax.swing.JLabel();
        panelSectionInfo = new javax.swing.JPanel();
        txtCourse = new javax.swing.JLabel();
        txtSection = new javax.swing.JLabel();
        txtProvider = new javax.swing.JLabel();
        txtReceiver = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 34, 17));
        setPreferredSize(new java.awt.Dimension(500, 248));

        imgProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        imgReceiver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N

        panelSectionInfo.setBackground(new java.awt.Color(0, 34, 17));

        txtCourse.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtCourse.setForeground(new java.awt.Color(204, 204, 204));
        txtCourse.setText("CSE110");

        txtSection.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtSection.setForeground(new java.awt.Color(204, 204, 204));
        txtSection.setText("Section: 01");

        javax.swing.GroupLayout panelSectionInfoLayout = new javax.swing.GroupLayout(panelSectionInfo);
        panelSectionInfo.setLayout(panelSectionInfoLayout);
        panelSectionInfoLayout.setHorizontalGroup(
            panelSectionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSectionInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSectionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourse)
                    .addComponent(txtSection))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSectionInfoLayout.setVerticalGroup(
            panelSectionInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSectionInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSection)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtProvider.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtProvider.setForeground(new java.awt.Color(204, 204, 204));
        txtProvider.setText("Provider: John");

        txtReceiver.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtReceiver.setForeground(new java.awt.Color(204, 204, 204));
        txtReceiver.setText("Receiver: Smith");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(panelSectionInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(imgReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtProvider)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtReceiver)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtProvider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgReceiver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSectionInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReceiver)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgProvider;
    private javax.swing.JLabel imgReceiver;
    private javax.swing.JPanel panelSectionInfo;
    private javax.swing.JLabel txtCourse;
    private javax.swing.JLabel txtProvider;
    private javax.swing.JLabel txtReceiver;
    private javax.swing.JLabel txtSection;
    // End of variables declaration//GEN-END:variables
}
