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
    
    public void finalizeSale(){
        SalesDbHelper dbHelper = new SalesDbHelper();
        double sumOfTotalPrices = 0;
        for (OrderItem orderItem : this.productsOfSale){
            if(!orderItem.isRefunded)
                sumOfTotalPrices += orderItem.price*orderItem.amount;
            else if(orderItem.isRefunded)
                sumOfTotalPrices -= orderItem.price*orderItem.amount;
        }
        
        this.totalPrice = sumOfTotalPrices;
        dbHelper.updatePriceOfSale(this);
        // call increaseSoldCountOfEmployee
    }
    
    public void addOrderItemToSale(OrderItem oi){
        ProductOperations po = new ProductOperations();
        SalesDbHelper dbHelper = new SalesDbHelper();
        
        if(po.checkStock(oi.productID, oi.amount)){
            this.productsOfSale.add(oi);
            dbHelper.addOrderItem(oi);
            po.decreaseStock(oi.productID, oi.amount);
        }
        
    }
    
    public boolean addRefund(int orderID, int productID, int amount, int priceOfProduct){
        OrderItem oi = new OrderItem(orderID, productID, amount, '1', priceOfProduct);
        SalesDbHelper dbHelper = new SalesDbHelper();
        ProductOperations po = new ProductOperations();  
        this.productsOfSale.add(oi);
        dbHelper.addOrderItem(oi);
        po.decreaseStock(productID, -1*amount);     // stok arttırma metodu
        
        return true;
    }
      
}
