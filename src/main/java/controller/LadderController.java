package controller;

import domain.Ladder;
import domain.LadderGenerator;
import domain.LadderResult;
import domain.Participant;
import domain.Participants;
import domain.Result;
import domain.Results;
import domain.strategy.RandomPointGenerator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import util.Parser;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = inputParticipants();
        Results results = inputResults(participants);
        Ladder ladder = createLadder(participants);
        LadderResult ladderResult = ladder.calculateResult(participants, results);

        outputView.printLadder(ladder, participants);
        outputView.printAllResults(results);
        showLadderGameResult(ladderResult);
    }

    private Participants inputParticipants() {
        List<String> names = inputView.inputParticipantsNames();
        List<Participant> participantList = names.stream()
            .map(Participant::new)
            .collect(Collectors.toList());
        return new Participants(participantList);
    }

    private Results inputResults(Participants participants) {
        String input = inputView.inputOperationResults();
        List<String> operationResults = Parser.parseCommaSeparated(input);
        List<Result> resultList = operationResults.stream()
            .map(Result::new)
            .collect(Collectors.toList());
        return new Results(resultList, participants);
    }

    private Ladder createLadder(Participants participants) {
        int width = participants.size();
        int height = inputView.inputLadderHeight();
        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        return ladderGenerator.create(new RandomPointGenerator());
    }

    private void showLadderGameResult(LadderResult ladderResult) {
        repeat(() -> {
            String name = inputView.inputResultParticipant();
            return loopControl(name, ladderResult);
        });
    }

    private void repeat(Supplier<LoopControl> supplier) {
        while (supplier.get() != LoopControl.EXIT) {

        }
    }

    private LoopControl loopControl(String name, LadderResult ladderResult) {
        if (name.equals("all")) {
            outputView.printResultForAllParticipants(ladderResult);
            return LoopControl.EXIT;
        }
        return individualResult(name, ladderResult);
    }

    private LoopControl individualResult(String name, LadderResult ladderResult) {
        Participant participant = ladderResult.findParticipantByName(name);
        if (participant == null) {
            System.out.println("해당 이름은 참가자 목록에 없습니다. 다시 입력해주세요.");
            return LoopControl.CONTINUE;
        }
        outputView.printResultForParticipant(ladderResult, participant);
        return LoopControl.CONTINUE;
    }
}
