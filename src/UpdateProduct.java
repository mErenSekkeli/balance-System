
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


/**
 *
 * @author A
 */
public class UpdateProduct extends javax.swing.JFrame {
    
    private Product setProduct;
    private ProductOperations set;
    private ProductList pList;
    /**
     * Creates new form UpdateProduct
     */
    public UpdateProduct(Product setProduct, ProductOperations set, ProductList pList) {
        initComponents();
        this.setProduct = setProduct;
        this.pList = pList;
        name.setText(setProduct.name);
        price.setText(Double.toString(setProduct.price));
        cost.setText(Double.toString(setProduct.cost));
        marketPrice.setText(Double.toString(setProduct.marketPrice));
        stock.setText(Integer.toString(setProduct.stock));
        this.set = set;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        error_message = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        LabelPrice = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        LabelMPrice = new javax.swing.JLabel();
        marketPrice = new javax.swing.JTextField();
        LabelCost = new javax.swing.JLabel();
        cost = new javax.swing.JTextField();
        LabelStock = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Urun Guncelle");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        error_message.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        LabelName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelName.setText("Ürün Adı");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        LabelPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPrice.setText("Ürün Fiyatı");

        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceKeyTyped(evt);
            }
        });

        LabelMPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelMPrice.setText("Ortalama Pazar Fiyatı");

        marketPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marketPriceKeyTyped(evt);
            }
        });

        LabelCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelCost.setText("Ürünün Maliyeti");

        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costKeyTyped(evt);
            }
        });

        LabelStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelStock.setText("Stok Sayısı");

        stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stokKeyTyped(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveButton.setText("Ürünü Kaydet");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ÜRÜN GÜNCELLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(error_message, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addGap(204, 204, 204))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelCost, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelMPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(marketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPrice)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMPrice)
                    .addComponent(marketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCost)
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelStock)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(error_message, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void priceChecker(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != '.') {
            evt.consume();  // if it's not a number, ignore the event
        }
    }
    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(name.getText().equals("")){
            error_message.setForeground(Color.RED);
            error_message.setText("Urun Ismi Bos Birakilamaz!");
        }else if(price.getText().equals("")){
            error_message.setForeground(Color.RED);
            error_message.setText("Urunun Fiyati Bos Birakilamaz!");
        }else if(cost.getText().equals("")){
            error_message.setForeground(Color.RED);
            error_message.setText("Urunun Maliyeti Bos Birakilamaz!");
        }else if(marketPrice.getText().equals("")){
            error_message.setForeground(Color.RED);
            error_message.setText("Pazar Fiyati Bos Birakilamaz!");
        }else if(stock.getText().equals("")){
            error_message.setForeground(Color.RED);
            error_message.setText("Stok Miktari Bos Birakilamaz!");
        } else if (Integer.parseInt(stock.getText()) < 0) { 
            error_message.setForeground(Color.RED);
            error_message.setText("Stok Miktari negatif olamaz!");
        }
        else{
            boolean result = set.update(setProduct.ID, name.getText(), Double.parseDouble(price.getText()), Double.parseDouble(cost.getText()), Double.parseDouble(marketPrice.getText()), Integer.parseInt(stock.getText()));
            if(!result) {
                JOptionPane.showMessageDialog(this, "Ürünü güncellerken bir hata oluştu!");
                return;
            }
            pList.returnToList();
            pList.putMessage(Color.green, "Ürün Güncellendi");
            setVisible(false);
            
            
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stokKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // if it's not a number, ignore the event
        }
    }//GEN-LAST:event_stokKeyTyped

    private void costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyTyped
        // TODO add your handling code here:
        priceChecker(evt);
    }//GEN-LAST:event_costKeyTyped

    private void marketPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marketPriceKeyTyped
        // TODO add your handling code here:
        priceChecker(evt);
    }//GEN-LAST:event_marketPriceKeyTyped

    private void priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyTyped
        // TODO add your handling code here:
        priceChecker(evt);
    }//GEN-LAST:event_priceKeyTyped

   
    
    
    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCost;
    private javax.swing.JLabel LabelMPrice;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPrice;
    private javax.swing.JLabel LabelStock;
    private javax.swing.JTextField cost;
    private javax.swing.JLabel error_message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField marketPrice;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
