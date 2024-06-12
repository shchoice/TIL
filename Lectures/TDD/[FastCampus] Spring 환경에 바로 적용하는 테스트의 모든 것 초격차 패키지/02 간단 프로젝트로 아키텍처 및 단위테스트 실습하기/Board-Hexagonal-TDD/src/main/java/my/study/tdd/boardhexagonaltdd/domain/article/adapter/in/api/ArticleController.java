package my.study.tdd.boardhexagonaltdd.domain.article.adapter.in.api;

import jakarta.validation.Valid;
import java.util.List;
import my.study.tdd.boardhexagonaltdd.domain.article.adapter.in.api.dto.ArticleDto;
import my.study.tdd.boardhexagonaltdd.domain.article.application.port.in.CreateArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.article.application.port.in.DeleteArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.article.application.port.in.GetArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.article.application.port.in.ModifyArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.common.api.dto.CommandResponse;
import my.study.tdd.boardhexagonaltdd.domain.article.adapter.in.api.dto.ArticleDto.ArticleResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
public class ArticleController {
    private final GetArticleUseCase getArticleUseCase;
    private final CreateArticleUseCase createArticleUseCase;
    private final ModifyArticleUseCase modifyArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;

    public ArticleController(GetArticleUseCase getArticleUseCase, CreateArticleUseCase createArticleUseCase,
                             ModifyArticleUseCase modifyArticleUseCase, DeleteArticleUseCase deleteArticleUseCase) {
        this.getArticleUseCase = getArticleUseCase;
        this.createArticleUseCase = createArticleUseCase;
        this.modifyArticleUseCase = modifyArticleUseCase;
        this.deleteArticleUseCase = deleteArticleUseCase;
    }

    @GetMapping("{articleId}")
    ArticleResponse getArticle(@PathVariable Long articleId) {
        var article = getArticleUseCase.getArticleById(articleId);

        return ArticleDto.ArticleResponse.of(article);
    }

    @GetMapping(params = "boardId")
    List<ArticleDto.ArticleResponse> listArticlesByBoard(@RequestParam Long boardId) {
        return getArticleUseCase.getArticlesByBoard(boardId).stream()
            .map(ArticleDto.ArticleResponse::of)
            .toList();
    }

    @PostMapping
    CommandResponse postArticle(@Valid @RequestBody ArticleDto.CreateArticleRequest request) {
        var createdArticle = createArticleUseCase.createArticle(request);
        return new CommandResponse(createdArticle.getId());
    }

    @PutMapping
    CommandResponse putArticle(@Valid @RequestBody ArticleDto.UpdateArticleRequest request) {
        var article = modifyArticleUseCase.modifyArticle(request);
        return new CommandResponse(article.getId());
    }

    @DeleteMapping("{articleId}")
    void deleteArticled(@PathVariable Long articleId) {
        deleteArticleUseCase.deleteArticle(articleId);
    }
}
