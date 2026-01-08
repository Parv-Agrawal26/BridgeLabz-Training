import java.util.HashMap;
import java.util.Map;

public class RoundRobinSchedulingUsingCircular {
    public static void main(String[] args) {
        CircularProcessQueue queue = new CircularProcessQueue();

        queue.addProcess(new Process(1, 8, 2));
        queue.addProcess(new Process(2, 4, 1));
        queue.addProcess(new Process(3, 9, 3));
        queue.addProcess(new Process(4, 5, 2));

        int timeQuantum = 3;
        System.out.println("Initial circular queue:");
        queue.display();

        System.out.println("\nSimulating Round Robin (time quantum = " + timeQuantum + "):");
        queue.simulate(timeQuantum);
    }

    static final class Process {
        final int processId;
        final int burstTime;
        final int priority;

        Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
        }
    }

    static final class CircularProcessQueue {
        private static final class Node {
            final Process data;
            int remaining;
            Node next;

            Node(Process data) {
                this.data = data;
                this.remaining = data.burstTime;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        private final Map<Integer, Integer> completionTimeByPid = new HashMap<>();
        private final Map<Integer, Integer> burstByPid = new HashMap<>();

        void addProcess(Process process) {
            Node newNode = new Node(process);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
            size++;
            burstByPid.put(process.processId, process.burstTime);
            System.out.println("Process added: PID=" + process.processId);
        }

        void display() {
            if (head == null) {
                System.out.println("No processes in queue.");
                return;
            }
            Node current = head;
            do {
                System.out.println(
                        "PID: " + current.data.processId + ", Burst: " + current.data.burstTime + ", Remaining: "
                                + current.remaining + ", Priority: " + current.data.priority);
                current = current.next;
            } while (current != head);
        }

        void simulate(int timeQuantum) {
            if (timeQuantum <= 0) {
                System.out.println("Invalid time quantum.");
                return;
            }
            if (head == null) {
                System.out.println("No processes to schedule.");
                return;
            }

            int time = 0;
            Node current = head;

            while (size > 0) {
                int runFor = Math.min(timeQuantum, current.remaining);
                System.out.println("\nExecuting PID " + current.data.processId + " for " + runFor + " units");
                current.remaining -= runFor;
                time += runFor;

                if (current.remaining == 0) {
                    completionTimeByPid.put(current.data.processId, time);
                    int completedPid = current.data.processId;

                    Node next = current.next;
                    removeCurrent(current);
                    System.out.println("Process PID " + completedPid + " completed and removed");

                    if (size == 0) {
                        break;
                    }

                    current = next;
                } else {
                    current = current.next;
                }

                System.out.println("Queue after this round:");
                display();
            }

            printAverages();
        }

        private void removeCurrent(Node node) {
            if (head == null || node == null) {
                return;
            }

            if (size == 1 && node == head) {
                head = null;
                tail = null;
                size = 0;
                return;
            }

            Node prev = tail;
            Node current = head;
            do {
                if (current == node) {
                    break;
                }
                prev = current;
                current = current.next;
            } while (current != head);

            if (current != node) {
                return;
            }

            if (node == head) {
                head = head.next;
                tail.next = head;
                prev.next = head;
            } else {
                prev.next = node.next;
                if (node == tail) {
                    tail = prev;
                }
            }

            size--;
        }

        private void printAverages() {
            if (completionTimeByPid.isEmpty()) {
                System.out.println("No completed processes.");
                return;
            }

            double totalTurnaround = 0;
            double totalWaiting = 0;

            System.out.println("\nFinal Times (Arrival assumed 0 for all):");
            for (Map.Entry<Integer, Integer> entry : completionTimeByPid.entrySet()) {
                int pid = entry.getKey();
                int completion = entry.getValue();
                int burst = burstByPid.get(pid);

                int turnaround = completion;
                int waiting = turnaround - burst;

                totalTurnaround += turnaround;
                totalWaiting += waiting;

                System.out.println("PID " + pid + " -> Completion: " + completion + ", Turnaround: " + turnaround
                        + ", Waiting: " + waiting);
            }

            double avgWaiting = totalWaiting / completionTimeByPid.size();
            double avgTurnaround = totalTurnaround / completionTimeByPid.size();

            System.out.println("\nAverage Waiting Time: " + avgWaiting);
            System.out.println("Average Turnaround Time: " + avgTurnaround);
        }
    }
}
