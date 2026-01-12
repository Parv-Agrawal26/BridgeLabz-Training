public class Product {
    private String name;
    private double price;
    private int quantity;
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    String getName() {
        return name;
    }
    double getPrice() {
        return price;
    }
    int getQuantity() {
        return quantity;
    }
    void setPrice(double price) {
        this.price = price;
    }
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
