
import java.util.ArrayList;

public class OrderItem {
    public int ID;
    public int saleID;
    public Product product;
    public int productID;
    public int amount;
    public boolean isRefunded;
    public double price;
    public char isRefundedText;
    public double cost;
    
    public OrderItem(int saleID, Product product, int amount){
        this.saleID = saleID;
        this.product = product;
        this.productID = product.ID;
        this.amount = amount;
        this.isRefunded = false;
        this.price = product.price;
        this.cost = product.cost;
    }
    
    public OrderItem(int ID, int saleID, int productID, int amount, boolean isRefunded, double price, double cost){
        this.ID = ID;
        this.saleID = saleID;
        this.productID = productID;
        this.amount = amount;
        this.isRefunded = isRefunded;
        this.price = price;
        this.cost = cost;
    }
    
    public OrderItem(int saleID, int productID, int amount, char isRefundedText, double price){
        this.saleID = saleID;
        this.productID = productID;
        this.amount = amount;
        this.isRefundedText = isRefundedText;
        this.price = price;
    }
    
    public OrderItem(int saleID, int productID, int amount, boolean isRefunded, double price, double cost){
        this.saleID = saleID;
        this.productID = productID;
        this.amount = amount;
        this.isRefunded = isRefunded;
        this.price = price;
    }
    
    public static double calculateTotalPrice(int saleID){
        SalesDbHelper dbHelper = new SalesDbHelper();
        ArrayList<OrderItem> oi;
        double sum = 0;
        oi = dbHelper.getItemsOfSale(saleID);
        for (OrderItem orderItem : oi) {
            sum += orderItem.amount*orderItem.price;
        }
        return sum;
    }
    
}
