package my.study.tdd.boardhexagonaltdd.domain.article.adapter.out.persistence.repository;

import java.util.List;
import my.study.tdd.boardhexagonaltdd.domain.article.adapter.out.persistence.entity.ArticleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleJpaEntity, Long> {
    List<ArticleJpaEntity> findByBoardId(Long boardId);
}
