
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  @author MUHAMMEDERENŞEKKELİ
 */
public class analysisCostProfit {
    //Tools
    private static Connector db=new Connector();
    private String query="SELECT * FROM products";

    public analysisCostProfit() {
    }
    
    
    //Bu Fonksiyonun Amacı Her Bir Üründen Elde Edilen Karı ArrayListte Integer Tipinde ArrayList Döndürür
    public ArrayList<Integer> getProfitOfProduct(){
        
        ArrayList<Integer> profit=new ArrayList<>();
        
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
    
    //Bu Fonksiyonun Amacı Her Bir Üründen Elde Edilen Kar Oranını ArrayListte Float Tipinde ArrayList Döndürür
    public ArrayList<Float> getProfitRateOfProduct(){
        
        ArrayList<Float> profitRate=new ArrayList<>();
        
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                float prCost=(float)rs.getInt("product_cost");
                float prPrice=(float)rs.getInt("product_price");
                profitRate.add((prPrice-prCost)/prCost*100);
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return profitRate;
    }
    
    //Bu Fonksiyonun Amacı Her Bir Üründen Elde Edilen Kar Oranını Yorumlayarak String Tipinde ArrayList Döndürür
    public ArrayList<String> commentProfitRate(ArrayList<Float> profitRate){
        ArrayList<String> prNames=new ArrayList<>();
        ArrayList<Float> prMarketDifference=new ArrayList<>();
        ArrayList<String> commentResult=new ArrayList<>();
        ArrayList<Integer> prCost=new ArrayList<>();
        try {
            db.preState=db.con.prepareStatement(query);
            ResultSet rs=db.preState.executeQuery();
            int i=0;
            while(rs.next()){
                float prMarket=((float)(rs.getInt("product_market_price")-rs.getInt("product_cost"))/rs.getInt("product_cost")*100);
                prCost.add(rs.getInt("product_cost"));
                prMarketDifference.add((float)profitRate.get(i++)-prMarket);
                prNames.add(rs.getString("product_name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < profitRate.size(); i++) {
            if(profitRate.get(i)<0){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzden Zarar Etmektesiniz! Zarar Etmemek İçin Ürünün Fiyatını En Az "+(prCost.get(i))
                +" TL Yapmalısınız.");
            }else if(prMarketDifference.get(i)<0){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününden Elde Edilen Kar, Pazar Geneli Elde Edilen Kardan %"+(String.format("%.2f", -prMarketDifference.get(i)))+" Daha Düşük."
                        + " Daha İyi Rekabet İçin Fiyat Artışı Yapabilirsiniz.");
            }else if(prMarketDifference.get(i)>0){
                commentResult.add(i, prNames.get(i)+" İsimli Ürününden Elde Edilen Kar, Pazar Geneli Elde Edilen Kardan %"+(String.format("%.2f", prMarketDifference.get(i)))+" Daha Yüksek."
                        + " Daha İyi Rekabet İçin Fiyat İndirimi Yapabilirsiniz.");
            }else{
                commentResult.add(i, prNames.get(i)+" İsimli Ürününüzün Satış Fiyatı Pazar Geneli Satış Fiyatıyla Aynı. Daha İyi Rekabet İçin Fiyatı Koruyabilirsiniz.");
            }
        }
        
        return commentResult;
    }
    
    /*public static void main(String[] args) {
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
        
    }*/
    
}
