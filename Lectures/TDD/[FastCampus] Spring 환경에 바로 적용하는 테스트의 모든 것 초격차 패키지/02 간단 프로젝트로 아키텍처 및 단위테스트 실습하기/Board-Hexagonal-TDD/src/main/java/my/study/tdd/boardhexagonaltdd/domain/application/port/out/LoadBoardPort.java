package my.study.tdd.boardhexagonaltdd.domain.application.port.out;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.Board;

public interface LoadBoardPort {
    Optional<Board> findBoardById(Long boardId);
}
