class UPI implements Payment {
    @Override
    public void processPayment(Order order, double amount) {
        System.out.println("Processing UPI payment of $" + amount + " for Order ID: " + order.orderId);
    }
}