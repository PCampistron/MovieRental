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

    private Function<Integer, Double> computeAmount;

    MoviePriceCode(Function<Integer, Double> computeAmount) {
        this.computeAmount = computeAmount;
    }

    public Function<Integer, Double> getComputeAmount() {
        return computeAmount;
    }
}
