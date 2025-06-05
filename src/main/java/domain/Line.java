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

    public static Line generate(int width, PointGenerator generator) {
        List<Point> points = new ArrayList<>();

        //첫 번째 Point
        Point first = new Point(generator.generate());
        points.add(first);

        //두 번째 Point부터 마지막 전 Point까지 가로선 생성
        Point prev = first;
        for (int i = 1; i < width; i++) {
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
