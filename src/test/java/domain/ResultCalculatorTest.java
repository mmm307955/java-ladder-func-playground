package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedPointGenerator;
import strategy.PointGenerator;

class ResultCalculatorTest {

    @Test
    @DisplayName("사다리 타기 결과를 계산한다")
    void calculate_result_correctly() {
        // Given
        int width = 4;
        int height = 5;
        /**
         *    사다리 구조 (FixedPointGenerator(true))
         *    |-----|     |-----|
         *    |-----|     |-----|
         *    |-----|     |-----|
         *    |-----|     |-----|
         *    |-----|     |-----|
         *
         *    기대 결과:
         *  * 0 -> 1
         *  * 1 -> 0
         *  * 2 -> 3
         *  * 3 -> 2
         * */
        PointGenerator generator = new FixedPointGenerator(true);

        // When
        Ladder ladder = Ladder.generate(width, height, generator);
        ResultCalculator resultCalculator = new ResultCalculator(ladder);

        //Then
        assertThat(resultCalculator.calculateResult(0)).isEqualTo(1);
        assertThat(resultCalculator.calculateResult(1)).isEqualTo(0);
        assertThat(resultCalculator.calculateResult(2)).isEqualTo(3);
        assertThat(resultCalculator.calculateResult(3)).isEqualTo(2);
    }
}
