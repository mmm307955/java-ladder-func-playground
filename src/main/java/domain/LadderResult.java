package domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private final Map<Participant, Result> participantToResult;

    public LadderResult(Map<Participant, Result> participantToResult) {
        this.participantToResult = Collections.unmodifiableMap(participantToResult);
    }

    public Result getResult(Participant participant) {
        if (!participantToResult.containsKey(participant)) {
            throw new IllegalArgumentException("해당 이름은 참가자 목록에 없습니다. 다시 입력해주세요.");
        }
        return participantToResult.get(participant);
    }

    public Participant findParticipantByName(String name) {
        return participantToResult.keySet().stream()
            .filter(participant -> participant.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public Map<Participant, Result> getAll() {
        return participantToResult;
    }
}
