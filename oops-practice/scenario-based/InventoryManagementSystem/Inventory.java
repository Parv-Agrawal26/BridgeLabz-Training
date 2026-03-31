import java.util.ArrayList;

class Inventory {
    private ArrayList<Product> products;
    Inventory() {
        this.products = new ArrayList<>();
    }
    void addProduct(Product product) {
        this.products.add(product);
    }
    void removeProduct(String productName) throws OutOfStockException {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                products.remove(product);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new OutOfStockException("Product not found in inventory.");
        }
    }
    void displayInventory() {
        if (products.size() == 0) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products) {
                System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
            }
        }
    }
    void restockProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setQuantity(product.getQuantity() + quantity);
                break;
            }
        }
    }

    void sellProduct(String productName, int quantity) throws OutOfStockException {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                if (product.getQuantity() < quantity) {
                    throw new OutOfStockException("Insufficient stock for product: " + productName);
                } else {
                    product.setQuantity(product.getQuantity() - quantity);
                }
                break;
            }
        }
    }
}