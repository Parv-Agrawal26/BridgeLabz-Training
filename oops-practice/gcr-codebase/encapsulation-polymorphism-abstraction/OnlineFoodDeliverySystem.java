interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String item, double price, int qty) {
        itemName = item;
        this.price = price;
        quantity = qty;
    }

    double getPrice() {
        return price * quantity;
    }

    abstract double calculateTotalPrice();

    void getItemDetails() {
        System.out.println(itemName + " " + quantity);
    }
}

class VegItem extends FoodItem {
    VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    double calculateTotalPrice() {
        return getPrice();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    double calculateTotalPrice() {
        return getPrice() + 50;
    }

    public double applyDiscount() {
        return 20;
    }

    public String getDiscountDetails() {
        return "Flat discount";
    }
}
