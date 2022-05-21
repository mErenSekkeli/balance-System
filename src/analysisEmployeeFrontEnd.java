
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 * @author MUHAMMEDERENŞEKKELİ
 */
public class analysisEmployeeFrontEnd extends javax.swing.JFrame {

    private EmployeeManager emp;
    private analysisEmployee anEmp;
    
    public analysisEmployeeFrontEnd() {
        initComponents();
        emp=new EmployeeManager();
        anEmp=new analysisEmployee();
        getWorkAnalysis();
    }
    
    public void inject(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analysisEmployeeFrontEnd().setVisible(true);
            }
        });
    }
    
    public void getWorkAnalysis(){
        ArrayList<String> empWorkList=anEmp.getEmpWork();
        HashMap<Integer, String> empSaleList=anEmp.getEmployeeSold();
        ArrayList<EmployeeManager> empList=emp.prepareEmployee();
        DefaultTableModel table=(DefaultTableModel) workerTable.getModel();
        int i=0;
        for(EmployeeManager e: empList){
            String[] tmp=new String[5];
            tmp[0]=Integer.toString(++i);
            tmp[1]=e.name;
            tmp[2]=Integer.toString(e.workTime);
            if(empSaleList.containsKey(e.ID)){
                tmp[3]=empSaleList.get(e.ID);
            }else{
                tmp[3]="Çalışan Satış Departmanında Çalışmamaktadır.";
            }
            tmp[4]=empWorkList.get(i-1);
            table.addRow(tmp);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workerTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        createExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        workerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Çalışan Adı", "Çalışma Zamanı", "Satış Analizi", "Devamlılık Analizi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workerTable);
        if (workerTable.getColumnModel().getColumnCount() > 0) {
            workerTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            workerTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            workerTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            workerTable.getColumnModel().getColumn(3).setPreferredWidth(450);
            workerTable.getColumnModel().getColumn(4).setPreferredWidth(450);
        }

        jButton1.setText("Kapat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        createExcel.setText("Excel Oluştur");
        createExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(createExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(createExcel)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void createExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createExcelActionPerformed
        try {
            CSVExporter.jtExportResultSetWithDialog(this, workerTable, true);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ListRefundedProductsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createExcel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workerTable;
    // End of variables declaration//GEN-END:variables
}
