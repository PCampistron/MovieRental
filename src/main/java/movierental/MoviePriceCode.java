package movierental;

import java.util.function.Function;

public enum MoviePriceCode {
    REGULAR((daysRented) -> {
            double amount = 2;
            if (daysRented > 2)
                amount += (daysRented - 2) * 1.5;
            return amount;
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
