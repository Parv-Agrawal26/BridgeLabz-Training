import java.util.ArrayList;

public class MovieManager {
    private ArrayList<Movie> movies;
    MovieManager() {
        movies = new ArrayList<>();
    }
    public void addMovie(String title) {
        movies.add(new Movie(title));
    }

    public void addShowtime(String title, String showtime) throws InvalidTimeFormatException, IndexOutOfBoundsException {
        if (showtime == null || showtime.length() != 8)
            throw new InvalidTimeFormatException("Invalid time format: " + showtime);

        int hour = Integer.parseInt(showtime.substring(0, 2));
        int minute = Integer.parseInt(showtime.substring(3, 5));
        String period = showtime.substring(6, 8);

        if (hour < 01 || hour > 12 ||
                minute < 0 || minute > 59 ||
                !(period.equals("AM") || period.equals("PM"))) {
            throw new InvalidTimeFormatException("Invalid time format: " + showtime);
        }

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movie.getShowtimes().add(showtime);
                return;
            }
        }
        System.out.println("Movie not found: " + title);
        throw new IndexOutOfBoundsException("Movie not found: " + title);
    }
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}