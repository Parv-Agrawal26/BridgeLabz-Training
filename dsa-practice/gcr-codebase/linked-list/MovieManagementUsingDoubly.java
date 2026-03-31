public class MovieManagementUsingDoubly {
    public static void main(String[] args) {
        LinkedList movieList = new LinkedList();

        MovieData movie1 = new MovieData("Inception", "Christopher Nolan", "2010-07-16", 9);
        MovieData movie2 = new MovieData("The Matrix", "The Wachowskis", "1999-03-31", 8);
        MovieData movie3 = new MovieData("Interstellar", "Christopher Nolan", "2014-11-07", 9);

        movieList.addAtFirst(movie1);
        movieList.addAtLast(movie2);
        movieList.addAtPos(movie3, 1);

        System.out.println("Displaying all movie records forward:");
        movieList.displayRecordsForward();

        System.out.println("\nDisplaying all movie records backward:");
        movieList.displayRecordsBackward();

        System.out.println("\nSearching for title 'The Matrix':");
        movieList.searchByTitle("The Matrix");

        System.out.println("\nSearching for director 'Christopher Nolan':");
        movieList.searchByDirector("Christopher Nolan");

        System.out.println("\nUpdating rating for title 'Inception' to 10:");
        movieList.updateRatingByTitle("Inception", 10);

        System.out.println("\nDisplaying all movie records forward:");
        movieList.displayRecordsForward();

        System.out.println("\nDeleting record with title 'The Matrix':");
        movieList.deleteByTitle("The Matrix");

        System.out.println("\nDisplaying all movie records forward:");
        movieList.displayRecordsForward();
    }
}
class Node{
    MovieData data;
    Node next;
    Node prev;
    Node(MovieData data){
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}

class MovieData{
    String title;
    String director;
    String date;
    int rating;
    MovieData(String title, String director, String date, int rating){
        this.title = title;
        this.director = director;
        this.date = date;
        this.rating = rating;
    }
}

class LinkedList{
    Node head;
    Node tail;
    void addAtFirst(MovieData data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail=newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie record added at first");
    }

    void addAtLast(MovieData data){
        Node newNode = new Node(data);
        if(tail == null){
            head = newNode;
            tail=newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie record added at last");
    }

    void addAtPos(MovieData data, int pos){
        Node newNode = new Node(data);
        if(pos == 0){
            addAtFirst(data);
            return;
        }
        Node current = head;
        for(int i=0; i<pos-1; i++){
            if(current.next == null){
                break;
            }
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if(current.next != null){
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        System.out.println("Movie record added at position " + pos);
    }

    void deleteByTitle(String title){
        Node current = head;
        if(current != null && current.data.title.equals(title)){
            head = current.next;
            if(head != null){
                head.prev = null;
            } else {
                tail = null;
            }
            System.out.println("Record with title " + title + " deleted");
            return;
        }
        while(current.next !=null){
            if(current.next.data.title.equals(title)){
                current.next = current.next.next;
                if(current.next != null){
                    current.next.prev = current;
                } else {
                    tail = current;
                }
                System.out.println("Record with title " + title + " deleted");
                return;
            }
            current = current.next;
        }
    }

    void displayRecordsForward(){
        Node current = head;
        while(current != null){
            System.out.println("Title: " + current.data.title + ", Director: " + current.data.director + ", Date: " + current.data.date + ", Rating: " + current.data.rating);
            current = current.next;
        }
    }

    void displayRecordsBackward(){
        Node current = tail;
        while(current != null){
            System.out.println("Title: " + current.data.title + ", Director: " + current.data.director + ", Date: " + current.data.date + ", Rating: " + current.data.rating);
            current = current.prev;
        }
    }

    void searchByTitle(String title){
        Node current = head;
        while(current != null){
            if(current.data.title.equals(title)){
                System.out.println("Found Movie - Title: " + current.data.title + ", Director: " + current.data.director + ", Date: " + current.data.date + ", Rating: " + current.data.rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title " + title + " not found");
    }

    void searchByDirector(String director){
        Node current = head;
        while(current != null){
            if(current.data.director.equals(director)){
                System.out.println("Found Movie - Title: " + current.data.title + ", Director: " + current.data.director + ", Date: " + current.data.date + ", Rating: " + current.data.rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with director " + director + " not found");
    }

    void updateRatingByTitle(String title, int newRating){
        Node current = head;
        while(current != null){
            if(current.data.title.equals(title)){
                current.data.rating = newRating;
                System.out.println("Record with title " + title + " updated with new rating " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Record with title " + title + " not found");
    }
}