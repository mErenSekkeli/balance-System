
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;

public class Sale {
    public int ID;
    //private int key;
    public Timestamp date;
    public double totalPrice;
    public int sellerID;
    public ArrayList<OrderItem> productsOfSale;
    public boolean isDeleted;
    // private boolean isRefunded
    
    public Sale(int sellerID){
        // this.ID = ID;    veri tabanından cekilmeli
        this.sellerID = sellerID;
        productsOfSale = new ArrayList<>();
        this.isDeleted = false;
    }
    
    public Sale(int ID, Timestamp date, double totalPrice, int sellerID,boolean isDeleted){
        this.ID = ID;
        this.date = date;
        this.totalPrice = totalPrice;
        this.sellerID = sellerID;
        this.isDeleted = isDeleted;
    }
    
    public Sale(Timestamp date, double totalPrice, int sellerID,boolean isDeleted){
        this.date = date;
        this.totalPrice = totalPrice;
        this.sellerID = sellerID;
        this.isDeleted = isDeleted;
    }
    
    public boolean addSale(int amount, Product product, int empID){
        if(product.stock >= amount){
            OrderItem order = new OrderItem(this.ID, product, amount);
            this.totalPrice += product.price*amount;
            productsOfSale.add(order);
            product.stock -= amount;
            // increaseSoldCountOfEmployee(amount, empID);
            return true;
        }
        return false;
    }
   
    
    /*
    Selo Yazacak
    private void increaseSoldCountOfEmployee(int amount, int empID){
        String query = "";  
    } 
    */
    
   
    
       
}
