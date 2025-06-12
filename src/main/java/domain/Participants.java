package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    public List<Participant> getAll() {
        return participants;
    }

    public List<String> names() {
        return participants.stream()
            .map(Participant::getName)
            .toList();
    }

    public int findIndexByName(String name) {
        return IntStream.range(0, participants.size())
            .filter(i -> isMatchingName(name, i))
            .findFirst()
            .orElse(-1);
    }

    private boolean isMatchingName(String name, int index) {
        return participants.get(index).getName().equals(name);
    }
}
