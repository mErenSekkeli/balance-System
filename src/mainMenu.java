/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Selahattin
 */
public class mainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    private ProductOperations pOps;
    private SalesDbHelper orderManager;
    private Connector db;
    
    public void initRole(int account_user_role){
        
        if(account_user_role == 2){
            
            urunekle.setVisible(false);
            iadeedilenurunlistesi.setVisible(false);
            urunlistesi.setVisible(false);
            satisozeti.setVisible(false);
            
            satisanalizi.setVisible(false);
            stokanalizi.setVisible(false);
            karanalizi.setVisible(false);
            
        }
        else if(account_user_role == 3){
            
            
            satisanalizi.setVisible(false);
            stokanalizi.setVisible(false);
            karanalizi.setVisible(false);
        }
    }
    
    public mainMenu() {
        orderManager = new SalesDbHelper();
        DatabaseInstance.init();
        db = DatabaseInstance.getDb();
        pOps = new ProductOperations();
        initComponents();
        initRole(currentUser.getAccount_role());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cikis = new javax.swing.JButton();
        urunlistesi = new javax.swing.JButton();
        urunekle = new javax.swing.JButton();
        iadeedilenurunlistesi = new javax.swing.JButton();
        satisozeti = new javax.swing.JButton();
        kullanicilistesi = new javax.swing.JButton();
        karanalizi = new javax.swing.JButton();
        satisanalizi = new javax.swing.JButton();
        stokanalizi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        satisekle = new javax.swing.JButton();
        satisgoruntuleiade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1280, 720));

        cikis.setText("Çıkış Yap");
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });

        urunlistesi.setText("Ürün Listesi");
        urunlistesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunlistesiActionPerformed(evt);
            }
        });

        urunekle.setText("Ürün Ekle");
        urunekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunekleActionPerformed(evt);
            }
        });

        iadeedilenurunlistesi.setText("İade Edilen Ürün Listesi");
        iadeedilenurunlistesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iadeedilenurunlistesiActionPerformed(evt);
            }
        });

        satisozeti.setText("Satış Özeti");
        satisozeti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisozetiActionPerformed(evt);
            }
        });

        kullanicilistesi.setText("Kullanıcı Listesi");
        kullanicilistesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanicilistesiActionPerformed(evt);
            }
        });

        karanalizi.setText("Kâr Analizi");
        karanalizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karanaliziActionPerformed(evt);
            }
        });

        satisanalizi.setText("Satış/Çalışan Analizi");
        satisanalizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisanaliziActionPerformed(evt);
            }
        });

        stokanalizi.setText("Stok Analizi");
        stokanalizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokanaliziActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ANA MENÜ");

        satisekle.setText("Satış Ekle");
        satisekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisekleActionPerformed(evt);
            }
        });

        satisgoruntuleiade.setText("Satış Görüntüle/İade");
        satisgoruntuleiade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisgoruntuleiadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(458, 458, 458)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(urunlistesi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urunekle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iadeedilenurunlistesi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satisozeti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kullanicilistesi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satisekle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(satisgoruntuleiade, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(stokanalizi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(satisanalizi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(karanalizi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urunlistesi)
                    .addComponent(karanalizi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urunekle)
                    .addComponent(satisanalizi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iadeedilenurunlistesi)
                    .addComponent(stokanalizi))
                .addGap(24, 24, 24)
                .addComponent(satisozeti)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kullanicilistesi)
                    .addComponent(satisgoruntuleiade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(satisekle)
                    .addComponent(cikis))
                .addGap(175, 175, 175))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed
        
        /* Kullanıcıya çıkış yapmak isteyip istemediği JOptionPane olarak tekrar sorulur */
        Object[] options = { "EVET", "HAYIR" };
        int response=JOptionPane.showOptionDialog(this, "Çıkış Yapmak İstediğinize Emin Misiniz?", "Uyarı", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(response == JOptionPane.YES_OPTION){  
            setVisible(false);
            loginPage log=new loginPage();
            log.loginInject();
        }
            
    }//GEN-LAST:event_cikisActionPerformed

    private void urunlistesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunlistesiActionPerformed
        ProductList list=new ProductList();
        setVisible(false);
        list.listInject();
        
    }//GEN-LAST:event_urunlistesiActionPerformed

    private void urunekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunekleActionPerformed

        AddProductFrontEnd addProductPage=new AddProductFrontEnd();
        setVisible(false);
        addProductPage.Inject();
    }//GEN-LAST:event_urunekleActionPerformed

    private void iadeedilenurunlistesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iadeedilenurunlistesiActionPerformed
        // TODO add your handling code here:
        ListRefundedProductsUI lrp = new ListRefundedProductsUI(orderManager);
        setVisible(false);
        lrp.Inject();
    }//GEN-LAST:event_iadeedilenurunlistesiActionPerformed

    private void satisozetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisozetiActionPerformed
        // TODO add your handling code here:
        SaleSummaryUI lrp = new SaleSummaryUI(db);
        setVisible(false);
        lrp.Inject();
    }//GEN-LAST:event_satisozetiActionPerformed

    private void kullanicilistesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanicilistesiActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_kullanicilistesiActionPerformed

    private void satisekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisekleActionPerformed
        // TODO add your handling code here:
        AddOrderPage lrp = new AddOrderPage();
        setVisible(false);
        lrp.Inject();
    }//GEN-LAST:event_satisekleActionPerformed

    private void karanaliziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karanaliziActionPerformed
        // TODO add your handling code here:
        analysisCostProfitFrontEnd lrp = new analysisCostProfitFrontEnd();
        setVisible(false);
        lrp.inject();
    }//GEN-LAST:event_karanaliziActionPerformed

    private void satisanaliziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisanaliziActionPerformed
        // TODO add your handling code here:
        analysisEmployeeFrontEnd lrp = new analysisEmployeeFrontEnd();
        setVisible(false);
        lrp.inject();
    }//GEN-LAST:event_satisanaliziActionPerformed

    private void stokanaliziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokanaliziActionPerformed
        // TODO add your handling code here:
        analysisStockFrontEnd lrp = new analysisStockFrontEnd();
        setVisible(false);
        lrp.inject();
    }//GEN-LAST:event_stokanaliziActionPerformed

    private void satisgoruntuleiadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisgoruntuleiadeActionPerformed
        // TODO add your handling code here:
        OrderListForm lrp = new OrderListForm(orderManager, pOps);
        setVisible(false);
        lrp.Inject();
    }//GEN-LAST:event_satisgoruntuleiadeActionPerformed
    
    public void mainInject(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new mainMenu().setLocationRelativeTo(null);
            new mainMenu().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cikis;
    private javax.swing.JButton iadeedilenurunlistesi;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton karanalizi;
    private javax.swing.JButton kullanicilistesi;
    private javax.swing.JButton satisanalizi;
    private javax.swing.JButton satisekle;
    private javax.swing.JButton satisgoruntuleiade;
    private javax.swing.JButton satisozeti;
    private javax.swing.JButton stokanalizi;
    private javax.swing.JButton urunekle;
    private javax.swing.JButton urunlistesi;
    // End of variables declaration//GEN-END:variables
}
