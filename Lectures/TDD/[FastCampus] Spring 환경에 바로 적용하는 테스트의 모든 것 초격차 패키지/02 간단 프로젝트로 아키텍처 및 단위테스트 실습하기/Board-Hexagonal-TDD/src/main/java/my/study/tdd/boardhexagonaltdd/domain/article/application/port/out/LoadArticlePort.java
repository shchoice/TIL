package my.study.tdd.boardhexagonaltdd.domain.article.application.port.out;

import java.util.List;
import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.article.domain.Article;

public interface LoadArticlePort {
    Optional<Article> findArticleById(Long articleId);
    List<Article> findArticlesByBoardId(Long boardId);
}
