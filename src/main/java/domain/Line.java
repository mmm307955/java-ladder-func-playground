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
        addPoints(points, width, generator);
        return new Line(points);
    }

    private static void addPoints(List<Point> points, int width, PointGenerator generator) {
        boolean right = generator.generate();
        Point first = Point.first(right);
        points.add(first);

        Point prev = first;
        for (int i = 1; i < width; i++) {
            boolean nextRight = generator.generate();
            Point next = prev.next(nextRight);
            points.add(next);
            prev = next;
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int index) {
        if (canMoveRight(index)) {
            return index + 1;
        }
        if (canMoveLeft(index)) {
            return index - 1;
        }
        return index;
    }

    //마지막 point보다 하나 작을 때까지만 오른쪽으로 이동할 수 있다.
    private boolean canMoveRight(int index) {
        return index < points.size() - 1 && points.get(index).isMovableToRight();
    }

    //인덱스가 0보다 커야 왼쪽으로 이동할 수 있다.
    private boolean canMoveLeft(int index) {
        return index > 0 && points.get(index - 1).isMovableToRight();
    }
}
