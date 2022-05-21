
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author MUHAMMEDERENŞEKKELİ
 */
public class analysisCostProfitFrontEnd extends javax.swing.JFrame {

    private analysisCostProfit anpro=new analysisCostProfit();
    private ProductOperations pr=new ProductOperations();
   
    public analysisCostProfitFrontEnd() {
        initComponents();
        getProductAnalysis();
    }
    
    public void inject(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analysisCostProfitFrontEnd().setVisible(true);
            }
        });
    }
    
    //Ürünlerin Datasını Alıp Tabloya Bastıran Fonksiyon
    public void getProductAnalysis(){
       ArrayList<Product> prList=pr.getProductList();
       ArrayList<Integer> prProfit=anpro.getProfitOfProduct();
       ArrayList<Float> prProfitRate=anpro.getProfitRateOfProduct();
       ArrayList<String> prCommon=anpro.commentProfitRate(prProfitRate);
        DefaultTableModel tabel=(DefaultTableModel) profitTable.getModel();
        int i=0;
        for(Product p : prList){
            String[] tmp=new String[5];
            tmp[0]=p.name;
            tmp[1]=priceFormatter(prProfit.get(i));
            tmp[2]=String.format("%.2f", prProfitRate.get(i));
            tmp[3]=priceFormatter(p.marketPrice);
            tmp[4]=prCommon.get(i);
            tabel.addRow(tmp);
            i++;
        }
    }
    
    private String priceFormatter(double price){
        Locale locale = new Locale("tr", "TR");
        Currency liras = Currency.getInstance(locale);
        NumberFormat lirasFormat = NumberFormat.getCurrencyInstance(locale);

        return lirasFormat.format(price);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        profitTable = new javax.swing.JTable();
        createExcel = new javax.swing.JButton();
        closeTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kar Analizi");
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
            profitTable.getColumnModel().getColumn(4).setPreferredWidth(750);
        }

        createExcel.setText("Excel Oluştur");
        createExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createExcelActionPerformed(evt);
            }
        });

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
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(517, 517, 517)
                .addComponent(createExcel)
                .addGap(75, 75, 75)
                .addComponent(closeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createExcel)
                    .addComponent(closeTable))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void createExcelActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            CSVExporter.jtExportResultSetWithDialog(this, profitTable, true);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ListRefundedProductsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                           

    private void closeTableActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //setVisible(false);
        this.dispose();
    }                                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton closeTable;
    private javax.swing.JButton createExcel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable profitTable;
    // End of variables declaration                   
}
