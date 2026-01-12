import java.util.ArrayList;
public class OrderManagementSystem {
    static ArrayList<Product> productCatalog = new ArrayList<>();

    void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : productCatalog) {
            System.out.println("Product: " + product.name + ", Price: $" + product.price);
        }
    }
    public static void main(String[] args) {
        OrderManagementSystem oms = new OrderManagementSystem();
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);
        productCatalog.add(product1);
        productCatalog.add(product2);
        productCatalog.add(product3);
        oms.displayProducts();

        Customer customer = new Customer("Alice", "alice@gmail.com");
        Order order = new Order(1, customer, product1);
        Payment paymentMethod = new UPI();
        try {
            customer.placeOrder(order, paymentMethod);
        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
        customer.cancelOrder(order);
    }
}