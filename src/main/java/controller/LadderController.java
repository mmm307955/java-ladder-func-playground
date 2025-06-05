package controller;

import domain.Ladder;
import view.OutputView;

public class LadderController {
    private static final int LADDER_HEIGHT = 4;
    private static final int LADDER_WIDTH = 3;

    public void run() {
        Ladder ladder = Ladder.generate(LADDER_HEIGHT, LADDER_WIDTH);
        OutputView outputView = new OutputView();
        outputView.printLadder(ladder);
    }
}
