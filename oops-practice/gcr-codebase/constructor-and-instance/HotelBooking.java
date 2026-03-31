public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "NA";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking oldBooking) {
        this.guestName = oldBooking.guestName;
        this.roomType = oldBooking.roomType;
        this.nights = oldBooking.nights;
    }

    void display() {
        System.out.println(guestName + " " + roomType + " " + nights);
    }

    public static void main(String[] args) {
        HotelBooking h1 = new HotelBooking();
        HotelBooking h2 = new HotelBooking("Rahul", "Deluxe", 3);
        HotelBooking h3 = new HotelBooking(h2);
        h1.display();
        h2.display();
        h3.display();
    }
}
