abstract class ProductCategory {
    String categoryName;

    ProductCategory(String name) {
        this.categoryName = name;
    }
}

class BookCategory extends ProductCategory {
    BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    ClothingCategory() {
        super("Clothing");
    }
}

class Product<T extends ProductCategory> {
    String productName;
    double price;
    T category;

    Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
}

class Marketplace {

    static <T extends Product<?>> void applyDiscount(T product, double percent) {
        product.price = product.price - (product.price * percent / 100);
    }

    public static void main(String[] args) {

        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());

        Product<ClothingCategory> shirt = new Product<>("T Shirt", 800, new ClothingCategory());

        applyDiscount(book, 10);
        applyDiscount(shirt, 5);

        System.out.println(book.productName + " Price: " + book.price);
        System.out.println(shirt.productName + " Price: " + shirt.price);
    }
}
