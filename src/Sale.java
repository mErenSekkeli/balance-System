import java.util.ArrayList;
import java.sql.Timestamp;

public class Sale {
    public int ID;
    public Timestamp date;
    public double totalPrice;
    public int sellerID;
    public ArrayList<OrderItem> productsOfSale;
    public boolean isDeleted;
    
    public Sale(int sellerID){
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
    
    public boolean addSale(){
        SalesDbHelper dbHelper = new SalesDbHelper();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Sale sale = new Sale(now, 0, this.sellerID, false);
        dbHelper.addSale(sale);
        
        return false;
    }
    
    public boolean finalizeSale(){
        SalesDbHelper dbHelper = new SalesDbHelper();
        double sumOfTotalPrices = 0;
        for (OrderItem orderItem : this.productsOfSale){
            sumOfTotalPrices += orderItem.price*orderItem.amount;
        }
        
        this.totalPrice = sumOfTotalPrices;
        EmployeeManager.increaseSoldCountOfEmployee(this.sellerID);
        return dbHelper.updatePriceOfSale(this);
    }
    
    public boolean addOrderItemToSale(OrderItem oi){
        ProductOperations po = new ProductOperations();
        SalesDbHelper dbHelper = new SalesDbHelper();

        if(po.checkStock(oi.productID, oi.amount)){
            oi.saleID = ID;
            this.productsOfSale.add(oi);
            dbHelper.addOrderItem(oi);
            po.decreaseStock(oi.productID, oi.amount);
            
            return true;
        }
        
        return false;
    }
      
}
