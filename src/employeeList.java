
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUHAMMEDERENŞEKKELİ
 */
public class employeeList extends javax.swing.JFrame {

    private EmployeeManager emps;
    private Account acc;
    
    public employeeList() {
        initComponents();
        emps=new EmployeeManager();
        acc=new Account();
        getEmployees();
    }
    
    public void getEmployees(){
        ArrayList<EmployeeManager> empList=emps.prepareEmployee();
        ArrayList<Account> accList=this.acc.prepareAccount();
        DefaultTableModel table=(DefaultTableModel) employeeTable.getModel();

        for(EmployeeManager e: empList){
            String[] tmp=new String[5];
            for(Account a: accList){
                if(a.account_emp_id==e.ID){
                    tmp[0]=Integer.toString(e.ID);
                   tmp[1]=e.name;
                if(a.account_role==1){
                    tmp[2]="Admin";
                }else if(a.account_role==2){
                    tmp[2]="Satış Elemanı";
                }else{
                    tmp[2]="Stok Takip Elemanı";
                }
                tmp[3]=Integer.toString(e.workTime);
                Format formatter = new SimpleDateFormat("dd/MM/YYYY");
                tmp[4]=formatter.format(e.hiringTime);
                table.addRow(tmp); 
                }
                
            }
        }
        
    }
    
    public DefaultTableModel getDefaultModel() {
        return (DefaultTableModel) employeeTable.getModel();
    }
    
    public void clearTable(){
        while(getDefaultModel().getRowCount()>0){
            getDefaultModel().removeRow(0);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        createExcel = new javax.swing.JButton();
        deleteEmployee = new javax.swing.JButton();
        close = new javax.swing.JButton();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calisan Listesi");

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Çalışan ID", "Çalışan Adı", "Çalışan Rolü", "Çalışma Zamanı", "İşe Alınma Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(employeeTable);

        createExcel.setText("Excel Oluştur");
        createExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createExcelActionPerformed(evt);
            }
        });

        deleteEmployee.setText("Çalışanı Sil");
        deleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeActionPerformed(evt);
            }
        });

        close.setText("Kapat");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(deleteEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(createExcel)
                        .addGap(18, 18, 18)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createExcel)
                    .addComponent(deleteEmployee)
                    .addComponent(close)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeActionPerformed
        int row=employeeTable.getSelectedRow();
        DefaultTableModel table=(DefaultTableModel) employeeTable.getModel();
        
        
        if(currentUser.getAccount_id() == Integer.valueOf(table.getValueAt(row, 0).toString())) {
            Object[] opt={"Tamam"};
            JOptionPane.showOptionDialog(this, "Giriş yaptığınız hesabı silemezsiniz.", "Uyarı", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,opt,opt[0]);
            return;
        }
        
        if(row!=-1){
            Object[] options = { "EVET", "HAYIR" };
            int response=JOptionPane.showOptionDialog(this, "Çalışanı silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
            if(response == JOptionPane.YES_OPTION){
                String tmp=table.getValueAt(row, 0).toString();
                emps.deleteEmployee(Integer.valueOf(tmp));
                Color color=new Color(3,119,26);
                message.setForeground(color);
                message.setText("Çalışan Silindi!");
                clearTable();
                emps=new EmployeeManager();
                acc=new Account();
                getEmployees();
            }
        }else{
            Object[] opt={"Tamam"};
            int response=JOptionPane.showOptionDialog(this, "Çalışan Seçmediniz", "Uyarı", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,opt,opt[0]);
            
        }
    }//GEN-LAST:event_deleteEmployeeActionPerformed

    private void createExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createExcelActionPerformed
        try {
            CSVExporter.jtExportResultSetWithDialog(this, employeeTable, true);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ListRefundedProductsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createExcelActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton createExcel;
    private javax.swing.JButton deleteEmployee;
    private javax.swing.JTable employeeTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
