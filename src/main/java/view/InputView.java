package view;

import java.util.List;
import java.util.Scanner;
import util.Parser;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> inputParticipantsNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        System.out.println();
        return Parser.parseCommaSeparated(names);
    }

    public String inputOperationResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = scanner.nextLine();
        System.out.println();
        return results;
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리의 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public String inputResultParticipant() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String name = scanner.nextLine().strip();
        System.out.println();
        return name;
    }
}
