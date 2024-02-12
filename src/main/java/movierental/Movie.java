package movierental;

public class Movie {
    private String title;

    private MoviePriceCode moviePriceCode;

    public Movie(String title, MoviePriceCode moviePriceCode) {
        this.moviePriceCode = moviePriceCode;
        this.title = title;
    }

    public MoviePriceCode getMoviePriceCode() {
        return moviePriceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }
    public String getTitle() {
        return title;
    }


}
