import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDbHelper {
    Connector db;
    
    public SalesDbHelper(){
    this.db = new Connector();
    }
    
    public void getItemsOfOrder(Sale s){
        int id = s.ID;
        System.out.println(id);
        // get from OrderProduct where id = id;
    }
    /*
        Database'de bulunan orders tablosundaki tüm verileri çekmeyi sağlar.
        Geriye ArrayList<Sale>'la bu verileri döner.
    */
    public ArrayList<Sale> getAllSales(){
       ArrayList<Sale> sales = new ArrayList<>();
       String query = "SELECT * FROM orders";
       try{
           db.preState = db.con.prepareStatement(query);
           ResultSet rs = db.preState.executeQuery();
           while(rs.next()){
               sales.add(new Sale(rs.getInt("orders_id"), rs.getTimestamp("orders_timestamp"), rs.getDouble("orders_total_price"), rs.getInt("orders_who_sold"),rs.getBoolean("orders_refunded")));
           }
       } catch(SQLException e){
           System.out.println(e);
       }
       
       for(int i=0; i<sales.size(); i++){
           Sale sale = sales.get(i);
           System.out.println(" Order ID: " + sale.ID + " Tİmestamp: " + sale.date + " Total Price: " + sale.totalPrice + " Seller ID: " + sale.sellerID + " is deleted: " + sale.isDeleted);
       }
       
       return sales;
    }
    
    /*
        Parametre olarak gelen sale tipindeki degeri veritabanına yazmayi saglar
    */
    public void addSale(Sale sale){
        try{
            db.state = db.con.createStatement();
            String query = "Insert into orders (orders_timeStamp, orders_total_price, orders_who_sold, orders_refunded)"
                          + " VALUES("+"'"+ sale.date +"',"+"'"+ sale.totalPrice +"',"+"'"+ sale.sellerID +"',"+"'"+0+"')";
            db.state.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
   // Şu anda çalışmıyor
    public boolean deleteSale(Sale sale){
        // try catch ile db'ye aktarma yapılacak. return degerleri de buna gore belirlenecek
        sale.isDeleted = true;
        for (OrderItem oi : sale.productsOfSale) {
            oi.product.stock += oi.amount;     
        }
        return true;
    }
    
    /*
        Database'de bulunan order_items tablosundaki tüm verileri çekmeyi sağlar.
        Geriye ArrayList<OrderItem>'la bu verileri döner.
    */
    public ArrayList<OrderItem> getAllOrderItems(){
       ArrayList<OrderItem> orderItems = new ArrayList<>();
       String query = "SELECT * FROM order_items";
       try{
           db.preState = db.con.prepareStatement(query);
           ResultSet rs = db.preState.executeQuery();
           while(rs.next()){
                orderItems.add(new OrderItem(rs.getInt("order_items_sales_id"), rs.getInt("order_items_product_id"), rs.getInt("order_items_amount"), rs.getBoolean("order_items_refunded"),rs.getDouble("order_items_price")));
           }
       } catch(SQLException e){
           System.out.println(e);
       }

       return orderItems;
    }
    
    //Kendisine parametre olarak verilen saleID sine sahip sale'i bulup bunu döndürür.
    public Sale getSale(int saleID){
       Sale sale = null;
       String query;
       query = "SELECT * FROM orders WHERE orders_id=" + saleID; 
       try{
           db.preState = db.con.prepareStatement(query);
           ResultSet rs = db.preState.executeQuery();
           rs.next();
           sale = new Sale(rs.getInt("orders_id"), rs.getTimestamp("orders_timestamp"), rs.getDouble("orders_total_price"), rs.getInt("orders_who_sold"),rs.getBoolean("orders_refunded"));
       } catch(SQLException e){
           System.out.println(e);
       }
       if(sale != null)
           System.out.println("Usage For Where Order ID: " + sale.ID + " Tİmestamp: " + sale.date + " Total Price: " + sale.totalPrice + " Seller ID: " + sale.sellerID + " is deleted: " + sale.isDeleted);
       
       
       return sale;
    }
    
    
       // ToDo: add order item to db
}
