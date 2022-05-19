
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductOperations {
    private ResultSet rs=null;
    private static Connector db=new Connector();
    // Database'e yeni ürün ekler
    public void add(String name, double price, double cost, double marketPrice, int stock){
        try {
           String query = "Insert into products (product_name, product_price, product_cost, product_market_price, product_stock) VALUES(?,?,?,?,?)";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, name);
            db.preState.setDouble(2, price);
            db.preState.setDouble(3, cost);
            db.preState.setDouble(4, marketPrice);
            db.preState.setDouble(5, stock);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'de verilen ID'li ürünün ismini günceller
    public void updateName(int ID, String name){
        try {
           String query = "UPDATE products SET product_name = '?' WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, name);
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'de verilen ID'li ürünün fiyatını günceller
    public void updatePrice(int ID, double price){
        try {
           String query = "UPDATE products SET product_price = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setDouble(1, price);
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'de verilen ID'li ürünün maliyetini günceller
    public void updateCost(int ID, double cost){
        try {
           String query = "UPDATE products SET product_cost = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setDouble(1, cost);
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'de verilen ID'li ürünün pazar fiyatını günceller
    public void updateMarketPrice(int ID, double mPrice){
        try {
           String query = "UPDATE products SET product_market_price = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setDouble(1, mPrice);
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'de verilen ID'li ürünün stok sayısını günceller
    public void updateStock(int ID, int stock){
        try {
           String query = "UPDATE products SET product_stock = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, stock);
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'de verilen ID'li ürünün stok sayısını 'amount' kadar eksiltir
    public void decreaseStock(int ID, int amount){
        try {
           String query = "UPDATE products SET product_stock = product_stock-? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, amount);
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Ürünün stokta varsa true, yoksa false döndürür
    public boolean checkStock(int ID, int amount){
        boolean bool=false;
        System.out.println("ProductOperations.checkStock() " +ID);
         try {
            String query = "SELECT * FROM products WHERE product_id = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, ID);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                bool = rs.getInt("product_stock")>amount;
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
        return bool;
    }
    
    //Satıştan kaldırılan ürünün  enabled değerine 0 atar. (disable eder)
    public void disable(int ID){
        try {
            String query = "UPDATE products SET product_enabled = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, "0");
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Satışa eklenen ürünün  enabled değerine 1 atar. (enable eder)
    public void enable(int ID){
        try {
            String query = "UPDATE products SET product_enabled = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, "1");
            db.preState.setInt(2, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Database'den ürün siler
    public void remove(int ID){
        try {
            String query = "DELETE FROM products WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, ID);
            db.preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
