import java.util.ArrayList;

public class Movie {
    private String title;
    private ArrayList<String> showtimes;
    Movie(String title) {
        this.title = title;
        this.showtimes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getShowtimes() {
        return showtimes;
    }
}
