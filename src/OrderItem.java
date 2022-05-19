public class OrderItem {
    public int ID;
    public int saleID;
    public Product product;
    public int productID;
    public int amount;
    public boolean isRefunded;
    public double price;
    public double cost;
    
    public OrderItem(int saleID, Product product, int amount){
        this.saleID = saleID;
        this.product = product;
        this.amount = amount;
        this.isRefunded = false;
        this.productID = product.ID;
        this.price = product.price;
    }
    public OrderItem(int saleID, int productID, int amount, boolean isRefunded, double price){
        this.saleID = saleID;
        this.productID = productID;
        this.amount = amount;
        this.isRefunded = isRefunded;
        this.price = price;
    }
    
}
