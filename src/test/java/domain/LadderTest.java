package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리는 높이만큼 라인을 가진다")
    void ladder_has_lines_by_height() {
        //Given
        int width = 4;
        int height = 5;

        //When
        Ladder ladder = Ladder.generate(width,height);

        //Then
        assertThat(ladder.getLines()).hasSize(height);
    }
}
