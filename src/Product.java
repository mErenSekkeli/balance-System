import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product {
    static int numberOfProducts=0;
    int ID;
    String name;
    double price;
    double cost;
    double marketPrice;
    int stock;
    boolean enabled;
    private ResultSet rs=null;

    ArrayList<Product> productInfo = new ArrayList<>();
    //private static Connector db=new Connector();
    private String query="SELECT * FROM products";

    //Ürünlerin Constructor'u
    public Product(int ID,String name, double price, double cost, double marketPrice, int stock, boolean enabled) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.marketPrice = marketPrice;
        this.stock = stock;
        this.enabled = enabled;
    }
    //Boş Constructor
    public Product() {
        
    }
    
    public String priceFormatter(double price){
        Locale locale = new Locale("tr", "TR");
        Currency liras = Currency.getInstance(locale);
        NumberFormat lirasFormat = NumberFormat.getCurrencyInstance(locale);
        
        return lirasFormat.format(price);
    }
    
    /*
    //Bu method yerine ProductOperations classındaki getProductList methodunu kullanın.
    //Şimdilik bunu kullanmak için Connector db'yi yorumdan çıkarın
    //Bu method silinecek
    public ArrayList<Product> prepareProduct() {
        try {
            db.preState=db.con.prepareStatement(query);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                numberOfProducts++;
                productInfo.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        }
        return productInfo;
    }*/
}
