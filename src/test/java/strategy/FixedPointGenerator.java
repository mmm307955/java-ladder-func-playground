package strategy;

import domain.strategy.PointGenerator;

public class FixedPointGenerator implements PointGenerator {
    private final boolean value;

    public FixedPointGenerator(boolean value) {
        this.value = value;
    }

    @Override
    public boolean generate() {
        return value;
    }
}
