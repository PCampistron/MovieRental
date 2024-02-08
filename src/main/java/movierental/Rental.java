package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    static double determineAmountsForEachLine(Rental rental) {
        double thisAmount = 0;

        //determine amounts for each line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    static int addBonusForTwoDayNewReleaseRental(Rental rental) {
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            return 1;
        return 0;
    }

    static int addFrequentRenterPoints(Rental rental) {
        return 1 + addBonusForTwoDayNewReleaseRental(rental);
    }

    static String showFiguresForThisRental(Rental rental, double thisAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
}
