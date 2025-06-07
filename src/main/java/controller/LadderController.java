package controller;

import domain.Ladder;
import view.InputView;
import view.OutputView;

public class LadderController {
    private int ladderHeight;
    private int ladderWidth;

    public void run() {
        InputView inputView = new InputView();
        ladderWidth = inputView.inputLadderWidth();
        ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = Ladder.generate(ladderWidth, ladderHeight);
        OutputView outputView = new OutputView();
        outputView.printLadder(ladder);
    }
}
