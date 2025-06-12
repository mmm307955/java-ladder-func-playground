package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.LadderResult;
import domain.LoopControl;
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
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Participants participants = inputParticipants();
        Results results = inputResults(participants);
        Ladder ladder = createLadder(participants.size());

        LadderResult ladderResult = ladder.calculateResult(participants, results);

        outputView.printLadder(ladder, participants);
        outputView.printAllResults(results);

        showLadderGameResult(participants, ladderResult);
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

    private Ladder createLadder(int width) {
        int height = inputView.inputLadderHeight();
        return LadderFactory.create(width, height, new RandomPointGenerator());
    }

    private void showLadderGameResult(Participants participants, LadderResult ladderResult) {
        repeat(() -> {
            String name = inputView.inputResultParticipant();
            return loopControl(name, participants, ladderResult);
        });
    }

    private void repeat(Supplier<LoopControl> supplier) {
        while (supplier.get() != LoopControl.EXIT) {

        }
    }

    private LoopControl loopControl(String name, Participants participants,
        LadderResult ladderResult) {
        if (name.equals("all")) {
            outputView.printResultForAllParticipants(ladderResult, participants);
            return LoopControl.EXIT;
        }
        return individualResult(name, participants, ladderResult);
    }

    private LoopControl individualResult(String name, Participants participants,
        LadderResult ladderResult) {
        int index = participants.findIndexByName(name);
        if (index == -1) {
            System.out.println("해당 이름은 참가자 목록에 없습니다. 다시 입력해주세요.");
            return LoopControl.CONTINUE;
        }
        Participant participant = participants.findByIndex(index);
        outputView.printResultForParticipant(ladderResult, participant);
        return LoopControl.CONTINUE;
    }
}
