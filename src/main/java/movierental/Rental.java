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
        if(getMovie().getMoviePriceCode() != null)
        {
            return getMovie().getMoviePriceCode().getComputeAmount().apply(getDaysRented());
        }

        return 0;
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
        return "\t" + getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
