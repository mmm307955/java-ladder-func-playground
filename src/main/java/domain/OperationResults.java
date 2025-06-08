package domain;

import java.util.Collections;
import java.util.List;

public class OperationResults {
    private final List<OperationResult> operationResults;

    public OperationResults(List<OperationResult> operationResults, Participants participants) {
        if (operationResults == null || operationResults.isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 하나 이상 있어야 합니다.");
        }
        if (operationResults.size() != participants.size()) {
            throw new IllegalArgumentException("참여자 수와 실행 결과 수가 일치하지 않습니다.");
        }
        this.operationResults = Collections.unmodifiableList(operationResults);
    }

    public OperationResult get(int index) {
        return operationResults.get(index);
    }

    public List<OperationResult> getOperationResults() {
        return operationResults;
    }
}
