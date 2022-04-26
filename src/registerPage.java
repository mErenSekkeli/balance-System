
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.SimpleDateFormat;  

public class registerPage extends javax.swing.JFrame {
    private int val=0;
    private String mes="Kayit Basarili! Yonlendiriliyorsunuz";
    public registerPage() {
        initComponents();
    }
    
    private static Connector db=new Connector();
    private String query = "INSERT INTO accounts(account_email, account_password_hash, account_role) VALUES (?, ?, ?)";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_mail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_role = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user_pass = new javax.swing.JPasswordField();
        user_pass2 = new javax.swing.JPasswordField();
        user_registerBTN = new javax.swing.JButton();
        info_message = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kullanici Kaydi");

        jLabel1.setText("Account ");

        jLabel2.setText("Account Role");

        jLabel3.setText("Sifre:");

        jLabel4.setText("Sifre Tekrar:");

        user_registerBTN.setText("Kaydol");
        user_registerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_registerBTNActionPerformed(evt);
            }
        });

        info_message.setText(" ");

        jLabel5.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(user_registerBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info_message, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user_mail, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(user_role)
                            .addComponent(user_pass)
                            .addComponent(user_pass2)
                            .addComponent(user_name))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(user_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(user_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(user_registerBTN)
                .addGap(18, 18, 18)
                .addComponent(info_message)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_registerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_registerBTNActionPerformed
        
        try {
            
            String account_role=user_role.getText();
            String username=user_name.getText();
            String mail=user_mail.getText();
            String pass = user_pass.getText();
            String pass2 = user_pass2.getText();
            
            if(account_role == null || username == null || mail == null || pass == null || pass2 == null ){
                System.out.println("asdad");
            }
                   
            else{ 
            System.out.println(mail+"--"+pass);
            
                
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, mail);
            db.preState.setString(2, pass);
            db.preState.setString(3, account_role);
            var check = db.preState.executeUpdate();
            
            
            // kullanıcı kaydı başarılı ise kullanıcı girişi yapması için yönlendirme yapılır.
            
            
            System.out.println(check);
            
            query = "SELECT * FROM accounts where account_email = ? and account_password_hash = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, mail);
            db.preState.setString(2, pass);
            ResultSet rs=db.preState.executeQuery();
            
            if(rs != null){
                rs.next();
                info_message.setText("Kullanici girisi basarili!");
                int account_emp_id = rs.getInt("account_emp_id");
                
                query = "INSERT INTO employer(emp_id, emp_name, emp_hiring_time, emp_last_login) VALUES (?, ?, ?, ?)";
            db.preState=db.con.prepareStatement(query);   
            
            Date date = new Date();    
            java.sql.Date sDate = new java.sql.Date(date.getTime());
            
            
            db.preState.setInt(1, account_emp_id);
            db.preState.setString(2, username);
            db.preState.setDate(3, sDate);
            db.preState.setDate(4, sDate);
            db.preState.executeUpdate();
            
            info_message.setText("Kullanici kaydi basarili!");
            
            Timer timer=new Timer(1200, null);
            timer.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    
                    
                        setVisible(false);
                        loginPage log=new loginPage();
                        log.loginInject();
                        timer.stop();
                }
                
            });
            timer.start();
                
            }
            }
            
            
            
        } catch (SQLException ex) {
            
            info_message.setText("Kullanici kaydi basarisiz!");
            
            Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_user_registerBTNActionPerformed
public void registerInject(){
            java.awt.EventQueue.invokeLater(() -> {
                new registerPage().setVisible(true);
            });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info_message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField user_mail;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pass;
    private javax.swing.JPasswordField user_pass2;
    private javax.swing.JButton user_registerBTN;
    private javax.swing.JTextField user_role;
    // End of variables declaration//GEN-END:variables
    
}
