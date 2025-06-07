package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

public class OutputView {
    public void printLadder(Ladder ladder) {
        System.out.println("실행결과\n");
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append("    ");

        for (Point point : line.getPoints()) {
            sb.append("|");
            sb.append(displayConnection(point));
        }
        sb.append("|");
        System.out.println(sb);
    }

    private String displayConnection(Point point) {
        if (point.isRightConnected()) {
            return "-----";
        }
        return "     ";
    }
}
