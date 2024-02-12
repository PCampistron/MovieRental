package movierental;

public class Movie {
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;


    private MoviePriceCode moviePriceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public Movie(String title, MoviePriceCode moviePriceCode) {
        this.moviePriceCode = moviePriceCode;
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
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
