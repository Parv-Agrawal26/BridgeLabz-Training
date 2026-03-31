public class TrafficManager {
    VehicleNode head = null;

    String[] queue = new String[5];
    int front = 0, rear = 0, count = 0;

    void addToRoundabout(String num) {
        VehicleNode node = new VehicleNode(num);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            VehicleNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }
    }

    void printRoundabout() {
        if (head == null) {
            System.out.println("No vehicles");
            return;
        }
        VehicleNode temp = head;
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    void enqueue(String num) {
        if (count == queue.length) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[rear] = num;
        rear = (rear + 1) % queue.length;
        count++;
    }

    String dequeue() {
        if (count == 0) {
            System.out.println("Queue Underflow");
            return null;
        }
        String value = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return value;
    }

    void printQueue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < count; i++) {
            int idx = (front + i) % queue.length;
            System.out.print(queue[idx] + (i == count - 1 ? "" : ", "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager();

        tm.addToRoundabout("MH12AB1234");
        tm.addToRoundabout("MH12CD5678");
        tm.addToRoundabout("MH12EF9012");
        tm.printRoundabout();

        tm.enqueue("KA01AA0001");
        tm.enqueue("DL03BB0002");
        tm.printQueue();

        System.out.println("Dequeued: " + tm.dequeue());
        tm.printQueue();
    }
}
