package my.study.tdd.boardhexagonaltdd.article.application.port.out;


import my.study.tdd.boardhexagonaltdd.article.domain.Article;

public interface CommandArticlePort {
    Article createArticle(Article article);

    Article modifyArticle(Article article);

    void deleteArticle(Long articleId);
}
