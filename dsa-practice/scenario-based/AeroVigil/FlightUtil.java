public class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (!flightNumber.matches("FL-\\d{4}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }

        String numericPart = flightNumber.substring(3);
        int flightNum = Integer.parseInt(numericPart);
        if (flightNum < 1000 || flightNum > 9999) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }

        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!flightName.equals("SpiceJet") && !flightName.equals("Vistara") &&
                !flightName.equals("IndiGo") && !flightName.equals("Air Arabia")) {
            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }

        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        if (passengerCount <= 0) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }

        int maxCapacity;
        switch (flightName) {
            case "SpiceJet":
                maxCapacity = 396;
                break;
            case "Vistara":
                maxCapacity = 615;
                break;
            case "IndiGo":
                maxCapacity = 230;
                break;
            case "Air Arabia":
                maxCapacity = 130;
                break;
            default:
                maxCapacity = 0;
                break;
        }

        if (passengerCount > maxCapacity) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }

        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxFuelCapacity;
        switch (flightName) {
            case "SpiceJet":
                maxFuelCapacity = 200000;
                break;
            case "Vistara":
                maxFuelCapacity = 300000;
                break;
            case "IndiGo":
                maxFuelCapacity = 250000;
                break;
            case "Air Arabia":
                maxFuelCapacity = 150000;
                break;
            default:
                maxFuelCapacity = 0;
                break;
        }

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuelCapacity) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        return maxFuelCapacity - currentFuelLevel;
    }
}
