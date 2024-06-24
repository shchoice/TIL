package my.study.tdd.boardhexagonaltdd.domain.application.port.out;

import java.util.List;
import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.Article;

public interface LoadArticlePort {
    Optional<Article> findArticleById(Long articleId);
    List<Article> findArticlesByBoardId(Long boardId);
}
