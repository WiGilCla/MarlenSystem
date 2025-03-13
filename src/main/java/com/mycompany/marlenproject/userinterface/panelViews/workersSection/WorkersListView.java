/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.data.forms.worker.dataFormsWorker;
import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class WorkersListView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;
    private final List<Worker> WORKER_LIST;
    private final List<Worker> WORKER_LIST_FILTER = new ArrayList<>();

    private void uploadInfoToTable(List<Worker> ListWorker) {
        DefaultTableModel modelTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String tableHead[] = {"N°", "Dni", "Nombre", "Apellido", "Cargo", "Estado"};
        modelTable.setColumnIdentifiers(tableHead);

        if (!ListWorker.isEmpty()) {

            int count = 0;
            for (Worker worker : ListWorker) {

                String status = (worker.isIsActive())
                        ? dataFormsWorker.STATUS[dataFormsWorker.getIndexStatusActive()] : dataFormsWorker.STATUS[dataFormsWorker.getIndexStatusNoActive()];

                Object[] workersObject = {(count + 1),
                    worker.getPerson().getIdentificationNumber(),
                    worker.getPerson().getFirstName(),
                    worker.getPerson().getFirstLastName(),
                    worker.getPosition(),
                    InputValidator.capitalizedString(status)};

                modelTable.addRow(workersObject);
                count++;
            }
        }

        WorkersTable.setModel(modelTable);
        WorkersTable.getTableHeader().setFont(new java.awt.Font("Georgia", 1, 14));
        WorkersTable.getTableHeader().setForeground(Colors.PRIMARY_950);
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
        btnSearch = new javax.swing.JButton();
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

        setBackground(Colors.PRIMARY_200);
        setPreferredSize(new java.awt.Dimension(970, 576));

        FilterPanel.setBackground(Colors.PRIMARY_200);
        FilterPanel.setPreferredSize(new java.awt.Dimension(958, 100));

        Filter1Panel.setBackground(Colors.PRIMARY_200);
        Filter1Panel.setPreferredSize(new java.awt.Dimension(467, 88));

        textFilter1Panel.setBackground(Colors.PRIMARY_200);
        textFilter1Panel.setPreferredSize(new java.awt.Dimension(350, 76));

        txtSearchWorker.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSearchWorker.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearchWorker.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout textFilter1PanelLayout = new javax.swing.GroupLayout(textFilter1Panel);
        textFilter1Panel.setLayout(textFilter1PanelLayout);
        textFilter1PanelLayout.setHorizontalGroup(
            textFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFilter1PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtSearchWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        textFilter1PanelLayout.setVerticalGroup(
            textFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFilter1PanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtSearchWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        ButtonFilter1Panel.setBackground(Colors.PRIMARY_200);
        ButtonFilter1Panel.setPreferredSize(new java.awt.Dimension(99, 76));

        btnSearch.setBackground(Colors.PRIMARY_100);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconLupe.png"))); // NOI18N
        btnSearch.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonFilter1PanelLayout = new javax.swing.GroupLayout(ButtonFilter1Panel);
        ButtonFilter1Panel.setLayout(ButtonFilter1PanelLayout);
        ButtonFilter1PanelLayout.setHorizontalGroup(
            ButtonFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonFilter1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
        );
        ButtonFilter1PanelLayout.setVerticalGroup(
            ButtonFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonFilter1PanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter1PanelLayout = new javax.swing.GroupLayout(Filter1Panel);
        Filter1Panel.setLayout(Filter1PanelLayout);
        Filter1PanelLayout.setHorizontalGroup(
            Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        Filter2Panel.setBackground(Colors.PRIMARY_200);
        Filter2Panel.setPreferredSize(new java.awt.Dimension(234, 88));

        CBoxFilter2Panel.setBackground(Colors.PRIMARY_200);
        CBoxFilter2Panel.setPreferredSize(new java.awt.Dimension(116, 76));

        sltPositionFilter.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltPositionFilter.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsWorker.JOB_TITLE));
        sltPositionFilter.setPreferredSize(new java.awt.Dimension(104, 30));

        javax.swing.GroupLayout CBoxFilter2PanelLayout = new javax.swing.GroupLayout(CBoxFilter2Panel);
        CBoxFilter2Panel.setLayout(CBoxFilter2PanelLayout);
        CBoxFilter2PanelLayout.setHorizontalGroup(
            CBoxFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CBoxFilter2PanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(sltPositionFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        CBoxFilter2PanelLayout.setVerticalGroup(
            CBoxFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBoxFilter2PanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(sltPositionFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        LbFilter2Panel.setBackground(Colors.PRIMARY_200);
        LbFilter2Panel.setPreferredSize(new java.awt.Dimension(100, 76));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setForeground(Colors.PRIMARY_950);
        jLabel1.setText("Posición:");
        jLabel1.setPreferredSize(new java.awt.Dimension(88, 30));

        javax.swing.GroupLayout LbFilter2PanelLayout = new javax.swing.GroupLayout(LbFilter2Panel);
        LbFilter2Panel.setLayout(LbFilter2PanelLayout);
        LbFilter2PanelLayout.setHorizontalGroup(
            LbFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbFilter2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LbFilter2PanelLayout.setVerticalGroup(
            LbFilter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbFilter2PanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter2PanelLayout = new javax.swing.GroupLayout(Filter2Panel);
        Filter2Panel.setLayout(Filter2PanelLayout);
        Filter2PanelLayout.setHorizontalGroup(
            Filter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbFilter2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CBoxFilter2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
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

        Filter3Panel.setBackground(Colors.PRIMARY_200);
        Filter3Panel.setPreferredSize(new java.awt.Dimension(233, 88));

        CBoxFilter3Panel.setBackground(Colors.PRIMARY_200);
        CBoxFilter3Panel.setPreferredSize(new java.awt.Dimension(115, 76));

        sltStatusFilter.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltStatusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsWorker.STATUS));
        sltStatusFilter.setPreferredSize(new java.awt.Dimension(104, 30));

        javax.swing.GroupLayout CBoxFilter3PanelLayout = new javax.swing.GroupLayout(CBoxFilter3Panel);
        CBoxFilter3Panel.setLayout(CBoxFilter3PanelLayout);
        CBoxFilter3PanelLayout.setHorizontalGroup(
            CBoxFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBoxFilter3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sltStatusFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CBoxFilter3PanelLayout.setVerticalGroup(
            CBoxFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBoxFilter3PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(sltStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lbFilter3Panel.setBackground(Colors.PRIMARY_200);
        lbFilter3Panel.setPreferredSize(new java.awt.Dimension(100, 76));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setForeground(Colors.PRIMARY_950);
        jLabel2.setText("Estado:");
        jLabel2.setPreferredSize(new java.awt.Dimension(88, 30));

        javax.swing.GroupLayout lbFilter3PanelLayout = new javax.swing.GroupLayout(lbFilter3Panel);
        lbFilter3Panel.setLayout(lbFilter3PanelLayout);
        lbFilter3PanelLayout.setHorizontalGroup(
            lbFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbFilter3PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        lbFilter3PanelLayout.setVerticalGroup(
            lbFilter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbFilter3PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter3PanelLayout = new javax.swing.GroupLayout(Filter3Panel);
        Filter3Panel.setLayout(Filter3PanelLayout);
        Filter3PanelLayout.setHorizontalGroup(
            Filter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFilter3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CBoxFilter3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
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
                .addComponent(Filter1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Filter2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Filter3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
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

        TablePanel.setBackground(Colors.PRIMARY_200);
        TablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TablePanel.setMinimumSize(new java.awt.Dimension(958, 100));
        TablePanel.setPreferredSize(new java.awt.Dimension(958, 352));

        WorkersTable.setBackground(Colors.PRIMARY_100);
        WorkersTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        WorkersTable.setForeground(Colors.PRIMARY_950);
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
        WorkersTable.setGridColor(new java.awt.Color(204, 204, 204));
        WorkersTable.setRowHeight(25);
        WorkersTable.setRowMargin(5);
        WorkersTable.setSelectionBackground(Colors.PRIMARY_300);
        WorkersTable.setShowGrid(true);
        WorkersTable.setShowVerticalLines(false);
        WorkersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WorkersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(WorkersTable);
        if (WorkersTable.getColumnModel().getColumnCount() > 0) {
            WorkersTable.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            WorkersTable.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            WorkersTable.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            WorkersTable.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 903, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String textFilter = InputValidator.removeStringBlanks(txtSearchWorker.getText()).toLowerCase();
        String positionFilter = sltPositionFilter.getSelectedItem().toString();
        String statusFilterActive = sltStatusFilter.getSelectedItem().toString();
        boolean statusFilter = sltStatusFilter.getSelectedIndex() == dataFormsWorker.getIndexStatusActive();
        boolean is_conjunction = InputValidator.checkComboBox(positionFilter) && InputValidator.checkComboBox(statusFilterActive);
        this.WORKER_LIST_FILTER.clear();

        if (textFilter.isBlank() && !InputValidator.checkComboBox(positionFilter) && !InputValidator.checkComboBox(statusFilterActive)) {
            uploadInfoToTable(this.WORKER_LIST);
            return;
        }

        for (Worker worker : this.WORKER_LIST) {

            boolean matchesText = !textFilter.isBlank() && (worker.getPerson().getIdentificationNumber().toLowerCase().contains(textFilter)
                    || worker.getPerson().getFirstName().toLowerCase().contains(textFilter)
                    || worker.getPerson().getFirstLastName().toLowerCase().contains(textFilter));

            boolean matchesPosition = worker.getPosition().equalsIgnoreCase(positionFilter);
            boolean matchesStatus = worker.isIsActive() == statusFilter;
            boolean condition = is_conjunction ? (matchesText || (matchesPosition && matchesStatus)) : (matchesText || matchesPosition || matchesStatus);

            if (condition) {
                WORKER_LIST_FILTER.add(worker);
            }

        }

        //uploadInfoToTable(this.WORKER_LIST_FILTER.isEmpty() ? this.WORKER_LIST : this.WORKER_LIST_FILTER);
        uploadInfoToTable(this.WORKER_LIST_FILTER);
        sltPositionFilter.setSelectedIndex(dataFormsWorker.getNoOneOptionSelected());
        sltStatusFilter.setSelectedIndex(dataFormsWorker.getNoOneOptionSelected());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void WorkersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WorkersTableMouseClicked
        if (WorkersTable.getRowCount() > 0) {
            if (WorkersTable.getSelectedRow() != -1) {
                List<Worker> workers = new ArrayList<>();
                if (!this.WORKER_LIST_FILTER.isEmpty()) {
                    workers = this.WORKER_LIST_FILTER;
                } else {
                    workers = this.WORKER_LIST;
                }
                WorkersInformationView workersInformationView = new WorkersInformationView(this.PRINCIPALJFRAME, workers,
                        (Integer.parseInt(String.valueOf(WorkersTable.getValueAt(WorkersTable.getSelectedRow(), 0))) - 1));

                workersInformationView.setLocation(0, 0);
                PRINCIPALJFRAME.replacePanel(workersInformationView);
            }
        }
    }//GEN-LAST:event_WorkersTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonFilter1Panel;
    private javax.swing.JPanel CBoxFilter2Panel;
    private javax.swing.JPanel CBoxFilter3Panel;
    private javax.swing.JPanel Filter1Panel;
    private javax.swing.JPanel Filter2Panel;
    private javax.swing.JPanel Filter3Panel;
    private javax.swing.JPanel FilterPanel;
    private javax.swing.JPanel LbFilter2Panel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JTable WorkersTable;
    private javax.swing.JButton btnSearch;
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
