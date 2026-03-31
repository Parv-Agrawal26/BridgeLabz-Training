class Customer {
    String name;
    String email;
    Customer(String name, String email){
        this.name = name;
        this.email = email;
    }
    void displayCustomerInfo(){
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Email: " + email);
    }
    void placeOrder(Order order, Payment paymentMethod) throws PaymentFailedException{
        System.out.println("Placing order for product: " + order.product.name + " by customer: " + name);
        paymentMethod.processPayment(order, order.product.price);
        order.status = "Placed";
        System.out.println("Order placed successfully for Order ID: " + order.orderId);
    }
    void cancelOrder(Order order){
        order.status = "Cancelled";
        System.out.println("Order for product: " + order.product.name + " has been cancelled by customer: " + name);
    }
}