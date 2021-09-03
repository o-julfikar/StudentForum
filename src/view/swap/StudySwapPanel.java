package view.swap;

import controller.swap.Course;
import controller.swap.StudySwapEngine;
import controller.swap.StudySwapPanelController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.StringHolder;
import model.User;
import model.swap.CourseModel;
import view.DialogForm;
import view.SuccessPanel;

public class StudySwapPanel extends javax.swing.JPanel {

    // <editor-fold defaultstate="collapsed" desc="Table Models">
    DefaultTableModel slotModel = new DefaultTableModel(new Object[] {"Available Slots"}, 0) {
        @Override
        public boolean isCellEditable(int column, int row) {
            return false;
        }
    };
    DefaultTableModel teachModel = new DefaultTableModel(new Object[] {"Want to teach"}, 0) {
        @Override
        public boolean isCellEditable(int column, int row) {
            return false;
        }
    };
    DefaultTableModel learnModel = new DefaultTableModel(new Object[] {"Want to learn"}, 0) {
        @Override
        public boolean isCellEditable(int column, int row) {
            return false;
        }
    };
    DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Runnable and Thread Variables">
    Runnable loadSlotProcess = () -> {
        slotModel.setRowCount(0);
        StudySwapPanelController.getSlots(User.getUser().getId()).forEach((slot) -> {
            slotModel.addRow(slot);
        });
    };
    Runnable loadWantsToTeachProcess = () -> {
        teachModel.setRowCount(0);
        StudySwapPanelController.getTeachObjects(User.getUser().getId()).forEach((teach) -> {
            teachModel.addRow(teach);
        });
    };
    Runnable loadWantsToLearnProcess = new Runnable() {
        @Override
        public void run() {
            learnModel.setRowCount(0);
            cboLearnCourseFilter.removeAllItems();
            StudySwapPanelController.getLearnObjects(User.getUser().getId()).forEach((courseCode) -> {
                learnModel.addRow(new Object[] {courseCode});
                cboLearnCourseFilter.addItem(courseCode);
            });
        }
    };
    Runnable insertSlotProcess = new Runnable() {
        @Override
        public void run() {
            if (StudySwapPanelController.insertSlot(parentFrame, parentDialog, User.getUser().getId(), 
                    cboDay.getSelectedItem().toString(), cboTime.getSelectedItem().toString())) {
                loadAvailableSlots();
            }
        }
    };
    Runnable insertWantsToTeachProcess = new Runnable() {
        @Override
        public void run() {
            if (StudySwapPanelController.insertTeach(parentFrame, parentDialog, User.getUser().getId(), (Course) cboTeachCourse.getSelectedItem())) {
                loadWantsToTeach();
            }
        }
    };
    Runnable insertWantsToLearnProcess = new Runnable() {
        @Override
        public void run() {
            if (StudySwapPanelController.insertLearn(parentFrame, parentDialog, User.getUser().getId(), (Course) cboLearnCourse.getSelectedItem())) {
                loadWantsToLearn();
            }
        }
    };
    Runnable deleteSlotProcess = new Runnable() {
        @Override
        public void run() {
            if (StudySwapPanelController.deleteSlot(parentFrame, parentDialog, User.getUser().getId(), (StringHolder) tableSlot.getValueAt(tableSlotSelectedRow, 0))) {
                slotModel.removeRow(tableSlotSelectedRow);
            }
        }
    };
    Runnable deleteWantsToTeachProcess = new Runnable() {
        @Override
        public void run() {
            if (StudySwapPanelController.deleteTeach(parentFrame, parentDialog, User.getUser().getId(), (String) tableTeach.getValueAt(tableTeachSelectedRow, 0))) {
                teachModel.removeRow(tableTeachSelectedRow);
            }
        }
    };
    Runnable deleteWantsToLearnProcess = new Runnable() {
        @Override
        public void run() {
            if (StudySwapPanelController.deleteLearn(parentFrame, parentDialog, User.getUser().getId(), (String) tableLearn.getValueAt(tableLearnSelectedRow, 0))) {
                learnModel.removeRow(tableLearnSelectedRow);
                cboLearnCourseFilter.removeItemAt(tableLearnSelectedRow);
            }
        }
    };
    // <editor-fold defaultstate="collapsed" desc="Old">
//    Runnable insertWantsToTeachProcess = new Runnable() {
//        @Override
//        public void run() {
//            String teachTime = StudySlotManager.convertToMilitaryTime(cboTeachTime.getSelectedItem().toString());
//            String insertStudySlotQuery = String.format("INSERT INTO study_slot " +
//                    "SELECT * FROM (SELECT ((SELECT IFNULL (MAX(slot_id), -1) FROM study_slot AS current_study_slot_state) + 1), '%s', %d, '%s') AS new_study_slot " +
//                    "WHERE NOT EXISTS (SELECT * FROM study_slot WHERE course_code = '%s' AND slot_day = %d AND slot_time = '%s')",
//                    ((Course) cboTeachCourse.getSelectedItem()).getCourseCode(), cboTeachDay.getSelectedIndex(), teachTime, ((Course) cboTeachCourse.getSelectedItem()).getCourseCode(), cboTeachDay.getSelectedIndex(), teachTime);
//            String insertWantsToTeachQuery = String.format("INSERT INTO wants_to_teach VALUES (%d, (SELECT slot_id FROM study_slot WHERE course_code = '%s' AND slot_day = %d AND slot_time = '%s'))", User.getUser().getId(), ((Course) cboTeachCourse.getSelectedItem()).getCourseCode(), cboTeachDay.getSelectedIndex(), teachTime);
//                        
//            if (Database.updateWith(insertStudySlotQuery) && Database.updateWith(insertWantsToTeachQuery)) {
//                teachModel.addRow(new Object[] {((Course) cboTeachCourse.getSelectedItem()).getCourseCode() + " (" + StudySlotManager.getShortNameOfDay(cboTeachDay.getSelectedIndex()) + " - " + cboTeachTime.getSelectedItem().toString() + ")"});
////                (loadWantsToTeachThread = new Thread(loadWantsToTeachThread)).start();
////                SuccessPanel successPanel = new SuccessPanel("Updated wants to teach list successfully!");
////                DialogForm dialogForm = new DialogForm(null, true, successPanel, "Successfull", true, true, true);
////                dialogForm.setVisible(true);
//            } else {
//                ErrorPanel errorPanel = new ErrorPanel("An error occured!");
//                if (parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
//                else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
//            }
//        }
//    };
//    Runnable insertWantsToLearnProcess = new Runnable() {
//        @Override
//        public void run() {
//            String learnTime = StudySlotManager.convertToMilitaryTime(cboLearnTime.getSelectedItem().toString());
//            String insertStudySlotQuery = String.format("INSERT INTO study_slot " +
//                    "SELECT * FROM (SELECT ((SELECT IFNULL (MAX(slot_id), -1) FROM study_slot AS current_study_slot_state) + 1), '%s', %d, '%s') AS new_study_slot " +
//                    "WHERE NOT EXISTS (SELECT * FROM study_slot WHERE course_code = '%s' AND slot_day = %d AND slot_time = '%s')",
//                    ((Course) cboLearnCourse.getSelectedItem()).getCourseCode(), cboLearnDay.getSelectedIndex(), learnTime, ((Course) cboLearnCourse.getSelectedItem()).getCourseCode(), cboLearnDay.getSelectedIndex(), learnTime);
//            String insertWantsToLearnQuery = String.format("INSERT INTO wants_to_learn VALUES (%d, (SELECT slot_id FROM study_slot WHERE course_code = '%s' AND slot_day = %s AND slot_time = '%s'))", User.getUser().getId(), ((Course) cboLearnCourse.getSelectedItem()).getCourseCode(), cboLearnDay.getSelectedIndex(), learnTime);
//                        
//            if (Database.updateWith(insertStudySlotQuery) && Database.updateWith(insertWantsToLearnQuery)) {
////                learnModel.addRow(new Object[] {cboLearnCourse.getSelectedItem().toString() + " (" + StudySlotManager.getShortNameOfDay(cboLearnDay.getSelectedIndex()) + " - " + cboLearnTime.getSelectedItem().toString() + ")"});
//                (loadWantsToLearnThread = new Thread(loadWantsToLearnProcess)).start();
////                SuccessPanel successPanel = new SuccessPanel("Updated wants to learn list successfully!");
////                DialogForm dialogForm = new DialogForm(null, true, successPanel, "Successfull", true, true, true);
////                dialogForm.setVisible(true);
//            } else {
//                ErrorPanel errorPanel = new ErrorPanel("An error occured!");
//                if(parentDialog == null) new DialogForm(parentFrame, true, errorPanel, "Failed", true, true, true).setVisible(true);
//                else new DialogForm(parentDialog, true, errorPanel, "Failed", true, true, true).setVisible(true);
//            }
//        }
//    };
//    Runnable loadWantsToTeachProcess = new Runnable() {
//        @Override
//        public void run() {
//            String extractWantsToTeachQuery = "SELECT course_code, slot_day, slot_time FROM wants_to_teach INNER JOIN study_slot ON study_slot.slot_id = wants_to_teach.slot_id WHERE student_id = " + User.getUser().getId() + " ORDER BY course_code, slot_day, slot_time";
//            try {
//                ResultSet resultWantsToTeach = Database.getResultOf(extractWantsToTeachQuery);
//                teachModel.setRowCount(0);
//                while (resultWantsToTeach.next()) {
//                    String courseCode = resultWantsToTeach.getString("course_code");
//                    Time slotTime = resultWantsToTeach.getTime("slot_time");
//                    int slotDay = resultWantsToTeach.getInt("slot_day");
//                    
//                    teachModel.addRow(new Object[] {String.format("%s (%s - %tI:%<tM %<Tp)", courseCode, StudySlotManager.getShortNameOfDay(slotDay), slotTime)});
//                }
//            } catch (SQLException ex) {
//                System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
//            }
//        }
//    };
//    Runnable loadWantsToLearnProcess = new Runnable() {
//        @Override
//        public void run() {
//            String extractWantsToLearnQuery = "SELECT study_slot.slot_id, course_code, slot_day, slot_time FROM wants_to_learn INNER JOIN study_slot ON study_slot.slot_id = wants_to_learn.slot_id WHERE student_id = " + User.getUser().getId() + " ORDER BY course_code, slot_day, slot_time";
//            try {
//                ResultSet resultWantsToLearn = Database.getResultOf(extractWantsToLearnQuery);
//                learnModel.setRowCount(0);
//                cboLearnCourseFilter.removeAllItems();
//                while (resultWantsToLearn.next()) {
//                    String courseCode = resultWantsToLearn.getString("course_code");
//                    Time slotTime = resultWantsToLearn.getTime("slot_time");
//                    int slotDay = resultWantsToLearn.getInt("slot_day");
//                    int slotId = resultWantsToLearn.getInt("slot_id");
//                    
//                    StudySlot studySlot = new StudySlot(slotId, courseCode, StudySlotManager.getShortNameOfDay(slotDay), slotTime);
////                    String studySlot = String.format("%s (%s - %tI:%<tM %<Tp)", courseCode, StudySlotManager.getShortNameOfDay(slotDay), slotTime);
//                    learnModel.addRow(new Object[] {studySlot.toString()});
//                    cboLearnCourseFilter.addItem(studySlot);
//                }
//            } catch (SQLException ex) {
//                System.out.println("#" + ex.getErrorCode() + ": " + ex.getMessage() + " (getConnection())");
//            }
//        }
//    };
    
//    Runnable deleteWantsToTeachProcess = new Runnable() {
//        @Override
//        public void run() {
//            if (Database.updateWith(deleteWantsToTeachQuery)) {
//                ((DefaultTableModel) tableTeach.getModel()).removeRow(tableTeachSelectedRow);
//            }
//        }
//    };
//    Runnable deleteWantsToLearnProcess = new Runnable() {
//        @Override
//        public void run() {
//            if (Database.updateWith(deleteWantsToLearnQuery)) {
//                ((DefaultTableModel) tableLearn.getModel()).removeRow(tableLearnSelectedRow);
//                cboLearnCourseFilter.removeItemAt(tableLearnSelectedRow);
//            }
//        }
//    };
    // </editor-fold>
    Runnable runStudySwapProcess = new Runnable() {
        @Override
        public void run() {
            panelResult.removeAll();
            StudySwapEngine studySwapEngine = new StudySwapEngine();
            int matches = 0;
            for (StudySwapCard card : studySwapEngine.runStudySwap(cboLearnCourseFilter.getSelectedItem().toString())) {
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
            if(parentDialog == null) new DialogForm(parentFrame, true, successPanel, "Operation complete", true, true, true).setVisible(true);
            else new DialogForm(parentDialog, true, successPanel, "Operation complete", true, true, true).setVisible(true);
        }
    };
    Thread insertSlotThread, insertWantsToTeachThread, insertWantsToLearnThread, 
            loadSlotThread, loadWantsToTeachThread, loadWantsToLearnThread, 
            deleteSlotThread, deleteWantsToTeachThread, deleteWantsToLearnThread,
            runStudySwapThread;
    // </editor-fold>
    
    int tableSlotSelectedRow, tableTeachSelectedRow, tableLearnSelectedRow;
    
    Frame parentFrame;
    Dialog parentDialog;
    
    public StudySwapPanel() {
        initComponents();
        CourseModel.fillCourseCode(cboTeachCourse);
        CourseModel.fillCourseCode(cboLearnCourse);
        tableSlot.setModel(slotModel);
        tableTeach.setModel(teachModel);
        tableLearn.setModel(learnModel);
        tableSlot.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        tableTeach.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        tableLearn.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        scrollSlot.getViewport().setBackground(new Color(80, 80, 80));
        scrollTeach.getViewport().setBackground(new Color(80, 80, 80));
        scrollLearn.getViewport().setBackground(new Color(80, 80, 80));
        headerRenderer.setBackground(new Color(50, 50, 50));
        headerRenderer.setForeground(Color.LIGHT_GRAY);
        loadAvailableSlots();
        loadWantsToTeach();
        loadWantsToLearn();
    }
        
    @Override
    public void addNotify() {
        super.addNotify();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) parentDialog = (Dialog) window;
        else parentFrame = (Frame) window;
    }
    
