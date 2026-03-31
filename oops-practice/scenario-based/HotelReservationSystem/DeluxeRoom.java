public class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int days) {
        return (basePrice * days) + 1000;
    }
}
