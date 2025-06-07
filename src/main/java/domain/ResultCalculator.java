package domain;

public class ResultCalculator {
    private final Ladder ladder;

    public ResultCalculator(Ladder ladder) {
        this.ladder = ladder;
    }

    public int calculateResult(int startX) {
        return ladder.result(startX);
    }
}
