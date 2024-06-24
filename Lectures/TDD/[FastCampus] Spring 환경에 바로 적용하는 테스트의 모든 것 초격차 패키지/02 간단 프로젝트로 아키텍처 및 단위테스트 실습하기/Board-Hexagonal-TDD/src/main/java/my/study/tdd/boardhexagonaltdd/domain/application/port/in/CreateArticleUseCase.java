package my.study.tdd.boardhexagonaltdd.domain.application.port.in;

import my.study.tdd.boardhexagonaltdd.domain.adapter.in.api.dto.ArticleDto.CreateArticleRequest;
import my.study.tdd.boardhexagonaltdd.domain.Article;

public interface CreateArticleUseCase {
    Article createArticle(CreateArticleRequest request);
}
