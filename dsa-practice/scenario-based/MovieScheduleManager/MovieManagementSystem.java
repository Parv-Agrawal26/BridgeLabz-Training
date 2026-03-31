import java.util.ArrayList;

public class MovieManagementSystem {
    static final MovieManager movieManager = new MovieManager();
    public static void main(String[] args) {
        addMovie("Inception");
        addShowtime("Inception", "10:99 AM");
        addShowtime("Inception", "02:00 PM");
        addMovie("The Matrix");
        addShowtime("The Matrix", "01:00 PM");
        addShowtime("The Matrix", "05:00 PM");
        displayMovies();
        addMovie("Interstellar");
        addShowtime("Interstellar", "03:30 PM");
        searchMovie("In");
        searchMovie("fwe");
    }
    public static void displayMovies() {
        System.out.println("Movies and Showtimes:");
        for (Movie movie : movieManager.getMovies()) {
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Showtimes: " + String.join(", ", movie.getShowtimes()));
        }
    }

    public static void addMovie(String title) {
        movieManager.addMovie(title);
        System.out.println("Added movie: " + title);
    }

    public static void addShowtime(String title, String showtime){
        try {
            movieManager.addShowtime(title, showtime);
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Added showtime: " + showtime + " for movie: " + title);
    }

    public static void searchMovie(String keyword){
        System.out.println("Searching for movie with keyword "+keyword);
        boolean found = false;
        for(Movie movie : movieManager.getMovies()){
            if(movie.getTitle().contains(keyword)){
                found = true;
                System.out.println("Found "+ movie.getTitle());
            }
        }
        if(!found){
            System.out.println("No movie found with keyword "+keyword);
        }
    }

}
