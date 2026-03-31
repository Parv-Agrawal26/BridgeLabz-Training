import java.util.ArrayList;
public class FlightBookingSystem{
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI101", "mathura", "delhi"));
        flights.add(new Flight("BA202", "vrindavan", "kashmir"));
        flights.add(new Flight("DL303", "Paris", "nainital"));

        Passenger passenger1 = new Passenger("Rahul", "P123456");
        passenger1.bookFlight(flights.get(0));
        passenger1.displayBookedFlights();
        passenger1.searchFlight("mathura", "delhi", flights);
        passenger1.cancelFlight(flights.get(0));
        passenger1.displayBookedFlights();
    }
}

class Passenger{
    String name;
    String passportNumber;
    ArrayList<Flight> bookedFlights;
    Passenger(String name, String passportNumber){
        this.name = name;
        this.passportNumber = passportNumber;
        this.bookedFlights = new ArrayList<>();
    }

    void bookFlight(Flight flight){
        bookedFlights.add(flight);
        flight.passengers.add(this);
        System.out.println("Flight booked successfully for " + name);
    }

    void cancelFlight(Flight flight){
        bookedFlights.remove(flight);
        flight.passengers.remove(this);
        System.out.println("Flight cancelled successfully for " + name);
    }

    void displayBookedFlights(){
        System.out.println("Booked Flights for " + name + ":");
        for(Flight flight : bookedFlights){
            System.out.println("Flight Number: " + flight.flightNumber + ", From: " + flight.from + ", To: " + flight.to);
        }
    }

    void searchFlight(String from, String to, ArrayList<Flight> flights){
        for(Flight flight : flights){
            if(flight.from.equalsIgnoreCase(from) && flight.to.equalsIgnoreCase(to)) System.out.println("Flight Found: " + flight.flightNumber);
            else System.out.println("No flights found from " + from + " to " + to);
        }
    }

}

class Flight{
    String flightNumber;
    String from;
    String to;
    ArrayList<Passenger> passengers;
    Flight(String flightNumber, String from, String to){
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.passengers = new ArrayList<>();
    }
}