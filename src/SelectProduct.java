
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SelectProduct {
    
    String query;    
    ResultSet rs=null;
    private static Connector db=new Connector();
    ArrayList<Product> products = new ArrayList<>();
    
    //Tüm ürünleri ArrayListte döndürür
    public ArrayList<Product> getProductList(){
        Product p = new Product();
        return p.prepareProduct();
    }
    
    
    //Satıştaki ürünleri ArrayListte döndürür
    public ArrayList<Product> getEnableProducts() {
        try {
            query = "SELECT * FROM products WHERE product_enabled = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, "1");
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                products.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock")));
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
        return products;
    }
    
    //Satışta olmayan ürünleri ArrayListte döndürür
    public ArrayList<Product> getDisableProducts() {
        try {
            query = "SELECT * FROM products WHERE product_enabled = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, "0");
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                products.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock")));
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
        return products;
    }
    
    //Stokta olan ürünleri ArrayListte döndürür
    public ArrayList<Product> getProductsOnStock() {
        try {
            query = "SELECT * FROM products WHERE product_stock != ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, 0);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                products.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock")));
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
        return products;
    }
    
    //Stoku bitmiş ürünleri ArrayListte döndürür
    public ArrayList<Product> getProductsOffStock() {
        try {
            query = "SELECT * FROM products WHERE product_stock = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, 0);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                products.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock")));
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
        return products;
    }
}
