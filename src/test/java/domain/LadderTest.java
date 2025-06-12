package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedPointGenerator;

class LadderTest {

    @Test
    @DisplayName("사다리는 높이만큼 라인을 가진다")
    void ladder_has_lines_by_height() {
        //Given
        int width = 4;
        int height = 5;

        //When
        Ladder ladder = Ladder.generate(width, height, new FixedPointGenerator(true));

        //Then
        assertThat(ladder.getLines()).hasSize(height);
    }

    @Test
    @DisplayName("라인에서 오른쪽 연결이 있으면 index가 1 증가한다")
    void index_plus_one_when_line_is_connected_right() {
        //Given & When
        Line line = Line.generate(4, new FixedPointGenerator(true));
        int movedIndex = line.move(0);

        //Then
        assertThat(movedIndex).isEqualTo(1);
    }
}
