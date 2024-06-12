package my.study.tdd.boardhexagonaltdd.domain.article.application.port.in;

import java.util.List;
import my.study.tdd.boardhexagonaltdd.domain.article.domain.Article;

public interface GetArticleUseCase {
    Article getArticleById(Long articleId);

    List<Article> getArticlesByBoard(Long boardId);
}
