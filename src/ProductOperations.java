
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductOperations {
    private ResultSet rs=null;
    private static Connector db = DatabaseInstance.getDb();
    
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
    
    //Database'de verilen ID'li ürünü günceller
    public void update(int ID, String name, double price, double cost, double marketPrice, int stock){
        try {
            String query = "UPDATE products SET product_name = ?, product_price = ?, product_cost = ?, product_market_price = ?, product_stock = ? WHERE product_id = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, name);
            db.preState.setDouble(2, price);
            db.preState.setDouble(3, cost);
            db.preState.setDouble(4, marketPrice);
            db.preState.setInt(5, stock);
            db.preState.setInt(6, ID);
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
    
    //Ürünün stokta yeteri kadar varsa true, yoksa false döndürür
    public boolean checkStock(int ID, int amount){
        boolean bool=false;
         try {
            String query = "SELECT * FROM products WHERE product_id = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, ID);
         
            rs=db.preState.executeQuery();
            if(rs.next()){
                bool = rs.getInt("product_stock")>=amount;
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
    
    //Tüm Ürünleri ArrayListte döndürür
    public ArrayList<Product> getProductList() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String query="SELECT * FROM products";
            db.preState=db.con.prepareStatement(query);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                products.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //Satıştaki ürünleri ArrayListte döndürür
    public ArrayList<Product> getEnableProducts() {
        ArrayList<Product> enableProducts = new ArrayList<>();
        try {
            String query = "SELECT * FROM products WHERE product_enabled = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, "1");
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                enableProducts.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return enableProducts;
    }
    
    //Satışta olmayan ürünleri ArrayListte döndürür
    public ArrayList<Product> getDisableProducts() {
        ArrayList<Product> disableProducts = new ArrayList<>();
        try {
            String query = "SELECT * FROM products WHERE product_enabled = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, "0");
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                disableProducts.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return disableProducts;
    }
    
    //Stokta olan ürünleri ArrayListte döndürür
    public ArrayList<Product> getProductsOnStock() {
        ArrayList<Product> onStockProducts = new ArrayList<>();
        try {
            String query = "SELECT * FROM products WHERE product_stock != ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, 0);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                onStockProducts.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return onStockProducts;
    }
    
    //Stoku bitmiş ürünleri ArrayListte döndürür
    public ArrayList<Product> getProductsOffStock() {
        ArrayList<Product> offStockProducts = new ArrayList<>();
        try {
            String query = "SELECT * FROM products WHERE product_stock = ?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, 0);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                offStockProducts.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return offStockProducts;
    }
    
    //integer array olarak verilen id listesine göre ürünlerden oluşan arraylist döndürür
    public ArrayList<Product> getProductsById(int idList[]) {
        ArrayList<Product> Products = new ArrayList<>();
        for(int id:idList){
            try {
                String query = "SELECT * FROM products WHERE product_id = ?";
                db.preState=db.con.prepareStatement(query);
                db.preState.setInt(1, id);

                rs=db.preState.executeQuery();
                while(rs.next()){
                    Products.add(new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("product_price"),rs.getDouble("product_cost"),rs.getDouble("product_market_price"),rs.getInt("product_stock"),rs.getBoolean("product_enabled")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return Products;
    }
}
