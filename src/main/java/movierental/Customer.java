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
            double thisAmount = rental.determineAmounts();
            frequentRenterPoints += rental.frequentRenterPoints();
            result += rental.showFiguresForThisRental(thisAmount);
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

}
