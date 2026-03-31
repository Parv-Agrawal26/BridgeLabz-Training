import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();

    static void bookRoom(Guest guest, int roomNo, int days) throws RoomNotAvailableException {
        for (Room room : rooms) {
            if (room.roomNumber == roomNo) {
                if (!room.available) {
                    throw new RoomNotAvailableException("Room not available");
                }

                room.available = false;
                reservations.add(new Reservation(guest, room, days));

                System.out.println("Bill Amount: " + room.calculatePrice(days));
                return;
            }
        }
        System.out.println("Room not found");
    }

    public static void main(String[] args) {
        rooms.add(new StandardRoom(101, 2000));
        rooms.add(new DeluxeRoom(201, 4000));

        Guest guest = new Guest("Ravi");

        try {
            bookRoom(guest, 101, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
