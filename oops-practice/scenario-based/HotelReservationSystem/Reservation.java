public class Reservation {
    Guest guest;
    Room room;
    int days;

    public Reservation(Guest guest, Room room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }
}
