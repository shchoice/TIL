package my.study.tdd.boardhexagonaltdd.domain.application.port.in;

import java.util.List;
import my.study.tdd.boardhexagonaltdd.domain.domain.Article;

public interface GetArticleUseCase {
    Article getArticleById(Long articleId);

    List<Article> getArticlesByBoard(Long boardId);
}
