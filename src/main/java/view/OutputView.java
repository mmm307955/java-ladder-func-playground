package view;

import domain.Ladder;
import domain.Line;
import domain.Point;
import domain.ResultCalculator;
import java.util.List;

public class OutputView {
    public void printLadder(Ladder ladder) {
        System.out.println("\n실행결과\n");
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
        System.out.println();
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append("    ");

        List<Point> points = line.getPoints();
        for (int i = 0; i < points.size(); i++) {
            sb.append("|");
            appendConnectionIfNeeded(sb, points, i);
        }
        System.out.println(sb);
    }

    private void appendConnectionIfNeeded(StringBuilder sb, List<Point> points, int index) {
        if (index < points.size() - 1) {
            sb.append(displayConnection(points.get(index)));
        }
    }

    private String displayConnection(Point point) {
        if (point.isMovableToRight()) {
            return "-----";
        }
        return "     ";
    }

    public void printResult(int ladderWidth, ResultCalculator resultCalculator) {
        for (int i = 0; i < ladderWidth; i++) {
            int result = resultCalculator.calculateResult(i);
            System.out.printf("%d -> %d\n", i, result);
        }
    }
}
