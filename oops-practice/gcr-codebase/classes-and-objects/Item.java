public class Item {
    String itemName;
    int itemCode;
    double price;
    int quantity;

    Item(String itemName, int itemCode, double price, int quantity) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }
    public double totalPrice() {
        return price * quantity;
    }
    public void printDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Code: " + itemCode);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice());
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Item item1 = new Item("Item1", 101, 250, 2);
        Item item2 = new Item("Item2", 102, 350, 3);
        item1.printDetails();
        item2.printDetails();
    }
}
