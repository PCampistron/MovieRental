package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double determineAmounts() {
        return getMovie().getMoviePriceCode().computeAmount(getDaysRented());
    }

    int addBonusForTwoDayNewReleaseRental() {
        if ((getMovie().getMoviePriceCode() == MoviePriceCode.NEW_RELEASE) && getDaysRented() > 1)
            return 1;
        return 0;
    }

    int frequentRenterPoints() {
        return 1 + addBonusForTwoDayNewReleaseRental();
    }

    String showFiguresForThisRental(double thisAmount) {
        return "<tr><td>" + getMovie().getTitle() + "</td><td>" + thisAmount + "</td></tr>\n";
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
