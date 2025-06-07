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

    // 테스트용 메서드입니다.
    public static Ladder generate(int width, int height, PointGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(width, generator));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int result(int startX) {
        int x = startX;
        for (Line line : lines) {
            x = line.move(x);
        }
        return x;
    }
}
