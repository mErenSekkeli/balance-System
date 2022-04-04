
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
  @author MUHAMMEDERENŞEKKELİ
 */
public class analysisCostProfitFrontEnd extends javax.swing.JFrame {

    private analysisCostProfit anpro=new analysisCostProfit();
    private Product pr=new Product();
    
    public analysisCostProfitFrontEnd() {
        initComponents();
        getProductAnalysis();
    }
    
    public void getProductAnalysis(){
       ArrayList<Product> prList=pr.prepareProduct();
       ArrayList<Integer> prProfit=anpro.getProfitOfProduct();
       ArrayList<Float> prProfitRate=anpro.getProfitRateOfProduct();
       ArrayList<String> prCommon=anpro.commentProfitRate(prProfitRate);
        DefaultTableModel tabel=(DefaultTableModel) profitTable.getModel();
        int i=0;
        for(Product p : prList){
            String[] tmp=new String[5];
            tmp[0]=p.name;
            tmp[1]=prProfit.get(i).toString();
            tmp[2]=prProfitRate.get(i).toString();
            tmp[3]=Double.toString(p.marketPrice);
            tmp[4]=prCommon.get(i);
            tabel.addRow(tmp);
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        profitTable = new javax.swing.JTable();
        closeTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ürün Kar Analizleri");

        profitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün Adı", "Ürün Karı", "Ürün Kar Oranı", "Ürün Pazar Fiyatı", "Fiyat Önerisi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(profitTable);
        if (profitTable.getColumnModel().getColumnCount() > 0) {
            profitTable.getColumnModel().getColumn(4).setResizable(false);
            profitTable.getColumnModel().getColumn(4).setPreferredWidth(800);
        }

        closeTable.setText("Kapat");
        closeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(603, 603, 603))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeTable)
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTableActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(analysisCostProfitFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(analysisCostProfitFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(analysisCostProfitFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(analysisCostProfitFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analysisCostProfitFrontEnd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable profitTable;
    // End of variables declaration//GEN-END:variables
}
