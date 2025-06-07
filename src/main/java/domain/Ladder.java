package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointGenerator;
import strategy.RandomGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder generate(int width, int height) {
        PointGenerator generator = new RandomGenerator();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(width, generator));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
