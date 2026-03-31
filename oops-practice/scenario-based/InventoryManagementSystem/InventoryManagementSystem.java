public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product product1 = new Product("Laptop", 800.00, 10);
        Product product2 = new Product("Smartphone", 500.00, 20);
        Product product3 = new Product("Tablet", 300.00, 15);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        System.out.println("Current Inventory:");
        inventory.displayInventory();
        try {
            System.out.println("\nRemoving 'Smartphone' from inventory.");
            inventory.removeProduct("Smartphone");
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
        try {
            System.out.println("\nTrying to remove 'Camera' from inventory.");
            inventory.removeProduct("Camera");
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nRestocking 'Laptop' by 5 units.");
        inventory.restockProduct("Laptop", 5);
        System.out.println("\nInventory after restocking:");
        inventory.displayInventory();
        System.out.println("\nSelling 8 units of 'Tablet'.");
        try {
            inventory.sellProduct("Tablet", 8);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nInventory after selling:");
        inventory.displayInventory();

        System.out.println("\nAttempting to sell 20 units of 'Laptop'.");
        try {
            inventory.sellProduct("Laptop", 20);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        LowStockAlert alert = new LowStockAlert();
        for (Product product : new Product[]{product1, product2, product3}) {
            if (LowStockAlert.isLowStock(product)) {
                System.out.println("Low stock alert for product: " + product.getName());
            }
        }
    }
}
