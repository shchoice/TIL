package my.study.tdd.boardhexagonaltdd.adapter.out.persistence;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.Board;
import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.BoardPersistenceAdapter;
import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.repository.BoardRepository;
import my.study.tdd.boardhexagonaltdd.out.persistence.BoardJpaEntityFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Ch12BoardPersistenceAdapterTest {
  private BoardPersistenceAdapter adapter;
  private BoardRepository boardRepository;

  @BeforeEach
  void setUp() {
    boardRepository = Mockito.mock(BoardRepository.class);
    adapter = new BoardPersistenceAdapter(boardRepository);
  }

  @Test
  void findBoardById() {
    var boardJpaEntity = BoardJpaEntityFixtures.board();
    given(boardRepository.findById(any()))
        .willReturn(Optional.of(boardJpaEntity));

    var result = adapter.findBoardById(5L);

    then(result)
        .isPresent()
        .hasValueSatisfying(board ->
            then(board)
                .isInstanceOf(Board.class)
                .hasFieldOrPropertyWithValue("id", 5L)
        );

  }
}
