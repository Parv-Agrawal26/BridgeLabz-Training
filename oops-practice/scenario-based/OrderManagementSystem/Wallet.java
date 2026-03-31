class Wallet implements Payment {
    @Override
    public void processPayment(Order order, double amount) {
        System.out.println("Processing wallet payment of $" + amount + " for Order ID: " + order.orderId);
    }
}
