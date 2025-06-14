package domain;

public class Result {
    private final String result;

    public Result(String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("결과값은 비어 있을 수 없습니다.");
        }
        this.result = result.strip();
    }

    public String getResult() {
        return result;
    }
}
