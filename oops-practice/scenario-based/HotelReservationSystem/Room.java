public abstract class Room implements PricingStrategy {
    int roomNumber;
    boolean available = true;
    double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }
}
