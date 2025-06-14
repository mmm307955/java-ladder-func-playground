package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Participant;
import domain.Participants;
import domain.Point;
import domain.Results;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printLadder(Ladder ladder, Participants participants) {
        System.out.println("\n사다리 결과\n");
        printParticipantsNames(participants.names());
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
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
        StringBuilder sb = new StringBuilder("   ");
        for (String name : names) {
            sb.append(String.format("%-6s", name));
        }
        System.out.println(sb);
    }

    public void printAllResults(Results results) {
        System.out.print("  ");
        String allResults = results.getResults().stream()
            .map(result -> String.format("%-5s", result.getResult()))
            .collect(Collectors.joining(" "));
        System.out.println(" " + allResults);
    }

    public void printResultForAllParticipants(LadderResult ladderResult) {
        System.out.println("실행 결과");
        ladderResult.getAll().forEach((participant, result) -> {
            System.out.println(participant.getName() + " : " + result.getResult());
        });
    }

    public void printResultForParticipant(LadderResult ladderResult, Participant participant) {
        System.out.println("결과를 보고 싶은 사람은?");
        System.out.println(ladderResult.getResult(participant).getResult());
    }
}
