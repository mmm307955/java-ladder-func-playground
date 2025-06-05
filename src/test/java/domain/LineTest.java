package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedPointGenerator;
import strategy.PointGenerator;

class LineTest {

    @Test
    @DisplayName("사다리의 바로 앞이 연결되어있으면 연결되지 않는다")
    void notConnect_if_before_ladder_is_connected() {
        PointGenerator generator = new FixedPointGenerator(true);

        Line line = Line.generate(3, generator);
        List<Point> points = line.getPoints();

        assertThat(points.get(0).isRightConnected()).isTrue();
        assertThat(points.get(1).isRightConnected()).isFalse();
        assertThat(points.get(2).isRightConnected()).isTrue();
    }
}
