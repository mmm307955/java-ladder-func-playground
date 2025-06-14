import controller.LadderController;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderController ladderController = new LadderController(inputView, outputView);
        ladderController.run();
    }
}
