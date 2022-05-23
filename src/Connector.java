import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connector {
    
    private String admin_ad="sistemanalizi";
    private String admin_pass="SISTEManalizi123";
    private String db_name="sistemAnalizi";
    private String host="207.154.220.30";
    private int port=3306;
    public Connection con=null;
    public Statement state=null;
    public PreparedStatement preState=null;
    
    public Connector(){
        
        String url="jdbc:mysql://"+host+":"+port+"/"+db_name+"?useUnicode=true&characterEncoding=utf8";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Basarili");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadi...");
        }
        
        try {
            con=DriverManager.getConnection(url,admin_ad,admin_pass);
            System.out.println("Baglanti Basarili...");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Veri Tabanina Baglanti Basarisiz...");
        }
        
    }
    /*
    public static void main(String[] args) {
        Connector db=new Connector();
        
        ArrayList<Product> asd = new ArrayList();
       
        System.out.println(asd.prepareProduct());

    }
*/
}
