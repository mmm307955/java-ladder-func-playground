package domain;

public enum Direction {
    LEFT,
    RIGHT,
    DOWN;

    public static Direction of(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return DOWN;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
