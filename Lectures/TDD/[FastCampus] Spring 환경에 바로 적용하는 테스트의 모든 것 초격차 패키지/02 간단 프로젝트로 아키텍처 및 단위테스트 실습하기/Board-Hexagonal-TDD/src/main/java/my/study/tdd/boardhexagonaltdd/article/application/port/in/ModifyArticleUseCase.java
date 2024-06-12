package my.study.tdd.boardhexagonaltdd.article.application.port.in;


import my.study.tdd.boardhexagonaltdd.article.adapter.in.api.dto.ArticleDto;
import my.study.tdd.boardhexagonaltdd.article.domain.Article;

public interface ModifyArticleUseCase {
    Article modifyArticle(ArticleDto.UpdateArticleRequest request);
}
