package my.study.tdd.boardhexagonaltdd.domain.application.port.out;


import my.study.tdd.boardhexagonaltdd.domain.domain.Article;

public interface CommandArticlePort {
    Article createArticle(Article article);

    Article modifyArticle(Article article);

    void deleteArticle(Long articleId);
}
