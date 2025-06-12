package domain;

import domain.strategy.PointGenerator;
import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    public static Ladder create(int width, int height, PointGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++){
            lines.add(Line.generate(width, generator));
        }
        return new Ladder(lines);
    }
}
