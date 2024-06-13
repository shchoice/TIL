package my.study.tdd.boardhexagonaltdd.article.application.port.in;


import my.study.tdd.boardhexagonaltdd.article.adapter.in.api.dto.ArticleDto.UpdateArticleRequest;
import my.study.tdd.boardhexagonaltdd.article.domain.Article;

public interface ModifyArticleUseCase {
    Article modifyArticle(UpdateArticleRequest request);
}
