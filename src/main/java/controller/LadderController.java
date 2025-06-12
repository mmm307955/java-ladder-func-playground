package controller;

import domain.Ladder;
import domain.OperationResult;
import domain.OperationResults;
import domain.Participant;
import domain.Participants;
import domain.ResultCalculator;
import domain.strategy.RandomPointGenerator;
import java.util.List;
import java.util.stream.Collectors;
import util.Parser;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Participants participants = inputParticipants();
        OperationResults operationResults = inputOperationResults(participants);

        Ladder ladder = createLadder(participants.size());
        ResultCalculator resultCalculator = new ResultCalculator(ladder);

        outputView.printLadderResult(ladder, participants, operationResults);
        showLadderGameResult(participants, operationResults, resultCalculator);
    }

    private Participants inputParticipants() {
        List<String> names = inputView.inputParticipantsNames();
        List<Participant> participantList = names.stream()
            .map(Participant::new)
            .collect(Collectors.toList());
        return new Participants(participantList);
    }

    private OperationResults inputOperationResults(Participants participants) {
        String input = inputView.inputOperationResults();
        List<String> operationResults = Parser.parseCommaSeparated(input);
        List<OperationResult> operationResultList = operationResults.stream()
            .map(OperationResult::new)
            .collect(Collectors.toList());
        return new OperationResults(operationResultList, participants);
    }

    private Ladder createLadder(int width) {
        int ladderHeight = inputView.inputLadderHeight();
        return Ladder.generate(width, ladderHeight, new RandomPointGenerator());
    }

    private void showLadderGameResult(Participants participants, OperationResults operationResults,
        ResultCalculator resultCalculator) {
        while (true) {
            String name = inputView.inputResultParticipant();
            boolean canExit = handleResultRequest(name, participants, operationResults,
                resultCalculator);
            if (canExit) {
                break;
            }
        }
    }

    private boolean handleResultRequest(String name, Participants participants,
        OperationResults operationResults, ResultCalculator resultCalculator) {
        if (name.equals("all")) {

            outputView.printAllResults(participants, operationResults, resultCalculator);
            return true;
        }
        int index = participants.indexOf(name);
        if (index == -1) {
            System.out.println("해당 이름은 참가자 목록에 없습니다. 다시 입력해주세요.");
            return false;
        }
        outputView.printResultByName(operationResults, resultCalculator, index);
        return false;
    }
}
