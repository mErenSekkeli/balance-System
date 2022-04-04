import java.util.ArrayList;

/*
  @author MUHAMMEDERENŞEKKELİ
 */
public class analysisCostProfitFrontEnd extends javax.swing.JPanel {

    private analysisCostProfit anpro;
    private Product pr=new Product();
    public analysisCostProfitFrontEnd() {
        initComponents();
        getProductAnalysis();
    }

    public void getProductAnalysis(){
       ArrayList<Product> prList=pr.prepareProduct();
        
        for(Product p: prList){
            System.out.println("Ürün ID: "+p.ID);
        }
    }
    
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new analysisCostProfitFrontEnd().setVisible(true);
            }
           
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productAnalysisTable = new javax.swing.JTable();
        closeTable = new javax.swing.JButton();

        productAnalysisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün Adı", "Üründen Elde Edilen Kar", "Üründen Elde Edilen Kar Oranı", "Ürün Pazar Fiyatı", "Fiyat Önerisi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productAnalysisTable.setToolTipText("");
        productAnalysisTable.setEnabled(false);
        jScrollPane1.setViewportView(productAnalysisTable);
        if (productAnalysisTable.getColumnModel().getColumnCount() > 0) {
            productAnalysisTable.getColumnModel().getColumn(4).setPreferredWidth(450);
        }

        closeTable.setText("Kapat");
        closeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(614, Short.MAX_VALUE)
                .addComponent(closeTable)
                .addGap(602, 602, 602))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeTable)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productAnalysisTable;
    // End of variables declaration//GEN-END:variables
}
