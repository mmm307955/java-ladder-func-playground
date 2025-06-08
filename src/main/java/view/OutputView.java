package view;

import domain.Ladder;
import domain.Line;
import domain.OperationResult;
import domain.OperationResults;
import domain.Participants;
import domain.Point;
import domain.ResultCalculator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void printLadderResult(Ladder ladder, Participants participants,
        OperationResults operationResults) {
        System.out.println("\n사다리 결과\n");
        printParticipantsNames(participants.names());
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
        printOperationResults(operationResults.getOperationResults());
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

    public void printParticipantsNames(List<String> names) {
        StringBuilder sb = new StringBuilder("  ");
        for (String name : names) {
            sb.append(String.format("%-6s", name));
        }
        System.out.println(sb);
    }

    public void printOperationResults(List<OperationResult> results) {
        String result = results.stream()
            .map(r -> String.format("%-6s", r.getValue()))
            .collect(Collectors.joining());
        System.out.println("   " + result);
    }

    public void printAllResults(Participants participants, OperationResults operationResults,
        ResultCalculator resultCalculator) {
        System.out.println("실행 결과");
        IntStream.range(0, participants.size())
            .mapToObj(i -> participants.get(i).getName() + " : " + operationResults.get(
                resultCalculator.calculateResult(i)).getValue())
            .forEach(System.out::println);
    }

    public void printResultByName(OperationResults operationResults,
        ResultCalculator resultCalculator, int index) {
        String result = operationResults.get(resultCalculator.calculateResult(index)).getValue();
        System.out.println("실행결과");
        System.out.println(result);
    }
}
