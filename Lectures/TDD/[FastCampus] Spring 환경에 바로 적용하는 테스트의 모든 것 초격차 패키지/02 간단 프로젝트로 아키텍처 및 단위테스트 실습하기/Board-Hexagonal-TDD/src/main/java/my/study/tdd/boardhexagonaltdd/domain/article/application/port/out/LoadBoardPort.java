package my.study.tdd.boardhexagonaltdd.domain.article.application.port.out;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.article.domain.Board;

public interface LoadBoardPort {
    Optional<Board> findBoardById(Long boardId);
}
