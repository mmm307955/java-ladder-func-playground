package domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    DOWN(0);

    private final int move;

    Direction(int move) {
        this.move = move;
    }

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
