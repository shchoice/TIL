package my.study.tdd.boardhexagonaltdd.application.service;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.article.adapter.in.api.dto.ArticleDto;
import my.study.tdd.boardhexagonaltdd.article.application.port.out.CommandArticlePort;
import my.study.tdd.boardhexagonaltdd.article.application.port.out.LoadArticlePort;
import my.study.tdd.boardhexagonaltdd.article.application.port.out.LoadBoardPort;
import my.study.tdd.boardhexagonaltdd.article.application.service.ArticleService;
import my.study.tdd.boardhexagonaltdd.article.domain.Board;
import my.study.tdd.boardhexagonaltdd.article.domain.BoardFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ch04ExceptionTest {
  private ArticleService sut;

  @Mock
  private LoadArticlePort loadArticlePort;
  @Mock
  private CommandArticlePort commandArticlePort;
  @Mock
  private LoadBoardPort loadBoardPort;

  private final Board board = BoardFixtures.board();

  @BeforeEach
  void setUp() {
    sut = new ArticleService(loadArticlePort, commandArticlePort, loadBoardPort);
  }

  @Test
  @DisplayName("subject가 정상적이지 않으면 IllegalArgumentException")
  void throwIllegalArgumentException() {
    var request = new ArticleDto.CreateArticleRequest(5L, null, "content", "user");

    thenThrownBy(() -> sut.createArticle(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("subject should");
  }
}
