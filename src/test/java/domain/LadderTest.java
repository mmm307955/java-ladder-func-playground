package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedPointGenerator;

class LadderTest {

    @Test
    @DisplayName("사다리 타기 결과를 이름으로 계산한다")
    void calculate_result_by_name_correctly() {
        // Given
        int width = 4;
        int height = 5;

        /**
         *    사다리 구조 (FixedPointGenerator(true))
         *
         *   하나    둘     셋     넷
         *    |-----|     |-----|
         *    |-----|     |-----|
         *    |-----|     |-----|
         *    |-----|     |-----|
         *    |-----|     |-----|
         *   포도    사과    딸기    오렌지
         *
         *    기대 결과:
         *  * 하나 -> 사과
         *  * 둘 -> 포도
         *  * 셋 -> 오렌지
         *  * 넷 -> 딸기
         *
         * */

        Participants participants = new Participants(List.of(
            new Participant("하나"),
            new Participant("둘"),
            new Participant("셋"),
            new Participant("넷")
        ));

        Results results = new Results(List.of(
            new Result("포도"),
            new Result("사과"),
            new Result("딸기"),
            new Result("오렌지")
        ), participants);

        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        Ladder ladder = ladderGenerator.create(new FixedPointGenerator(true));

        // When
        LadderResult ladderResult = ladder.calculateResult(participants, results);

        //Then
        assertThat(ladderResult.getResult(new Participant("하나")).getResult()).isEqualTo("사과");
        assertThat(ladderResult.getResult(new Participant("둘")).getResult()).isEqualTo("포도");
        assertThat(ladderResult.getResult(new Participant("셋")).getResult()).isEqualTo("오렌지");
        assertThat(ladderResult.getResult(new Participant("넷")).getResult()).isEqualTo("딸기");
    }

    @Test
    @DisplayName("사다리는 높이만큼 라인을 가진다")
    void ladder_has_lines_by_height() {
        //Given
        int width = 4;
        int height = 5;

        //When
        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        Ladder ladder = ladderGenerator.create(new FixedPointGenerator(true));

        //Then
        assertThat(ladder.getLines()).hasSize(height);
    }
}
