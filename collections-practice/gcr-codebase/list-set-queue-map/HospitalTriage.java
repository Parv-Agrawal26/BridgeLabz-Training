import java.util.*;

public class HospitalTriage {

    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + "(severity=" + severity + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severity - a.severity);

        pq.add(new Patient("John", 2));
        pq.add(new Patient("Maya", 5));
        pq.add(new Patient("Ali", 3));

        while (!pq.isEmpty()) {
            System.out.println("Next: " + pq.remove());
        }
    }
}
