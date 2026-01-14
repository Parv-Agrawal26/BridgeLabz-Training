class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    static int findStartPoint(PetrolPump[] pumps) {
        int totalBalance = 0;
        int currentBalance = 0;
        int start = 0;

        for (int index = 0; index < pumps.length; index++) {
            totalBalance += pumps[index].petrol - pumps[index].distance;
            currentBalance += pumps[index].petrol - pumps[index].distance;

            if (currentBalance < 0) {
                start = index + 1;
                currentBalance = 0;
            }
        }

        return totalBalance >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        System.out.println("Start Point: " + findStartPoint(pumps));
    }
}
