import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDbHelper {
    private Connector db;
    
    public SalesDbHelper(){
        this.db = new Connector();
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
                orderItems.add(new OrderItem(rs.getInt("order_items_id"),rs.getInt("order_items_sales_id"), rs.getInt("order_items_product_id"), rs.getInt("order_items_amount"), rs.getBoolean("order_items_refunded"),rs.getDouble("order_items_price"),rs.getDouble("order_items_cost")));
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
       query = "SELECT * FROM orders WHERE orders_id=?"; 
       try{
           db.preState = db.con.prepareStatement(query);
           db.preState.setInt(1, saleID);
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
    
    public int getSaleID(){
       int id = -1;
       String query;
       query = "SELECT * FROM orders"; 
       try{
           db.preState = db.con.prepareStatement(query);
           ResultSet rs = db.preState.executeQuery();
           rs.next();
           while(rs.next())
               id = rs.getInt("orders_id");  
       } catch(SQLException e){
           System.out.println(e);
       }
        System.out.println("SalesDbHelper.getSaleID() ID: "+ id);
       return id;
    }
    
    public boolean refundSale(Sale sale){
        System.out.println(sale.ID);
        String query = "UPDATE `orders` SET `orders_refunded`= ?  WHERE `orders_id`=?";
        try{
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1,"1");
            db.preState.setInt(2, sale.ID);
            db.preState.executeUpdate();
            return true;
        } catch(SQLException e){
            System.out.println("SalesDbHelper.updateRefundedStateOfSale()" + e);
            return false;
        } 
    }
    
    public void updatePriceOfSale(Sale sale){
        String query = "UPDATE `orders` SET `orders_total_price`=? WHERE `orders_id`=?";
        try{
            db.preState = db.con.prepareStatement(query);
            db.preState.setDouble(1, sale.totalPrice);
            db.preState.setInt(2,sale.ID);
            db.preState.executeUpdate();
        } catch(SQLException e){
            System.out.println("SalesDbHelper.updateSale()" + e);
        }
    }
    
    // Sale nesnesi parametre olarak alınıp daha sonra bunun icersindeki items objesine eklenme şeklinde de yapılabilir.
    public ArrayList<OrderItem> getItemsOfSale(int saleID){
       ArrayList<OrderItem> oi = new ArrayList<>();
       String query = "SELECT * FROM order_items WHERE `order_items_sales_id`=?";
       try{
           db.preState = db.con.prepareStatement(query);
           db.preState.setInt(1, saleID);
           ResultSet rs = db.preState.executeQuery();
           while(rs.next())
               oi.add(new OrderItem(rs.getInt("order_items_id"), rs.getInt("order_items_sales_id"), rs.getInt("order_items_product_id"), rs.getInt("order_items_amount") , rs.getBoolean("order_items_refunded"), rs.getDouble("order_items_price"), rs.getDouble("order_items_cost")));
           
        } catch(SQLException e){
           System.out.println(e);
        }
       
       return oi;
    }
    
    public void addOrderItem(OrderItem oi){
        try{
            String query = "Insert into order_items (order_items_sales_id, order_items_product_id, order_items_amount, order_items_refunded, order_items_price, order_items_cost)" + "VALUES(?,?,?,'0',?,?)" ;
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, oi.saleID);
            db.preState.setInt(2, oi.productID);
            db.preState.setInt(3, oi.amount);
            db.preState.setDouble(4, oi.price);
            db.preState.setDouble(5, oi.cost);
            db.preState.execute();
        }catch(SQLException e){
            System.out.println("addOrderItem(): "+ e);
        }
    }
    
    public void deleteSale(int saleId){
        Sale sale = getSale(saleId);
        sale.isDeleted = true;
        refundSale(sale);
    }
   
}
