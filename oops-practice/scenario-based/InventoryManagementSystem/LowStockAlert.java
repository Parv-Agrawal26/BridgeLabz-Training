public class LowStockAlert {
    private static final int LOW_STOCK_THRESHOLD = 5;
    public static boolean isLowStock(Product product) {
        return product.getQuantity() < LOW_STOCK_THRESHOLD;
    }
}
