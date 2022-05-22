
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/*
@author MUHAMMEDERENŞEKKELİ
 */

public class analysisProductStock {
    //Tools
    private ProductOperations pr;
    private static ArrayList<Product> prList;
    private static SalesDbHelper salesHelper;
    //Constructor
    public analysisProductStock() {
        pr=new ProductOperations();
        prList=pr.getProductList();
        salesHelper=new SalesDbHelper();
    }
    
    //Ürünlerin Stoklarını Döndüren Fonksiyon
    public static ArrayList<Integer> prepareStock(){
        ArrayList<Integer> tmpStock=new ArrayList<>();
        for(Product p : prList){
            tmpStock.add(p.stock);
        }
        return tmpStock;
    }
    
    public static long timeDifferrence(Date dateSelled){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(dateSelled); 
        String[] dates=strDate.split("-");
        int year=Integer.parseInt(dates[0]);
        int month=Integer.parseInt(dates[1]);
        int day=Integer.parseInt(dates[2]);
        Date date2=new Date(year,month,day);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        strDate=dtf.format(now);
        String[] dates2=strDate.split("-");
        int year2=Integer.parseInt(dates2[0]);
        int month2=Integer.parseInt(dates2[1]);
        int day2=Integer.parseInt(dates2[2]);
        Date date=new Date(year2,month2,day2);
        long diffInMillies = Math.abs(date.getTime() - date2.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;
    }
    
    public ArrayList<String> getAnalysisOfStock(){
        boolean isSaled=false;
        ArrayList<String> commonStock=new ArrayList<>();
        ArrayList<OrderItem> orderItemsList=salesHelper.getAllOrderItems();
        HashMap<Integer, Long> whenSelled=new HashMap<>();
        for(Product pr : prList){
            for(OrderItem oi : orderItemsList){
                if(pr.ID==oi.productID && !oi.isRefunded){
                    Sale tmpSale=salesHelper.getSale(oi.saleID);
                    Date dateSelled=new Date(tmpSale.date.getTime());
                    long diff=timeDifferrence(dateSelled);
                    whenSelled.put(pr.ID, diff);
                }
            }
            if(whenSelled.containsKey(pr.ID) ){
               //Satış Varsa
             long stockIndex=pr.stock*whenSelled.get(pr.ID);
             
             if(pr.stock==0){
                 commonStock.add("Ürünün Stoğu Bitmiştir.");
             }else if(whenSelled.get(pr.ID)==0 && pr.stock<=10){
              commonStock.add("En Son Bugün Satıldı."+" Stok Çok Kısa Sürede Bitebilir. Stok Yenilemesi Önerilir.");
             }else if(whenSelled.get(pr.ID)==0 && pr.stock<=50){
              commonStock.add("En Son Bugün Satıldı."+" Stok, Satış Durumuna Göre Bitebilir. Stok Yenilemesi Önerilir.");
             }else if(stockIndex<5){
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Stok Çok Kısa Sürede Bitebilir. Stok Yenilemesi Önerilir.");
             }else if(stockIndex<10){
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Stok Kısa Sürede Bitebileceği İçin Stok Yenilemesi Önerilir.");
             }else if(stockIndex<20){
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Satış Düzeyine Göre Stok Yeterli Düzeyde Değil.");
             }else if(stockIndex<50){
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Satış-Stok Takibi Gerekebilir.");                 
             }else if(stockIndex<100){
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Satış Durumuna Göre Stok Kısmına Dikkat Edilmelidir.");                                  
             }else if(stockIndex<500){
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Satış Durumuna Göre Stok Yeterli Düzeydedir.");                                  
             }else{
                 commonStock.add("Ürün En Son "+whenSelled.get(pr.ID)+" Gün Önce Satıldı. Satış Durumuna Göre Stok Yeterli Düzeydedir. Stok Yenilemesi Önerilmez.");
             }
             
            }else{
            //Satış Yoksa
            if(pr.stock==0){
                commonStock.add("Ürünün Stoğu Bitmiştir.");
            }else if(pr.stock<=10){
                commonStock.add("Stok Durumu Bitme Düzeyinde. Sürdürülebilir Satış İçin Stok Yenilemesi Önerilir.");
            }else if(pr.stock<=20){
                commonStock.add("Stok Durumu Kritik. Stok Yenilemesi Önerilir.");
            }else if(pr.stock<=50){
                commonStock.add("Stok Durumu Orta Düzeyde. Yakın Zamanda Satış Olmadığı İçin Takviye Önerilmez.");
            }else {
                commonStock.add("Stok Durumu Yeterli Düzeyde. Yakın Zamanda Satış Olmadığı İçin Takviye Önerilmez");
            }
                
            }
        }
        return commonStock;
    }
}
