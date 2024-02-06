package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = addHeaderLine();

        for (Rental rental : rentals) {
            double thisAmount = determineAmountsForEachLine(rental);

            frequentRenterPoints += getFrequentRenterPoints(rental);

            // show figures for this rental
            result += showFiguresForThisRental(rental, thisAmount);
            totalAmount += thisAmount;
        }

        // add footer lines
        result += addFooterLines(totalAmount, frequentRenterPoints);

        return result;
    }

    private String addHeaderLine() {
        return "Rental Record for " + getName() + "\n";
    }

    private static String addFooterLines(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points";
    }

    private static String showFiguresForThisRental(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    private static int getFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints;
        // add frequent renter points
        frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            frequentRenterPoints += 1;
        return frequentRenterPoints;
    }

    private static double determineAmountsForEachLine(Rental rental) {
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
}
