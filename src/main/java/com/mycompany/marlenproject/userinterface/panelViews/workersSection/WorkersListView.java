/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.userinterface.AdminHome;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class WorkersListView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;
    private final List<Worker> WORKER_LIST;
    private final List<Worker> WORKER_LIST_FILTER = new ArrayList<>();
    private final ComboBoxWorkerOptions COMBO_BOX_OPTIONS = new ComboBoxWorkerOptions();
    private final CheckFields Checker = new CheckFields();

    private void uploadInfoToTable(List<Worker> ListWorker) {
        DefaultTableModel modelTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String tableHead[] = {"N°", "Dni", "Nombre", "Apellido", "Cargo", "Estado"};
        modelTable.setColumnIdentifiers(tableHead);

        if (!ListWorker.isEmpty() && ListWorker != null) {
            
            int count = 0;
            for (Worker worker : ListWorker) {

                String[] options = COMBO_BOX_OPTIONS.getStateOptions();
                String status = (worker.isIsActive())
                        ? options[COMBO_BOX_OPTIONS.getIndexStatusActive()] : options[COMBO_BOX_OPTIONS.getIndexStatusNoActive()];

                Object[] workersObject = {(count+1), worker.getPerson().getIdentificationNumber(), worker.getPerson().getFirstName(),
                    worker.getPerson().getFirstLastName(), worker.getPosition(), Checker.capitalizedString(status)};
                modelTable.addRow(workersObject);
                count++;

            }
        }
        
        WorkersTable.setModel(modelTable);
    }

    public WorkersListView(AdminHome principalJFrame, List<Worker> workers) {
        this.PRINCIPALJFRAME = principalJFrame;
        this.WORKER_LIST = workers;
        initComponents();
        uploadInfoToTable(this.WORKER_LIST);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FilterPanel = new javax.swing.JPanel();
        Filter1Panel = new javax.swing.JPanel();
        textFilter1Panel = new javax.swing.JPanel();
        txtSearchWorker = new javax.swing.JTextField();
        ButtonFilter1Panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Filter2Panel = new javax.swing.JPanel();
        CBoxFilter2Panel = new javax.swing.JPanel();
        sltPositionFilter = new javax.swing.JComboBox<>();
        LbFilter2Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Filter3Panel = new javax.swing.JPanel();
        CBoxFilter3Panel = new javax.swing.JPanel();
        sltStatusFilter = new javax.swing.JComboBox<>();
        lbFilter3Panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        WorkersTable = new javax.swing.JTable();
        ButtonsPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        setPreferredSize(new java.awt.Dimension(970, 576));

        FilterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FilterPanel.setPreferredSize(new java.awt.Dimension(958, 100));

        Filter1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Filter1Panel.setPreferredSize(new java.awt.Dimension(467, 88));

        textFilter1Panel.setPreferredSize(new java.awt.Dimension(350, 76));

        txtSearchWorker.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearchWorker.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout textFilter1PanelLayout = new javax.swing.GroupLayout(textFilter1Panel);
        textFilter1Panel.setLayout(textFilter1PanelLayout);
        textFilter1PanelLayout.setHorizontalGroup(
            textFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFilter1PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtSearchWorker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        textFilter1PanelLayout.setVerticalGroup(
            textFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFilter1PanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtSearchWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        ButtonFilter1Panel.setPreferredSize(new java.awt.Dimension(99, 76));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconLupe.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonFilter1PanelLayout = new javax.swing.GroupLayout(ButtonFilter1Panel);
        ButtonFilter1Panel.setLayout(ButtonFilter1PanelLayout);
        ButtonFilter1PanelLayout.setHorizontalGroup(
            ButtonFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonFilter1PanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        ButtonFilter1PanelLayout.setVerticalGroup(
            ButtonFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonFilter1PanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter1PanelLayout = new javax.swing.GroupLayout(Filter1Panel);
        Filter1Panel.setLayout(Filter1PanelLayout);
        Filter1PanelLayout.setHorizontalGroup(
            Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFilter1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Filter1PanelLayout.setVerticalGroup(
            Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Filter1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Filter2Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Filter2Panel.setPreferredSize(new java.awt.Dimension(234, 88));

        CBoxFilter2Panel.setPreferredSize(new java.awt.Dimension(116, 76));

        sltPositionFilter.setModel(new javax.swing.DefaultComboBoxModel<>(COMBO_BOX_OPTIONS.getPositionOptions()));
        sltPositionFilter.setPreferredSize(new java.awt.Dimension(104, 25));

        javax.swing.GroupLayout CBoxFilter2PanelLayout = new javax.swing.GroupLayout(CBoxFilter2Panel);
        CBoxFilter2Panel.setLayout(CBoxFilter2PanelLayout);
        CBoxFilter2PanelLayout.setHorizontalGroup(
            CBoxFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CBoxFilter2PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(sltPositionFilter, 0, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        CBoxFilter2PanelLayout.setVerticalGroup(
            CBoxFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBoxFilter2PanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(sltPositionFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        LbFilter2Panel.setPreferredSize(new java.awt.Dimension(100, 76));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Posición:");
        jLabel1.setPreferredSize(new java.awt.Dimension(88, 25));

        javax.swing.GroupLayout LbFilter2PanelLayout = new javax.swing.GroupLayout(LbFilter2Panel);
        LbFilter2Panel.setLayout(LbFilter2PanelLayout);
        LbFilter2PanelLayout.setHorizontalGroup(
            LbFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbFilter2PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        LbFilter2PanelLayout.setVerticalGroup(
            LbFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbFilter2PanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter2PanelLayout = new javax.swing.GroupLayout(Filter2Panel);
        Filter2Panel.setLayout(Filter2PanelLayout);
        Filter2PanelLayout.setHorizontalGroup(
            Filter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbFilter2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBoxFilter2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        Filter2PanelLayout.setVerticalGroup(
            Filter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Filter2PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(Filter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbFilter2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBoxFilter2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Filter3Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Filter3Panel.setPreferredSize(new java.awt.Dimension(233, 88));

        CBoxFilter3Panel.setPreferredSize(new java.awt.Dimension(115, 76));

        sltStatusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(COMBO_BOX_OPTIONS.getStateOptions()));
        sltStatusFilter.setPreferredSize(new java.awt.Dimension(103, 25));

        javax.swing.GroupLayout CBoxFilter3PanelLayout = new javax.swing.GroupLayout(CBoxFilter3Panel);
        CBoxFilter3Panel.setLayout(CBoxFilter3PanelLayout);
        CBoxFilter3PanelLayout.setHorizontalGroup(
            CBoxFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBoxFilter3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sltStatusFilter, 0, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        CBoxFilter3PanelLayout.setVerticalGroup(
            CBoxFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBoxFilter3PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(sltStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        lbFilter3Panel.setPreferredSize(new java.awt.Dimension(100, 76));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel2.setText("Estado:");
        jLabel2.setPreferredSize(new java.awt.Dimension(88, 25));

        javax.swing.GroupLayout lbFilter3PanelLayout = new javax.swing.GroupLayout(lbFilter3Panel);
        lbFilter3Panel.setLayout(lbFilter3PanelLayout);
        lbFilter3PanelLayout.setHorizontalGroup(
            lbFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbFilter3PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lbFilter3PanelLayout.setVerticalGroup(
            lbFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbFilter3PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter3PanelLayout = new javax.swing.GroupLayout(Filter3Panel);
        Filter3Panel.setLayout(Filter3PanelLayout);
        Filter3PanelLayout.setHorizontalGroup(
            Filter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFilter3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBoxFilter3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
        Filter3PanelLayout.setVerticalGroup(
            Filter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Filter3PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(Filter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBoxFilter3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFilter3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout FilterPanelLayout = new javax.swing.GroupLayout(FilterPanel);
        FilterPanel.setLayout(FilterPanelLayout);
        FilterPanelLayout.setHorizontalGroup(
            FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Filter1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Filter2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Filter3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FilterPanelLayout.setVerticalGroup(
            FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Filter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        FilterPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Filter1Panel, Filter2Panel, Filter3Panel});

        TablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TablePanel.setMinimumSize(new java.awt.Dimension(958, 100));
        TablePanel.setPreferredSize(new java.awt.Dimension(958, 352));

        WorkersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        WorkersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WorkersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(WorkersTable);

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addContainerGap())
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        ButtonsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonsPanel.setMinimumSize(new java.awt.Dimension(958, 100));
        ButtonsPanel.setPreferredSize(new java.awt.Dimension(958, 100));

        javax.swing.GroupLayout ButtonsPanelLayout = new javax.swing.GroupLayout(ButtonsPanel);
        ButtonsPanel.setLayout(ButtonsPanelLayout);
        ButtonsPanelLayout.setHorizontalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ButtonsPanelLayout.setVerticalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String textFilter = Checker.removeStringBlanks(txtSearchWorker.getText()).toLowerCase();
        String positionFilter = sltPositionFilter.getSelectedItem().toString();
        String statusFilterActive = sltStatusFilter.getSelectedItem().toString();
        boolean statusFilter = sltStatusFilter.getSelectedIndex() == COMBO_BOX_OPTIONS.getIndexStatusActive();
        this.WORKER_LIST_FILTER.clear();

        
        if ((!textFilter.equalsIgnoreCase("")
                || Checker.checkComboBox(positionFilter)) && Checker.checkComboBox(statusFilterActive) == false) {
            for (Worker worker : this.WORKER_LIST) {
                if ((textFilter.length() > 0 && (worker.getPerson().getIdentificationNumber().contains(textFilter)
                        || worker.getPerson().getFirstName().toLowerCase().contains(textFilter)
                        || worker.getPerson().getFirstLastName().toLowerCase().contains(textFilter)))
                        || worker.getPosition().equalsIgnoreCase(positionFilter)) {
                    WORKER_LIST_FILTER.add(worker);
                }
            }
            uploadInfoToTable(this.WORKER_LIST_FILTER);
        }else if(!textFilter.equalsIgnoreCase("")
                || Checker.checkComboBox(positionFilter) || Checker.checkComboBox(statusFilterActive)){
            for (Worker worker : this.WORKER_LIST) {
                if ((textFilter.length() > 0 && (worker.getPerson().getIdentificationNumber().contains(textFilter)
                        || worker.getPerson().getFirstName().toLowerCase().contains(textFilter)
                        || worker.getPerson().getFirstLastName().toLowerCase().contains(textFilter)))
                        || worker.getPosition().equalsIgnoreCase(positionFilter)
                        || worker.isIsActive() == statusFilter) {
                    WORKER_LIST_FILTER.add(worker);
                }
            }
            uploadInfoToTable(this.WORKER_LIST_FILTER);
        }else{
            WORKER_LIST_FILTER.clear();
            uploadInfoToTable(this.WORKER_LIST);
        }
        
        sltPositionFilter.setSelectedIndex(COMBO_BOX_OPTIONS.getNoOneOptionSelected());
        sltStatusFilter.setSelectedIndex(COMBO_BOX_OPTIONS.getNoOneOptionSelected());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void WorkersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WorkersTableMouseClicked
        if(WorkersTable.getRowCount() > 0){
            if(WorkersTable.getSelectedRow() != -1){
                WorkersInformationView workersInformationView;
                if(!this.WORKER_LIST_FILTER.isEmpty()){
                    workersInformationView = new WorkersInformationView(this.PRINCIPALJFRAME,this.WORKER_LIST_FILTER,
                            (Integer.parseInt(String.valueOf(WorkersTable.getValueAt(WorkersTable.getSelectedRow(),0))))-1);
                }else{
                    workersInformationView = new WorkersInformationView(this.PRINCIPALJFRAME,this.WORKER_LIST,
                    (Integer.parseInt(String.valueOf(WorkersTable.getValueAt(WorkersTable.getSelectedRow(),0)))-1));
                }
                
                workersInformationView.setSize(970, 576);
                workersInformationView.setLocation(0, 0);
                PRINCIPALJFRAME.replacePanel(workersInformationView);
            }
        }
    }//GEN-LAST:event_WorkersTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonFilter1Panel;
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel CBoxFilter2Panel;
    private javax.swing.JPanel CBoxFilter3Panel;
    private javax.swing.JPanel Filter1Panel;
    private javax.swing.JPanel Filter2Panel;
    private javax.swing.JPanel Filter3Panel;
    private javax.swing.JPanel FilterPanel;
    private javax.swing.JPanel LbFilter2Panel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JTable WorkersTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel lbFilter3Panel;
    private javax.swing.JComboBox<String> sltPositionFilter;
    private javax.swing.JComboBox<String> sltStatusFilter;
    private javax.swing.JPanel textFilter1Panel;
    private javax.swing.JTextField txtSearchWorker;
    // End of variables declaration//GEN-END:variables
}
