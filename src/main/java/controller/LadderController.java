package controller;

import domain.Ladder;
import domain.ResultCalculator;
import view.InputView;
import view.OutputView;

public class LadderController {
    public void run() {
        InputView inputView = new InputView();
        int ladderWidth = inputView.inputLadderWidth();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = Ladder.generate(ladderWidth, ladderHeight);
        ResultCalculator resultCalculator = new ResultCalculator(ladder);

        OutputView outputView = new OutputView();
        outputView.printLadder(ladder);
        outputView.printResult(ladderWidth, resultCalculator);
    }
}
