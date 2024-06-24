package my.study.tdd.boardhexagonaltdd.out.persistence;

import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.entity.BoardJpaEntity;
import org.springframework.test.util.ReflectionTestUtils;

public class BoardJpaEntityFixtures {
  public static BoardJpaEntity board() {
    var boardJpaEntity = new BoardJpaEntity("board");
    ReflectionTestUtils.setField(boardJpaEntity, "id", 5L);

    return boardJpaEntity;
  }
}
