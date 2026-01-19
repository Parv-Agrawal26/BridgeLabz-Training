
import java.util.LinkedList;
import java.util.Queue;

class TrafficManager {

    static class CarNode {
        String carNumber;
        CarNode next;

        CarNode(String carNumber) {
            this.carNumber = carNumber;
            this.next = null;
        }
    }

    private CarNode head = null;
    private Queue<String> waitingQueue = new LinkedList<>();
    private int maxQueueSize = 5;

    void addCarToRoundabout(String carNumber) {

        if (head == null) {
            head = new CarNode(carNumber);
            head.next = head;
            return;
        }

        CarNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        CarNode newCar = new CarNode(carNumber);
        temp.next = newCar;
        newCar.next = head;
    }

    void removeCar(String carNumber) {

        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        CarNode curr = head;
        CarNode prev = null;

        do {
            if (curr.carNumber.equals(carNumber)) {

                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    CarNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = curr.next;
                    last.next = head;
                }
                System.out.println("Car removed: " + carNumber);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Car not found");
    }

    void enqueueCar(String carNumber) {

        if (waitingQueue.size() == maxQueueSize) {
            System.out.println("Queue Overflow");
            return;
        }
        waitingQueue.add(carNumber);
    }

    void allowCarEntry() {

        if (waitingQueue.isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        addCarToRoundabout(waitingQueue.poll());
    }

    void displayRoundabout() {

        if (head == null) {
            System.out.println("No cars in roundabout");
            return;
        }

        CarNode temp = head;
        do {
            System.out.print(temp.carNumber + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    public static void main(String[] args) {

        TrafficManager manager = new TrafficManager();
        manager.enqueueCar("DL01");
        manager.enqueueCar("DL02");
        manager.allowCarEntry();
        manager.allowCarEntry();
        manager.displayRoundabout();
    }
}
