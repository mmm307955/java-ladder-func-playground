package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Parser {

    private Parser() {
        throw new AssertionError("Parser 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static List<String> parseCommaSeparated(String input) {
        return Arrays.stream(input.split(","))
            .map(String::strip)
            .collect(Collectors.toList());
    }
}
