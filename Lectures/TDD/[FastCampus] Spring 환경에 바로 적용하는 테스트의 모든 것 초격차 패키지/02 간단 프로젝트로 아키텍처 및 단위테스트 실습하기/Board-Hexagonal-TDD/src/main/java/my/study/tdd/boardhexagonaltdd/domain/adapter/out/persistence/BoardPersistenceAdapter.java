package my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.LoadBoardPort;
import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.repository.BoardRepository;
import my.study.tdd.boardhexagonaltdd.domain.Board;
import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.entity.BoardJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class BoardPersistenceAdapter implements LoadBoardPort {
    private final BoardRepository boardRepository;

    public BoardPersistenceAdapter(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boardRepository.findById(boardId)
            .map(BoardJpaEntity::toDomain);
    }
}
