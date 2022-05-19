import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    ArrayList<Product> productInfo = new ArrayList<>();
    private static Connector db=new Connector();
    private String query="SELECT * FROM products";

    //Ürünlerin Constructor'u
    public Product(int ID,String name, double price, double cost, double marketPrice, int stock) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.marketPrice = marketPrice;
        this.stock = stock;
        
    }
    //Boş Constructor
    public Product() {
        
    }
    
    //Data Üzerinden Çekilen Bilgiler ArrayList<Product> Tipinde Bir Değerde Tutularak Döndürür
    public ArrayList<Product> prepareProduct() {
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                numberOfProducts++;
                productInfo.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productInfo;
    }
}
