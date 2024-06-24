package my.study.tdd.boardhexagonaltdd.domain.application.port.in;


import my.study.tdd.boardhexagonaltdd.domain.adapter.in.api.dto.ArticleDto.UpdateArticleRequest;
import my.study.tdd.boardhexagonaltdd.domain.Article;

public interface ModifyArticleUseCase {
    Article modifyArticle(UpdateArticleRequest request);
}
