
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.util.Date;

public class registerPage extends javax.swing.JFrame {

    private int val = 0;

    public registerPage() {
        initComponents();
    }

    private static Connector db = DatabaseInstance.getDb();
    private String query = "INSERT INTO accounts(account_email, account_password_hash, account_role) VALUES (?, ?, ?)";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        user_mail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user_pass = new javax.swing.JPasswordField();
        user_pass2 = new javax.swing.JPasswordField();
        user_registerBTN = new javax.swing.JButton();
        info_message = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        user_role = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kullanici Kaydi");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Email");

        jLabel2.setText("Kullanıcı Rolü");

        jLabel3.setText("Şifre");

        jLabel4.setText("Şifre Tekrar");

        user_registerBTN.setText("Kaydol");
        user_registerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_registerBTNActionPerformed(evt);
            }
        });

        info_message.setText(" ");

        jLabel5.setText("Ad Soyad");

        user_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz", "admin", "satış işlemleri", "stok işlemleri" }));
        user_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_roleActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KAYIT OL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(info_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(472, 472, 472))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(user_registerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_mail)
                            .addComponent(user_pass)
                            .addComponent(user_pass2)
                            .addComponent(user_name)
                            .addComponent(user_role, 0, 418, Short.MAX_VALUE))
                        .addGap(428, 428, 428))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(user_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(user_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(user_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(user_registerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info_message)
                .addGap(170, 170, 170))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isUserRegistered(String email) {
        try {
            db.preState = db.con.prepareStatement("SELECT count(*) as c FROM accounts WHERE account_email = ?");
            db.preState.setString(1, email);
            ResultSet set;
            set = db.preState.executeQuery();
            set.next();
            return set.getInt("c") != 0;
        } catch (SQLException ex) {
            Logger.getLogger(registerPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void user_registerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_registerBTNActionPerformed

        try {
            // test.account_id=15;

            int account_role = user_role.getSelectedIndex();
            String username = user_name.getText();
            String mail = user_mail.getText();
            String pass = user_pass.getText();
            String pass2 = user_pass2.getText();
             
            if(isUserRegistered(mail)) {
                info_message.setBackground(new Color(37, 146, 67));
                info_message.setText("Zaten aynı kullanıcı epostasıyla biri kayıtlı.");
                return;
            }
            if (!emailValidation.isValid(mail)) {
                info_message.setBackground(new Color(37, 146, 67));
                info_message.setText("Kullanıcı Kaydı Başarısız: Girilen email adresinin formatı düzgün değil");

            } else if (account_role == 0) {

                info_message.setBackground(new Color(37, 146, 67));
                info_message.setText("Kullanıcı Rolü Seçiniz!");

            } else if (pass.length() < 8) {

                info_message.setBackground(new Color(37, 146, 67));
                info_message.setText("Kullanıcı Kaydı Başarısız: Şifre Uzunluğu En Az 8 Karakter Olmalı");
            } else if (pass.compareTo(pass2) != 0) {
                info_message.setBackground(new Color(37, 146, 67));
                info_message.setText("Kullanıcı Kaydı Başarısız: Girdiğiniz İki Şifre Uyuşmuyor");
            } else {

                try {
                    pass = md5Hash.toHexString(md5Hash.getSHA(pass));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(registerPage.class.getName()).log(Level.SEVERE, null, ex);
                }

                db.preState = db.con.prepareStatement(query);
                db.preState.setString(1, mail);
                db.preState.setString(2, pass);
                db.preState.setString(3, Integer.toString(account_role));
                int check = db.preState.executeUpdate();


                // Kullanıcının accounts tablosundaki insert edildiğinde oluşan id'si employer tablosundaki ile eşlenip kullanıcı o tabloya da insert ediliyor
                query = "SELECT * FROM accounts where account_email = ? and account_password_hash = ?";
                db.preState = db.con.prepareStatement(query);
                db.preState.setString(1, mail);
                db.preState.setString(2, pass);
                ResultSet rs = db.preState.executeQuery();

                if (rs != null) {
                    rs.next();

                    info_message.setForeground(new Color(37, 146, 67));
                    info_message.setText("Kullanıcı Girişi Başarılı !");
                    int account_emp_id = rs.getInt("account_emp_id");

                    query = "INSERT INTO employer(emp_id, emp_name, emp_hiring_time, emp_last_login, emp_work_time) VALUES (?, ?, ?, ?, ?)";
                    db.preState = db.con.prepareStatement(query);

                    Date date = new Date();
                    java.sql.Date sDate = new java.sql.Date(date.getTime());

                    db.preState.setInt(1, account_emp_id);
                    db.preState.setString(2, username);
                    db.preState.setDate(3, sDate);
                    db.preState.setDate(4, sDate);
                    db.preState.setInt(5, 1);
                    db.preState.executeUpdate();

                    info_message.setBackground(new Color(37, 146, 67));
                    info_message.setText(" Kullanıcı Girişi Başarılı !");

                    Timer timer = new Timer(1200, null);
                    timer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            dispose();
                        }

                    });
                    timer.start();

                }
            }

        } catch (SQLException ex) {

            info_message.setForeground(new Color(255, 0, 0));
            info_message.setText("Kullanıcı Girişi Başarısız !");

            Timer timer = new Timer(1200, null);
            timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {

                    dispose();
                    timer.stop();
                }

            });
            timer.start();

            Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_registerBTNActionPerformed

    private void user_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_roleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed
    public void registerInject() {
        java.awt.EventQueue.invokeLater(() -> {
            new registerPage().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel info_message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField user_mail;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pass;
    private javax.swing.JPasswordField user_pass2;
    private javax.swing.JButton user_registerBTN;
    private javax.swing.JComboBox<String> user_role;
    // End of variables declaration//GEN-END:variables

}
