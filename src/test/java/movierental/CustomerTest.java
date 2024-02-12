package movierental;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void test() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", MoviePriceCode.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", MoviePriceCode.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", MoviePriceCode.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", MoviePriceCode.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", MoviePriceCode.CHILDREN), 3));
        customer.addRental(new Rental(new Movie("Toy Story", MoviePriceCode.CHILDREN), 4));

        String expected = "" +
                "<h1>Rental Record for <em>Bob</em></h1>\n" +
                "<table>\n" +
                "  <tr><td>Jaws</td><td>2.0\n" +
                "  <tr><td>Golden Eye</td><td>3.5</td></tr>\n" +
                "  <tr><td>Short New</td><td>3.0</td></tr>\n" +
                "  <tr><td>Long New</td><td>6.0</td></tr>\n" +
                "  <tr><td>Bambi</td><td>1.5</td></tr>\n" +
                "  <tr><td>Toy Story</td><td>3.0</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>19.0</em></p>\n" +
                "<p>You earned <em>7</em> frequent renter points</p>";

        assertEquals(expected, customer.statement());
    }
}