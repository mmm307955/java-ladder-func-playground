package domain;

import domain.strategy.PointGenerator;
import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    private final int width;
    private final int height;

    public LadderGenerator(int width, int height) {
        validate(width, height);
        this.width = width;
        this.height = height;
    }

    private void validate(int width, int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("사다리의 넓이와 높이는 1 이상이어야 합니다.");
        }
    }

    public Ladder create(PointGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(width, generator));
        }
        return new Ladder(lines);
    }
}
