package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리는 높이 4, 너비 3으로 고정 생성된다")
    void ladderSize_is_fixed_generated_4x4() {
        int height = 4;
        int width = 3;
        Ladder ladder = Ladder.generate(height, width);

        List<Line> lines = ladder.getLines();
        assertThat(lines).hasSize(height);

        for (Line line : lines) {
            assertThat(line.getPoints()).hasSize(width);
        }
    }
}