    private void loadAvailableSlots() {
        if (loadSlotThread == null || loadSlotThread.getState() == Thread.State.TERMINATED) (loadSlotThread = new Thread(loadSlotProcess)).start();
    }
    
    private void loadWantsToTeach() {
        if (loadWantsToTeachThread == null || loadWantsToTeachThread.getState() == Thread.State.TERMINATED) (loadWantsToTeachThread = new Thread(loadWantsToTeachProcess)).start();
    }
    
    private void loadWantsToLearn() {
        if (loadWantsToLearnThread == null || loadWantsToLearnThread.getState() == Thread.State.TERMINATED) (loadWantsToLearnThread = new Thread(loadWantsToLearnProcess)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSidebar = new javax.swing.JPanel();
        scrollSlot = new javax.swing.JScrollPane();
        tableSlot = new javax.swing.JTable();
        cboDay = new javax.swing.JComboBox<>();
        cboTime = new javax.swing.JComboBox<>();
        btnAddSlot = new javax.swing.JButton();
        scrollTeach = new javax.swing.JScrollPane();
        tableTeach = new javax.swing.JTable();
        cboTeachCourse = new javax.swing.JComboBox<>();
        btnAddTeach = new javax.swing.JButton();
        scrollLearn = new javax.swing.JScrollPane();
        tableLearn = new javax.swing.JTable();
        cboLearnCourse = new javax.swing.JComboBox<>();
        btnAddLearn = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();
        cboLearnCourseFilter = new javax.swing.JComboBox<>();
        btnFind = new javax.swing.JButton();
        scrollResult = new javax.swing.JScrollPane();
        panelResult = new javax.swing.JPanel();
        btnRequest = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 100, 150));

