package my.study.tdd.boardhexagonaltdd.application.service;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.CommandArticlePort;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.LoadArticlePort;
import my.study.tdd.boardhexagonaltdd.domain.application.port.out.LoadBoardPort;
import my.study.tdd.boardhexagonaltdd.domain.application.service.ArticleService;
import my.study.tdd.boardhexagonaltdd.domain.ArticleFixtures;
import my.study.tdd.boardhexagonaltdd.common.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Ch06NestedTest {
    private ArticleService sut;

    @Mock
    private LoadArticlePort loadArticlePort;
    @Mock
    private CommandArticlePort commandArticlePort;
    @Mock
    private LoadBoardPort loadBoardPort;

    @BeforeEach
    void setUp() {
        sut = new ArticleService(loadArticlePort, commandArticlePort, loadBoardPort);
    }

    @Test
    @DisplayName("articleId 로 조회시 Article 반환")
    void return_Article() {
        // given
        var article = ArticleFixtures.article();
        given(loadArticlePort.findArticleById(Mockito.anyLong()))
            .willReturn(Optional.of(article));

        // when
        var result = sut.getArticleById(1L);

        // then
        then(result)
            .isNotNull()
            .hasNoNullFieldsOrProperties()
            .hasFieldOrPropertyWithValue("id", article.getId())
            .hasFieldOrPropertyWithValue("board.id", article.getBoard().getId())
            .hasFieldOrPropertyWithValue("subject", article.getSubject())
            .hasFieldOrPropertyWithValue("content", article.getContent())
            .hasFieldOrPropertyWithValue("username", article.getUsername())
            .hasFieldOrProperty("createdAt");
    }

    @Test
    @DisplayName("Article 존재하지 않을 경우 ResourceNotFoundException throw")
    void throw_ResourceNotFoundException() {
        given(loadArticlePort.findArticleById(any()))
            .willReturn(Optional.empty());

        thenThrownBy(() -> sut.getArticleById(1L))
            .isInstanceOf(ResourceNotFoundException.class);
    }

    // 테스트 끼리 연관 있는 것을 묶어서 가독성이 좋아짐
    // ex) 같은 역할에 대해 하나는 성공 하나는 실패하는 케이스를 묶어버림
    @Nested
    @DisplayName("Article 조회")
    class GetArticle {
        @Test
        @DisplayName("articleId 로 조회시 Article 반환")
        void return_Article() {
            var article = ArticleFixtures.article();
            given(loadArticlePort.findArticleById(any()))
                .willReturn(Optional.of(article));

            var result = sut.getArticleById(1L);

            then(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", article.getId())
                .hasFieldOrPropertyWithValue("board.id", article.getBoard().getId())
                .hasFieldOrPropertyWithValue("subject", article.getSubject())
                .hasFieldOrPropertyWithValue("content", article.getContent())
                .hasFieldOrPropertyWithValue("username", article.getUsername())
                .hasFieldOrPropertyWithValue("createdAt", article.getCreatedAt());
        }

        @Test
        @DisplayName("존재하지 않을 경우 NoSuchElementException throw")
        void throw_NoSuchElementException() {
            given(loadArticlePort.findArticleById(any()))
                .willReturn(Optional.empty());

            thenThrownBy(() -> sut.getArticleById(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("id : 1 게시물이 없습니다");
        }
    }
}
