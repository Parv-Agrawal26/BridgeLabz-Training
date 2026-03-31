public class OnlineTicketReservationUsingCircular {
    public static void main(String[] args) {
        TicketCircle tickets = new TicketCircle();

        tickets.addTicket(new Ticket(1001, "Alice", "Inception", "A1", "2026-01-08 10:15"));
        tickets.addTicket(new Ticket(1002, "Bob", "Interstellar", "B5", "2026-01-08 10:20"));
        tickets.addTicket(new Ticket(1003, "Charlie", "Inception", "A2", "2026-01-08 10:25"));

        System.out.println("Current tickets:");
        tickets.display();
        System.out.println("Total booked tickets: " + tickets.count());

        System.out.println("\nSearch by customer name 'Bob':");
        tickets.searchByCustomerName("Bob");

        System.out.println("\nSearch by movie name 'Inception':");
        tickets.searchByMovieName("Inception");

        System.out.println("\nRemove Ticket ID 1002:");
        tickets.removeByTicketId(1002);

        System.out.println("\nCurrent tickets:");
        tickets.display();
        System.out.println("Total booked tickets: " + tickets.count());
    }

    static final class Ticket {
        final int ticketId;
        final String customerName;
        final String movieName;
        final String seatNumber;
        final String bookingTime;

        Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }
    }

    static final class TicketCircle {
        private static final class Node {
            Ticket data;
            Node next;

            Node(Ticket data) {
                this.data = data;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        void addTicket(Ticket ticket) {
            Node newNode = new Node(ticket);
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
            System.out.println("Ticket booked: " + ticket.ticketId);
        }

        boolean removeByTicketId(int ticketId) {
            if (head == null) {
                System.out.println("No tickets to remove.");
                return false;
            }

            Node current = head;
            Node prev = tail;
            do {
                if (current.data.ticketId == ticketId) {
                    if (size == 1) {
                        head = null;
                        tail = null;
                    } else if (current == head) {
                        head = head.next;
                        tail.next = head;
                    } else {
                        prev.next = current.next;
                        if (current == tail) {
                            tail = prev;
                        }
                    }
                    size--;
                    System.out.println("Ticket cancelled: " + ticketId);
                    return true;
                }
                prev = current;
                current = current.next;
            } while (current != head);

            System.out.println("Ticket ID " + ticketId + " not found.");
            return false;
        }

        void display() {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }
            Node current = head;
            do {
                printTicket(current.data);
                current = current.next;
            } while (current != head);
        }

        void searchByCustomerName(String customerName) {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }
            boolean found = false;
            Node current = head;
            do {
                if (current.data.customerName.equalsIgnoreCase(customerName)) {
                    printTicket(current.data);
                    found = true;
                }
                current = current.next;
            } while (current != head);

            if (!found) {
                System.out.println("No ticket found for customer '" + customerName + "'");
            }
        }

        void searchByMovieName(String movieName) {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }
            boolean found = false;
            Node current = head;
            do {
                if (current.data.movieName.equalsIgnoreCase(movieName)) {
                    printTicket(current.data);
                    found = true;
                }
                current = current.next;
            } while (current != head);

            if (!found) {
                System.out.println("No ticket found for movie '" + movieName + "'");
            }
        }

        int count() {
            return size;
        }

        private static void printTicket(Ticket t) {
            System.out.println("Ticket ID: " + t.ticketId + ", Customer: " + t.customerName + ", Movie: " + t.movieName
                    + ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
        }
    }
}
