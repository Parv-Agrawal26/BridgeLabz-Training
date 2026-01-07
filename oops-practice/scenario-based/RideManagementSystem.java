import java.util.ArrayList;
import java.util.List;

public class RideManagementSystem {
    static List<Driver> driverList=new ArrayList<>();
    static List<Ride> rideList=new ArrayList<>();
    static Driver assignDriver() throws NoDriverAvailableException{
        for(Driver driver : driverList){
            if(driver.available){
                driver.available=false;
                return driver;
            }
        }
        throw new NoDriverAvailableException("No driver available right now");

    }
    static Ride bookRide(User user, String from, String to, boolean isPeak) throws NoDriverAvailableException {
        Driver driver = assignDriver();
        FareCalculator fareCalculator = isPeak ? new PeakFareCalculator() : new NormalFareCalculator();
        int fare = fareCalculator.calculateFare((int)(Math.random()*100));
        Ride newRide = new Ride(driver, user, (int)(Math.random()*1000), from,to,fare);
        rideList.add(newRide);
        return newRide;
    }

    public static void main(String[] args) {
        driverList.add(new Driver("Ramesh", 1));
        driverList.add(new Driver("Suresh", 2));
        User u1 = new User("Rohan", 1);
        try {
            Ride ride = bookRide(u1, "Agra", "Delhi", false);
            System.out.println("Ride booked with " + ride.driver.name + " | Fare: " + ride.fare);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class NoDriverAvailableException extends Exception {
    NoDriverAvailableException(String message) {
        super(message);
    }
}

class User {
    String name;
    int id;

    User(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Driver {
    String name;
    int id;
    boolean available=true;

    Driver(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Ride {
    int bookingId;
    String from;
    String to;
    Driver driver;
    User user;
    int fare;

    Ride(Driver driver, User user, int bookingId, String from, String to, int fare) {
        this.bookingId = bookingId;
        this.from = from;
        this.to = to;
        this.driver = driver;
        this.user = user;
        this.fare = fare;
    }
}

interface FareCalculator {
    int calculateFare(int distance);
}

class NormalFareCalculator implements FareCalculator{
    public int calculateFare(int distance){
        return distance*10;
    }
}

class PeakFareCalculator implements FareCalculator {
    public int calculateFare(int distance) {
        return distance * 20;
    }
}