        panelSidebar.setBackground(new java.awt.Color(0, 70, 120));
        panelSidebar.setPreferredSize(new java.awt.Dimension(207, 415));

        tableSlot.setBackground(new java.awt.Color(80, 80, 80));
        tableSlot.setForeground(new java.awt.Color(255, 255, 255));
        tableSlot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Available Slots"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSlot.setSelectionBackground(new java.awt.Color(255, 204, 51));
        tableSlot.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableSlot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSlotMouseClicked(evt);
            }
        });
        scrollSlot.setViewportView(tableSlot);
        if (tableSlot.getColumnModel().getColumnCount() > 0) {
            tableSlot.getColumnModel().getColumn(0).setResizable(false);
        }

        cboDay.setBackground(new java.awt.Color(0, 102, 153));
        cboDay.setForeground(new java.awt.Color(204, 204, 204));
        cboDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri" }));

        cboTime.setBackground(new java.awt.Color(0, 102, 153));
        cboTime.setForeground(new java.awt.Color(204, 204, 204));
        cboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00 AM", "09:30 AM", "11:00 AM", "12:30 PM", "02:00 PM", "03:30 PM", "05:00 PM" }));

        btnAddSlot.setBackground(new java.awt.Color(0, 102, 153));
        btnAddSlot.setForeground(new java.awt.Color(204, 204, 204));
        btnAddSlot.setText("+");
        btnAddSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSlotActionPerformed(evt);
            }
        });

        tableTeach.setBackground(new java.awt.Color(80, 80, 80));
        tableTeach.setForeground(new java.awt.Color(255, 255, 255));
        tableTeach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Want to teach"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTeach.setSelectionBackground(new java.awt.Color(255, 204, 51));
        tableTeach.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableTeach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTeachMouseClicked(evt);
            }
        });
        scrollTeach.setViewportView(tableTeach);
        if (tableTeach.getColumnModel().getColumnCount() > 0) {
            tableTeach.getColumnModel().getColumn(0).setResizable(false);
        }

        cboTeachCourse.setBackground(new java.awt.Color(0, 102, 153));
        cboTeachCourse.setForeground(new java.awt.Color(204, 204, 204));

        btnAddTeach.setBackground(new java.awt.Color(0, 102, 153));
        btnAddTeach.setForeground(new java.awt.Color(204, 204, 204));
        btnAddTeach.setText("+");
        btnAddTeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTeachActionPerformed(evt);
            }
        });

        tableLearn.setBackground(new java.awt.Color(80, 80, 80));
        tableLearn.setForeground(new java.awt.Color(255, 255, 255));
        tableLearn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Want to Learn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLearn.setSelectionBackground(new java.awt.Color(255, 204, 51));
        tableLearn.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableLearn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLearnMouseClicked(evt);
            }
        });
        scrollLearn.setViewportView(tableLearn);
        if (tableLearn.getColumnModel().getColumnCount() > 0) {
            tableLearn.getColumnModel().getColumn(0).setResizable(false);
        }

        cboLearnCourse.setBackground(new java.awt.Color(0, 102, 153));
        cboLearnCourse.setForeground(new java.awt.Color(204, 204, 204));

        btnAddLearn.setBackground(new java.awt.Color(0, 102, 153));
        btnAddLearn.setForeground(new java.awt.Color(204, 204, 204));
        btnAddLearn.setText("+");
        btnAddLearn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLearnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scrollTeach, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addComponent(cboTeachCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddTeach))
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addComponent(cboDay, 0, 64, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddSlot))
                    .addComponent(scrollLearn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addComponent(cboLearnCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddLearn)))
                .addContainerGap())
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSlot, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSlot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTeach, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTeachCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTeach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollLearn, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLearnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddLearn))
                .addContainerGap())
        );

        panelContent.setBackground(new java.awt.Color(0, 100, 150));

        panelSearch.setBackground(new java.awt.Color(0, 100, 150));

        cboLearnCourseFilter.setBackground(new java.awt.Color(0, 70, 120));
        cboLearnCourseFilter.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cboLearnCourseFilter.setForeground(new java.awt.Color(204, 204, 204));

        btnFind.setBackground(new java.awt.Color(0, 51, 102));
        btnFind.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(204, 204, 204));
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cboLearnCourseFilter, 0, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addGap(0, 0, 0))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLearnCourseFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addContainerGap())
        );

        scrollResult.setBackground(new java.awt.Color(0, 100, 150));
        scrollResult.setBorder(null);
        scrollResult.getVerticalScrollBar().setUnitIncrement(16);

        panelResult.setBackground(new java.awt.Color(0, 100, 150));
        panelResult.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        panelResult.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        scrollResult.setViewportView(panelResult);

        btnRequest.setBackground(new java.awt.Color(0, 51, 102));
        btnRequest.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnRequest.setForeground(new java.awt.Color(204, 204, 204));
        btnRequest.setText("Request");

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollResult)
                    .addComponent(btnRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRequest)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (runStudySwapThread == null || runStudySwapThread.getState() == Thread.State.TERMINATED) (runStudySwapThread = new Thread(runStudySwapProcess)).start();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddTeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTeachActionPerformed
        if (insertWantsToTeachThread == null || insertWantsToTeachThread.getState() == Thread.State.TERMINATED) (insertWantsToTeachThread = new Thread(insertWantsToTeachProcess)).start();
    }//GEN-LAST:event_btnAddTeachActionPerformed

    private void btnAddLearnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLearnActionPerformed
        if (insertWantsToLearnThread == null || insertWantsToLearnThread.getState() == Thread.State.TERMINATED) (insertWantsToLearnThread = new Thread(insertWantsToLearnProcess)).start();
    }//GEN-LAST:event_btnAddLearnActionPerformed

    private void btnAddSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSlotActionPerformed
        if (insertSlotThread == null || insertSlotThread.getState() == Thread.State.TERMINATED) (insertSlotThread = new Thread(insertSlotProcess)).start();
    }//GEN-LAST:event_btnAddSlotActionPerformed

    private void tableSlotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSlotMouseClicked
        if (evt.getClickCount() == 2) {
            tableSlotSelectedRow = tableSlot.getSelectedRow();
            if (deleteSlotThread == null || deleteSlotThread.getState() == Thread.State.TERMINATED) (deleteSlotThread = new Thread(deleteSlotProcess)).start();
        }
    }//GEN-LAST:event_tableSlotMouseClicked

    private void tableTeachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTeachMouseClicked
        if (evt.getClickCount() == 2) {
            tableTeachSelectedRow = tableTeach.getSelectedRow();
            if (deleteWantsToTeachThread == null || deleteWantsToTeachThread.getState() == Thread.State.TERMINATED) (deleteWantsToTeachThread = new Thread(deleteWantsToTeachProcess)).start();
        }
    }//GEN-LAST:event_tableTeachMouseClicked

    private void tableLearnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLearnMouseClicked
        if (evt.getClickCount() == 2) {
            tableLearnSelectedRow = tableLearn.getSelectedRow();
            if (deleteWantsToLearnThread == null || deleteWantsToLearnThread.getState() == Thread.State.TERMINATED) (deleteWantsToLearnThread = new Thread(deleteWantsToLearnProcess)).start();
        }
    }//GEN-LAST:event_tableLearnMouseClicked

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLearn;
    private javax.swing.JButton btnAddSlot;
    private javax.swing.JButton btnAddTeach;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnRequest;
    private javax.swing.JComboBox<String> cboDay;
    private javax.swing.JComboBox<Course> cboLearnCourse;
    private javax.swing.JComboBox<String> cboLearnCourseFilter;
    private javax.swing.JComboBox<Course> cboTeachCourse;
    private javax.swing.JComboBox<String> cboTime;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelResult;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JScrollPane scrollLearn;
    private javax.swing.JScrollPane scrollResult;
    private javax.swing.JScrollPane scrollSlot;
    private javax.swing.JScrollPane scrollTeach;
    private javax.swing.JTable tableLearn;
    private javax.swing.JTable tableSlot;
    private javax.swing.JTable tableTeach;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
