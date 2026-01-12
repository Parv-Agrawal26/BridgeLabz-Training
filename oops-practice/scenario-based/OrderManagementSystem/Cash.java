class Cash implements Payment {
    @Override
    public void processPayment(Order order, double amount) {
        System.out.println("Processing cash payment of $" + amount + " for Order ID: " + order.orderId);
    }
}
