package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointGenerator;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    //Point 수는 (width - 1)개가 생성되고, 마지막 Point는 OutputView클래스에서 "|"를 붙여 출력한다
    public static Line generate(int width, PointGenerator generator) {
        List<Point> points = new ArrayList<>();

        Point first = new Point(generator.generate());
        points.add(first);

        Point prev = first;
        for (int i = 1; i < width - 1; i++) {
            Point next = prev.connectNext(generator.generate());
            points.add(next);
            prev = next;
        }
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
