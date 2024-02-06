package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = addHeaderLine();

        for (Rental each : _rentals) {
            double thisAmount = determineAmountsForEachLine(each);

            frequentRenterPoints += getFrequentRenterPoints(each);

            // show figures for this rental
            result += showFiguresForThisRental(each, thisAmount);
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
        return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }

    private static String showFiguresForThisRental(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
    }

    private static int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoints;
        // add frequent renter points
        frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            frequentRenterPoints += 1;
        return frequentRenterPoints;
    }

    private static double determineAmountsForEachLine(Rental each) {
        double thisAmount = 0;

        //determine amounts for each line
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
