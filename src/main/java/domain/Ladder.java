package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리는 비어 있을 수 없습니다.");
        }
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public LadderResult calculateResult(Participants participants, Results results) {
        Map<Participant, Result> resultByParticipant = new LinkedHashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            int resultIndex = calculatePosition(i);
            Participant participant = participants.findByIndex(i);
            Result result = results.findByIndex(resultIndex);
            resultByParticipant.put(participant, result);
        }
        return new LadderResult(resultByParticipant);
    }

    private int calculatePosition(int startIndex) {
        int index = startIndex;
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }
}
