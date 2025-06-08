package domain;

public class OperationResult {
    private final String value;

    public OperationResult(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("결과값은 비어 있을 수 없습니다.");
        }
        this.value = value.strip();
    }

    public String getValue() {
        return value;
    }
}

