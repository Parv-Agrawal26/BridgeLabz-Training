import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String itemName;

    WarehouseItem(String itemName) {
        this.itemName = itemName;
    }

    abstract void showDetails();
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }

    void showDetails() {
        System.out.println("Electronics Item : " + itemName);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }

    void showDetails() {
        System.out.println("Grocery Item : " + itemName);
    }
}

class Storage<T extends WarehouseItem> {

    List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }

    static void displayAll(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            item.showDetails();
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStore = new Storage<>();
        electronicsStore.addItem(new Electronics("Laptop"));
        electronicsStore.addItem(new Electronics("Mobile"));
        Storage<Groceries> groceryStore = new Storage<>();
        groceryStore.addItem(new Groceries("Rice"));
        groceryStore.addItem(new Groceries("Oil"));

        displayAll(electronicsStore.getItems());
        displayAll(groceryStore.getItems());
    }
}
