import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class Product {
    public int ID;
    public String name;
    public double price;
    public double cost;
    public double marketPrice;
    public int stock;
    public boolean enabled;
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
}
