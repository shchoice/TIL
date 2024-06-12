package my.study.tdd.boardhexagonaltdd.domain.article.application.port.in;

import my.study.tdd.boardhexagonaltdd.domain.article.domain.Article;
import my.study.tdd.boardhexagonaltdd.domain.article.adapter.in.api.dto.ArticleDto.CreateArticleRequest;

public interface CreateArticleUseCase {
    Article createArticle(CreateArticleRequest request);
}
