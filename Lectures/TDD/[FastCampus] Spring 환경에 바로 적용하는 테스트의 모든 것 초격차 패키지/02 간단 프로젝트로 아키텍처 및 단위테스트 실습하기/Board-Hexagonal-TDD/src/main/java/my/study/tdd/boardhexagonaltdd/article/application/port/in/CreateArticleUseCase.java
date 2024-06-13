package my.study.tdd.boardhexagonaltdd.article.application.port.in;

import my.study.tdd.boardhexagonaltdd.article.adapter.in.api.dto.ArticleDto.CreateArticleRequest;
import my.study.tdd.boardhexagonaltdd.article.domain.Article;

public interface CreateArticleUseCase {
    Article createArticle(CreateArticleRequest request);
}
