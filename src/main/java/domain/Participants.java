package domain;

import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = Collections.unmodifiableList(participants);
    }

    public int size() {
        return participants.size();
    }

    public Participant findByIndex(int index) {
        return participants.get(index);
    }

    public List<String> names() {
        return participants.stream()
            .map(Participant::getName)
            .toList();
    }
}
