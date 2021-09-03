package view.forum;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import model.User;
import view.DialogForm;

public class PostCard extends JPanel implements Scrollable {

    boolean controlPressed;
    int postId;
    User writer;
    ArrayList<String> tags;
    Container parentContainer;
    Date date;
    ForumPanel forumPanel;
    Frame parentFrame;
    Dialog parentDialog;
    
    public PostCard(int postId, String text, User writer, Date date, ArrayList<String> tags) {
        initComponents();
        this.postId = postId;
        this.writer = writer;
        this.tags = tags;
        this.date = date;
        txtName.setText(writer.getName());
        txtDepartment.setText(writer.getDepartment().toString());
        txtSemester.setText(writer.getSemester().toString());
        imgPhoto.setIcon(writer.getPhoto());
        txtPost.setText(text);
        txtDate.setText(new SimpleDateFormat("EEEE, MMMM dd, yyyy ,, hh:mm a").format(date).replace(",,", "at"));
        
        for (String tag : tags) {
            JButton tagButton = new JButton(tag);
            tagButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (forumPanel != null) {
                        forumPanel.loadPosts(tagButton.getText());
                    } else {
                        parentContainer = PostCard.this.getParent();
                        while (parentContainer != null && (parentContainer instanceof Container) && !(parentContainer instanceof ForumPanel)) parentContainer = parentContainer.getParent();
                        forumPanel = parentContainer instanceof ForumPanel? (ForumPanel) parentContainer : null;
                        if (forumPanel != null) actionPerformed(e);
                    }
                }
            });
            panelTag.add(tagButton, tag);
        }
        startKeyListener();
    }
        
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    public PostCard() {
        initComponents();
        startKeyListener();
    }   
    
    public void startKeyListener() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                synchronized(PostCard.class) {
                    switch(e.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                                controlPressed = true;
                                scrollPost.setWheelScrollingEnabled(true);
                            }
                            break;
                        case KeyEvent.KEY_RELEASED:
                            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                                controlPressed = false;
                                scrollPost.setWheelScrollingEnabled(false);
                            }
                            break;
                    }
                    return false;
                }
            }
        });
    }

    public boolean isControlPressed() {
        synchronized(PostCard.class) {
            return controlPressed;
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTag = new javax.swing.JPanel();
        imgPhoto = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JLabel();
        txtSemester = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        scrollPost = new javax.swing.JScrollPane();
        txtPost = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(51, 51, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelTag.setBackground(new java.awt.Color(204, 204, 204));
        panelTag.setForeground(new java.awt.Color(51, 51, 51));
        panelTag.setLayout(new java.awt.GridLayout(1, 0, 10, 5));

        imgPhoto.setForeground(new java.awt.Color(51, 51, 51));
        imgPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/userphoto_default - 100px.png"))); // NOI18N
        imgPhoto.setText("jLabel1");

        txtName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.setText("Mohammed Julfikar Ali Mahbub");

        txtDepartment.setForeground(new java.awt.Color(51, 51, 51));
        txtDepartment.setText("Department of Computer Science and Engineering");

        txtSemester.setForeground(new java.awt.Color(51, 51, 51));
        txtSemester.setText("Summer 2018");

        txtDate.setForeground(new java.awt.Color(51, 51, 51));
        txtDate.setText("Wednesday, March 11, 2020");

        scrollPost.setBackground(new java.awt.Color(204, 204, 204));
        scrollPost.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        scrollPost.setForeground(new java.awt.Color(51, 51, 51));
        scrollPost.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPost.setWheelScrollingEnabled(false);
        scrollPost.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                scrollPostMouseWheelMoved(evt);
            }
        });

        txtPost.setEditable(false);
        txtPost.setBackground(new java.awt.Color(204, 204, 204));
        txtPost.setColumns(20);
        txtPost.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtPost.setForeground(new java.awt.Color(51, 51, 51));
        txtPost.setLineWrap(true);
        txtPost.setRows(5);
        txtPost.setText("Create two threads and divide a task between these thread equally. The thread should work concurrently and complete the assigned task. For example, the task is to calculate the sum of numbers from 1-100. Thread one will calculate sum from 1-50 and thread two will calculate sum from 51-100. And finally the total sum from 1-100 will be printed, where the two threads worked equally.");
        txtPost.setWrapStyleWord(true);
        txtPost.setCaretPosition(0);
        txtPost.setMargin(new java.awt.Insets(5, 5, 5, 5));
        scrollPost.setViewportView(txtPost);
        txtPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPost)
                    .addComponent(panelTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(imgPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtDepartment)
                            .addComponent(txtSemester)
                            .addComponent(txtDate))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSemester)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate)))
                .addGap(18, 18, 18)
                .addComponent(scrollPost)
                .addGap(18, 18, 18)
                .addComponent(panelTag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void scrollPostMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_scrollPostMouseWheelMoved
        if (!isControlPressed()) {
            getParent().dispatchEvent(evt);
        }
        
    }//GEN-LAST:event_scrollPostMouseWheelMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        mouseClick(evt);
    }//GEN-LAST:event_formMouseClicked

    public void mouseClick(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (parentDialog == null) new DialogForm(parentFrame, true, new PostPanel(copy()), txtName.getText() + "'s Post", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, new PostPanel(copy()), txtName.getText() + "'s Post", true, true, true).setVisible(true);
        }
    }
    
    private PostCard copy() {
        return new PostCard(postId, txtPost.getText(), writer, date, tags) {
            @Override
            public void mouseClick(java.awt.event.MouseEvent evt) {
                
            }
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgPhoto;
    private javax.swing.JPanel panelTag;
    private javax.swing.JScrollPane scrollPost;
    public javax.swing.JLabel txtDate;
    public javax.swing.JLabel txtDepartment;
    public javax.swing.JLabel txtName;
    private javax.swing.JTextArea txtPost;
    public javax.swing.JLabel txtSemester;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="Scrollable Implement Methods">
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return super.getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 16;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 16;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return true;
    }
    // </editor-fold>
}
