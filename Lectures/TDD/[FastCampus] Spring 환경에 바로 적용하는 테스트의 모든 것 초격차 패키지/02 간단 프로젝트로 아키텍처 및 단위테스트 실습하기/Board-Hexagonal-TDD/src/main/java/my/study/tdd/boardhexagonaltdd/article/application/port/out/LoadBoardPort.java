package my.study.tdd.boardhexagonaltdd.article.application.port.out;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.article.domain.Board;

public interface LoadBoardPort {
    Optional<Board> findBoardById(Long boardId);
}
