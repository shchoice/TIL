package my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.repository;

import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.entity.BoardJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardJpaEntity, Long> {
}
