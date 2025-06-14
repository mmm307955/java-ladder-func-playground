package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.strategy.PointGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedPointGenerator;

class LineTest {

    @Test
    @DisplayName("라인에서 오른쪽 연결이 있으면 index가 1 증가한다")
    void index_plus_one_when_line_is_connected_right() {
        //Given & When
        Line line = Line.generate(4, new FixedPointGenerator(true));
        int movedIndex = line.move(0);

        //Then
        assertThat(movedIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리의 바로 앞이 연결되어있으면 라인이 연결되지 않는다")
    void notConnect_if_before_ladder_is_connected() {
        //Given
        int width = 4;
        PointGenerator generator = new FixedPointGenerator(true);

        //When
        Line line = Line.generate(width, generator);
        List<Point> points = line.getPoints();

        //Then
        assertThat(points.get(0).isMovableToRight()).isTrue();
        assertThat(points.get(1).isMovableToRight()).isFalse();
        assertThat(points.get(2).isMovableToRight()).isTrue();
    }

    @Test
    @DisplayName("사다리의 넓이와 높이를 입력받아 사다리를 생성하고, 라인에 생성된 Point 수는 width와 같다")
    void ladder_has_width_minus_1_point() {
        //Given
        int width = 4;
        int height = 5;

        //When
        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        Ladder ladder = ladderGenerator.create(new FixedPointGenerator(true));

        List<Line> lines = ladder.getLines();

        //Then
        for (Line line : lines) {
            assertThat(line.getPoints()).hasSize(width);
        }
    }
}
