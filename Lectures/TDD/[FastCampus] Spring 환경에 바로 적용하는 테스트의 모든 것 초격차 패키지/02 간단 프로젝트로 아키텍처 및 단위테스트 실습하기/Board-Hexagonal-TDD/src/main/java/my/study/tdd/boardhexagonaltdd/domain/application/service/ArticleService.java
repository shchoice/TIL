package my.study.tdd.boardhexagonaltdd.domain.application.service;


import java.time.LocalDateTime;
import java.util.List;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.DeleteArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.GetArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.adapter.in.api.dto.ArticleDto;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.CreateArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.ModifyArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.CommandArticlePort;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.LoadArticlePort;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.LoadBoardPort;
import my.study.tdd.boardhexagonaltdd.domain.domain.Article;
import my.study.tdd.boardhexagonaltdd.common.exception.AccessDeniedException;
import my.study.tdd.boardhexagonaltdd.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class ArticleService implements GetArticleUseCase, CreateArticleUseCase, ModifyArticleUseCase, DeleteArticleUseCase {
    private final LoadArticlePort loadArticlePort;
    private final CommandArticlePort commandArticlePort;
    private final LoadBoardPort loadBoardPort;

    public ArticleService(LoadArticlePort loadArticlePort, CommandArticlePort commandArticlePort, LoadBoardPort loadBoardPort) {
        this.loadArticlePort = loadArticlePort;
        this.commandArticlePort = commandArticlePort;
        this.loadBoardPort = loadBoardPort;
    }

    @Override
    @Transactional(readOnly = true)
    public Article getArticleById(Long articleId) {
        return loadArticlePort.findArticleById(articleId)
            .orElseThrow(() -> new ResourceNotFoundException("id : " + articleId + " 게시물이 없습니다"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getArticlesByBoard(Long boardId) {
        return loadArticlePort.findArticlesByBoardId(boardId);
    }

    @Override
    public Article createArticle(ArticleDto.CreateArticleRequest request) {
        Assert.hasLength(request.subject(), "subject should not empty");
        Assert.hasLength(request.content(), "content should not empty");
        Assert.hasLength(request.username(), "username should not empty");

        var board = loadBoardPort.findBoardById(request.boardId())
            .orElseThrow();
        var article = Article.builder()
            .board(board)
            .subject(request.subject())
            .content(request.content())
            .username(request.username())
            .createdAt(LocalDateTime.now())
            .build();

        return commandArticlePort.createArticle(article);
    }

    @Override
    public Article modifyArticle(ArticleDto.UpdateArticleRequest request) {
        Article article = loadArticlePort.findArticleById(request.id())
            .orElseThrow();

        if (!article.getUsername().equals(request.username())) {
            throw new AccessDeniedException("");
        }

        article.update(request.subject(), request.content());
        return commandArticlePort.modifyArticle(article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        commandArticlePort.deleteArticle(articleId);
    }
}
