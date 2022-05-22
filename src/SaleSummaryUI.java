
import java.sql.*;
/**
 *
 * @author laptop
 */
public class SaleSummaryUI extends javax.swing.JFrame {
    private Connector db;

    /**
     * Creates new form SaleSummaryUI
     */
    public SaleSummaryUI(Connector db) {
        this.db = db;
        initComponents();
        
        fillValues();
    }
    
    private void fillValues() {
        try {
            db.preState = db.con.prepareStatement("SELECT SUM(order_items_cost) as cost_sum, SUM(order_items_price) as price_sum from order_items");
            ResultSet rs = db.preState.executeQuery();
            
            if(!rs.next()) {
                System.out.println("Unexpected error: couldnt find sum");
                return;
            }
            double costSum = rs.getDouble("cost_sum");
            double priceSum = rs.getDouble("price_sum");
            double taxSum = priceSum * 0.18;
            
            totalTax.setText(Double.toString(taxSum) + " TL");
            totalExpense.setText(Double.toString(priceSum) + " TL");
            totalExpenseNoTax.setText(Double.toString(costSum) + " TL");
            
            db.preState = db.con.prepareStatement("SELECT count(*) as count FROM order_items WHERE order_items_refunded = '0'");
            rs = db.preState.executeQuery();
            
            if(!rs.next())  {
                System.out.println("Unexpected error: couldnt find count");
                return;
            }
            
            int nonRefundedOrderCount = rs.getInt("count");
            totalNonRefundedSoldProductCount.setText(Integer.toString(nonRefundedOrderCount));
            
            db.preState = db.con.prepareStatement("SELECT count(*) as count FROM order_items WHERE order_items_refunded = '1'");
            rs = db.preState.executeQuery();
            
            if(!rs.next())  {
                System.out.println("Unexpected error: couldnt find count");
                return;
            }
            
            int refundedOrderCount = rs.getInt("count");
            totalRefundedSoldProductCount.setText(Integer.toString(refundedOrderCount));
            int totalOrderCount = refundedOrderCount + nonRefundedOrderCount;
            
            totalSoldProductCount.setText(Integer.toString(totalOrderCount));
            db.preState = db.con.prepareStatement("SELECT count(*) as count FROM employer");
            rs = db.preState.executeQuery();
            
            if(!rs.next())  {
                System.out.println("Unexpected error: couldnt find count");
                return;
            }
            
            int totalEmployeerCount = rs.getInt("count");
            workerCount.setText(Integer.toString(totalEmployeerCount));
            
            
            db.preState = db.con.prepareStatement("SELECT count(*) as count FROM accounts");
            rs = db.preState.executeQuery();
            
            if(!rs.next())  {
                System.out.println("Unexpected error: couldnt find count");
                return;
            }
            
            int totalAccountCount = rs.getInt("count");
            accountCount.setText(Integer.toString(totalAccountCount));
        } catch(SQLException e) {
            System.out.println("Unexpected error occurred.");
            System.out.println(e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalExpense = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalExpenseNoTax = new javax.swing.JLabel();
        totalTax = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalSoldProductCount = new javax.swing.JLabel();
        totalNonRefundedSoldProductCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalRefundedSoldProductCount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        workerCount = new javax.swing.JLabel();
        accountCount = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Genel Ozet");
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        jLabel1.setText("Giderlerin genel özetini aşağıda görebilirsiniz.");

        jLabel2.setText("Toplam Gider: ");

        totalExpense.setText("$");

        jLabel4.setText("Vergi Hariç Toplam Gider:");

        jLabel5.setText("Toplam Vergi:");

        totalExpenseNoTax.setText("$");

        totalTax.setText("$");

        jLabel3.setText("Ürünler hakkında bilgileri aşağıda görebilirsiniz.");

        jLabel6.setText("Toplam satılan ürün miktarı: ");

        totalSoldProductCount.setText("$");

        totalNonRefundedSoldProductCount.setText("$");

        jLabel7.setText("Toplam iade edilmemiş satılan ürün miktarı: ");

        totalRefundedSoldProductCount.setText("$");

        jLabel8.setText("Toplam iade edilmiş satılan ürün miktarı: ");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setText("Diğer özetleri aşağıda görebilirsiniz.");

        jLabel10.setText("Toplam çalışan sayısı: ");

        workerCount.setText("$");

        accountCount.setText("$");

        jLabel11.setText("Toplam kayıtlı hesap sayısı:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(totalExpenseNoTax, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(totalTax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(workerCount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountCount, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalRefundedSoldProductCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalSoldProductCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalNonRefundedSoldProductCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalExpenseNoTax)
                            .addComponent(jLabel6)
                            .addComponent(totalSoldProductCount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(totalTax)
                            .addComponent(jLabel7)
                            .addComponent(totalNonRefundedSoldProductCount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(totalExpense)
                            .addComponent(jLabel8)
                            .addComponent(totalRefundedSoldProductCount))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(workerCount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accountCount)
                            .addComponent(jLabel11))
                        .addGap(0, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountCount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel totalExpense;
    private javax.swing.JLabel totalExpenseNoTax;
    private javax.swing.JLabel totalNonRefundedSoldProductCount;
    private javax.swing.JLabel totalRefundedSoldProductCount;
    private javax.swing.JLabel totalSoldProductCount;
    private javax.swing.JLabel totalTax;
    private javax.swing.JLabel workerCount;
    // End of variables declaration//GEN-END:variables
}
