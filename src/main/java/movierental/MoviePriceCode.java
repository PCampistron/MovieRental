package movierental;

import java.util.function.Function;

public enum MoviePriceCode {
    REGULAR((daysRented) -> {
            double amount = 2;
            if (daysRented > 2)
                amount += (daysRented - 2) * 1.5;
            return amount;
        }
    ),
    NEW_RELEASE((daysRented) -> {
            return daysRented * 3.0;
        }
    ),
    CHILDREN((daysRented) -> {
            double thisAmount = 1.5;
            if (daysRented > 3)
                thisAmount += (daysRented - 3) * 1.5;
            return thisAmount;
        }
    );

    private Function<Integer, Double> amountRule;

    MoviePriceCode(Function<Integer, Double> amountRule) {
        this.amountRule = amountRule;
    }

    public Double computeAmount(int daysRented)
    {
        return amountRule.apply(daysRented);
    }
}
