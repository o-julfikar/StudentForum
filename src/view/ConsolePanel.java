package view;

import controller.ConsoleController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Window;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ConsolePanel extends javax.swing.JPanel {
    
    DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
    DefaultTableModel tableModel;
    Dialog parentDialog;
    Stack<String> processedLines = new Stack<>();
    Stack<String> tempLines = new Stack<>();
    char previousKey;
    
    public ConsolePanel() {
        initComponents();
        scrollTable.getViewport().setBackground(new Color(80, 80, 80));
        headerRenderer.setBackground(new Color(50, 50, 50));
        headerRenderer.setForeground(Color.LIGHT_GRAY);
        processedLines.push("");
    }
    
    public void setHeader(Object... header) {
        table.setModel(tableModel = getModel(header));
        setHeaderRenderer();
    }
    
    public DefaultTableModel getModel(Object... header) {
        return new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
    }
    
    public void setHeaderRenderer() {
        Enumeration<TableColumn> e = table.getColumnModel().getColumns();
        while (e.hasMoreElements()) {
            TableColumn column = e.nextElement();
            column.setHeaderRenderer(headerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        scrollConsole = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollTable.setViewportView(table);

        txtConsole.setBackground(new java.awt.Color(20, 20, 20));
        txtConsole.setColumns(20);
        txtConsole.setForeground(new java.awt.Color(255, 255, 255));
        txtConsole.setLineWrap(true);
        txtConsole.setRows(5);
        txtConsole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsoleKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsoleKeyReleased(evt);
            }
        });
        scrollConsole.setViewportView(txtConsole);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .addComponent(scrollConsole)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsoleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsoleKeyReleased
        if (evt.getKeyChar() == 10) {
            while (tempLines.size() > 0) processedLines.push(tempLines.pop());
            String command = txtConsole.getText().toLowerCase();
            if (command.startsWith("select")) {
                LinkedList<Object[]> dataObjects = ConsoleController.getData(parentDialog, txtConsole.getText());
                setHeader(dataObjects.poll());
                dataObjects.forEach((row) -> {
                    tableModel.addRow(row);
                });
            } else if (command.startsWith("insert") || command.startsWith("update") || command.startsWith("delete")) {
                if (ConsoleController.updateData(parentDialog, txtConsole.getText())) {
                    SuccessPanel successPanel = new SuccessPanel("Updated successfully");
                    new DialogForm(parentDialog, true, successPanel, "Successfull", true, true, true).setVisible(true);
                }
            } else if (command.startsWith("run")) {
                try {
                    String[] text = txtConsole.getText().replace(";", "").split(" ");
                    Class cl = Class.forName(text[1]);
                    Object obj = cl.newInstance();
                    if (obj instanceof JPanel) 
                        new DialogForm(parentDialog, true, (JPanel) obj, cl.getName(), true, true, true).setVisible(true);
                    else if (obj instanceof Window) 
                        ((Window) obj).setVisible(true);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                    ErrorPanel errorPanel = new ErrorPanel("Invalid class name");
                    new DialogForm(parentDialog, true, errorPanel, "Error", true, true, true).setVisible(true);
                }
            } else if (command.matches("end|bye|exit|tata|cya|goodbye")) {
                SwingUtilities.getWindowAncestor(this).dispose();
            } else {
                ErrorPanel errorPanel = new ErrorPanel("Please enter a valid command");
                new DialogForm(parentDialog, true, errorPanel, "Error", true, true, true).setVisible(true);
            }
            processedLines.pop();
            processedLines.push(txtConsole.getText());
            txtConsole.setText(processedLines.push(""));
        } else if (evt.getKeyCode() == 38) {
            if (processedLines.size() > 1) {
                tempLines.push(processedLines.pop());
                txtConsole.setText(processedLines.peek());
            }
        } else if (evt.getKeyCode() == 40) {
            if (tempLines.size() > 0) {
                processedLines.push(tempLines.pop());
                txtConsole.setText(processedLines.peek());
            }
        } else {
            while (tempLines.size() > 0) processedLines.push(tempLines.pop());
        }
    }//GEN-LAST:event_txtConsoleKeyReleased

    private void txtConsoleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsoleKeyPressed
        if (evt.getKeyChar() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtConsoleKeyPressed
    
    @Override
    public void addNotify() {
        super.addNotify();
        parentDialog = (Dialog) SwingUtilities.getWindowAncestor(this);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollConsole;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables
}
