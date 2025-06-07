package domain;

public class Point {
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    //처음 Point에서는 왼쪽에 이어지지 않으므로 left는 false이다.
    public static Point first(boolean right) {
        return new Point(Direction.of(false, right));
    }

    public Point next(boolean right) {
        boolean left = this.direction.isRight();
        boolean nextRight = !left && right; // 이전 점이 오른쪽으로 연결되지 않았고, 현재 generator가 true면 오른쪽 연결한다.
        return new Point(Direction.of(left, nextRight));
    }

    public boolean isMovableToRight() {
        return direction.isRight();
    }
}
