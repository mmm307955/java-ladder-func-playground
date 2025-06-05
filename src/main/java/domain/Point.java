package domain;

public class Point {
    /**
     * 현재 Point에서 오른쪽으로 선이 연결되어 있는지 여부
     */
    private final boolean isRightConnected;

    public Point(boolean isRightConnected) {
        this.isRightConnected = isRightConnected;
    }

    /**
     * 다음 Point를 생성한다. 이전 점이 오른쪽으로 연결돼 있으면, 이번 점은 무조건 연결 되지 않는다.
     */
    public Point connectNext(boolean canConnectRight) {
        if (this.isRightConnected) {
            return new Point(false);
        }
        return new Point(canConnectRight);
    }

    public boolean isRightConnected() {
        return isRightConnected;
    }
}
