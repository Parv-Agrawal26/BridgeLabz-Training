public class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    private boolean isBooked = false;

    public void bookTicket(String movieName, int seatNumber, double price) {
        if(isBooked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
            return;
        }
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = true;
        System.out.println("Booked successfully!!!");
    }

    public void printDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet...");
            return;
        }
        System.out.println("Ticket booked for movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();
        ticket1.bookTicket("Inception", 45, 300.0);
        ticket1.printDetails();
        System.out.println();

        MovieTicket ticket2 = new MovieTicket();
        ticket2.printDetails();
        ticket2.bookTicket("Interstellar", 30, 350.0);
        ticket2.printDetails();
        System.out.println();

        ticket1.bookTicket("Inception", 45, 300.0);
    }

}
