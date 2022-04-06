

public class Product {
    static int numberOfProducts=0;
    int ID;
    String name;
    double price;
    double cost;
    double averagePrice;
    int stock;
    boolean enabled;
    
    public Product(){
        
    }
    
    
    public static Product getProductFromID(int id){
        Product product;
        product = new Product();
        return product;
    }
}
