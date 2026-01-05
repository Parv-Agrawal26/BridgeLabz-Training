interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    abstract double calculateDiscount();

    double finalPrice() {
        return price - calculateDiscount();
    }
}

class Electronics extends Product implements Taxable {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "GST 18%";
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.20;
    }
}

class Groceries extends Product {
    Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.05;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Electronics(1, "Laptop", 60000),
                new Clothing(2, "Shirt", 2000),
                new Groceries(3, "Rice", 1500)
        };

        for (Product p : products) {
            System.out.println("Final Price " + p.finalPrice());
        }
    }
}
