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
        String result = addHeaderLine();

        result += "<table>\n";

        for (Rental rental : rentals) {
            result += rental.showFiguresForThisRental(rental.determineAmounts());
        }

        result += "</table>\n";

        // add footer lines
        result += addFooterLines(totalAmount(), frequentRenterPoints());

        return result;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.determineAmounts();
        }
        return totalAmount;
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private String addHeaderLine() {
        return "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
    }

    private static String addFooterLines(double totalAmount, int frequentRenterPoints) {
        return "<p>Amount owed is <em>" + totalAmount + "</em></p>\n" + "<p>You earned <em>" + frequentRenterPoints + "</em> frequent renter points</p>";
    }

}
