public class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    public void addItem(int qty) {
        System.out.println("Added " + qty + " " + itemName + " to the cart.");
        this.quantity += qty;
    }

    public void removeItem(int qty) {
        if (qty > quantity) {
            System.out.println("Cannot remove");
        } else {
            System.out.println("Removed " + qty + " " + itemName + " from the cart.");
            this.quantity -= qty;
        }
    }

    public void totalCost() {
        double total = price * quantity;
        System.out.println("Total cost of " + itemName + ": " + total);
    }

    public static void main(String[] args) {
        CartItem cartItem = new CartItem("Laptop", 50000);
        cartItem.addItem(5);
        cartItem.totalCost();
        cartItem.removeItem(2);
        cartItem.totalCost();
    }
}
