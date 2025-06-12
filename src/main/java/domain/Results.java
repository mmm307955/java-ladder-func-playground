package domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results, Participants participants) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 하나 이상 있어야 합니다.");
        }
        if (results.size() != participants.size()) {
            throw new IllegalArgumentException("참여자 수와 실행 결과 수가 일치하지 않습니다.");
        }
        this.results = Collections.unmodifiableList(results);
    }

    public Result findByIndex(int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return results;
    }
}
