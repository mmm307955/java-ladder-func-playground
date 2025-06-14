package strategy;

import domain.strategy.PointGenerator;

public class FixedPointGenerator implements PointGenerator {
    private final boolean alwaysConnect;

    public FixedPointGenerator(boolean alwaysConnect) {
        this.alwaysConnect = alwaysConnect;
    }

    @Override
    public boolean generate() {
        return alwaysConnect;
    }
}
