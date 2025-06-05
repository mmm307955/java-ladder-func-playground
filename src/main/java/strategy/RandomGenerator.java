package strategy;

import java.util.Random;

public class RandomGenerator implements PointGenerator {
    private final static Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
