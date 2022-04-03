
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  @author MUHAMMEDERENŞEKKELİ
 */
public class analysisCostProfit {
    //Tools
    private static Connector db=new Connector();
    
    
    //Bu Fonksiyonun Amacı Her Bir Üründen Elde Edilen Karı ArrayListte Integer Tipinde Değer Döndürür
    public static ArrayList<Integer> getProfitOfProduct(){
        
        ArrayList<Integer> profit=new ArrayList<>();
        
        String query="SELECT * FROM products";
        
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                int prCost=rs.getInt("product_cost");
                int prPrice=rs.getInt("product_price");
                profit.add(prPrice-prCost);
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return profit;
    }
    
    //Bu Fonksiyonun Amacı Her Bir Üründen Elde Edilen Kar Oranını ArrayListte Float Tipinde Değer Döndürür
    public static ArrayList<Float> getProfitRateOfProduct(){
        
        ArrayList<Float> profitRate=new ArrayList<>();
        
        String query="SELECT * FROM products";
        
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                float prCost=(float)rs.getInt("product_cost");
                float prPrice=(float)rs.getInt("product_price");
                profitRate.add((prPrice-prCost)/prPrice*100);
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return profitRate;
    }
    
    public static ArrayList<String> commentProfitRate(ArrayList<Float> profitRate){
        String query="SELECT * FROM products";
        ArrayList<String> prNames=new ArrayList<>();
        ArrayList<String> commentResult=new ArrayList<>();
        try {
            db.preState=db.con.prepareStatement(query);
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                prNames.add(rs.getString("product_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < profitRate.size(); i++) {
            if(profitRate.get(i)<0){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden Zarar Etmektesiniz! Zarar Etmemek İçin Ürünün Fiyatını En Az %"+(-profitRate.get(i))
                +" Kadar Artırmalısınız.");
            }else if(profitRate.get(i)==0){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden Kar Ya Da Zarar Etmemektesiniz! Kar Etmek İçin Ürün Fiyatını Artırmalısınız.");
            }else if(profitRate.get(i)<10){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden %10'dan Düşük Kar Sağlamaktasınız! Kar Oranını Artırmalısınız.");
            }else if(profitRate.get(i)<50){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden %50'den Düşük Kar Sağlamaktasınız! Kar Oranını Artırmak Yararlı Olabilir.");
            }else if(profitRate.get(i)<100){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden %100'den Düşük Kar Sağlamaktasınız! Kar Oranınız Yeterli Düzeydedir.");
            }else{
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden %100'den Yüksek Kar Sağlamaktasınız! Kar Oranınız Yüksektir.");
            }
        }
        
        return commentResult;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> db;
       db=getProfitOfProduct();
       //Örnek Sonuçlar
        System.out.println("Ürünlerden Elde Edilen Karlar: ");
       for(Integer d : db){
           System.out.println(d);
       }
        ArrayList<Float> db2;
        //Sayı Yuvarlama İşlemi
        DecimalFormat df=new DecimalFormat("0.00");
        //Örnek Sonuçlar
        System.out.println("Ürünlerden Elde Edilen Kar Oranları: ");
        db2=getProfitRateOfProduct();
        for(Float d : db2){
           System.out.println(df.format(d));
       }
        
        System.out.println("Ürün Kar Yorumları: ");
        ArrayList<String> db3;
        db3=commentProfitRate(db2);
        for(String s : db3){
            System.out.println(s);
        }
        
    }
    
}
