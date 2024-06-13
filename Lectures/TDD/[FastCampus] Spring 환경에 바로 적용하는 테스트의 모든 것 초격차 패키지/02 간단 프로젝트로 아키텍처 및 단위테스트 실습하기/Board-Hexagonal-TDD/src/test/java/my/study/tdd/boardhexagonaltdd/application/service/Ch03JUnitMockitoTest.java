package my.study.tdd.boardhexagonaltdd.application.service;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import my.study.tdd.boardhexagonaltdd.article.application.port.out.CommandArticlePort;
import my.study.tdd.boardhexagonaltdd.article.application.port.out.LoadArticlePort;
import my.study.tdd.boardhexagonaltdd.article.application.port.out.LoadBoardPort;
import my.study.tdd.boardhexagonaltdd.article.application.service.ArticleService;
import my.study.tdd.boardhexagonaltdd.article.domain.Article;
import my.study.tdd.boardhexagonaltdd.article.domain.ArticleFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ch03JUnitMockitoTest {
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
  Article article = ArticleFixtures.article();

  // Mockito 를 통한 stub 만들기 - 어떤 입력값을 받으면 특정 반환값을 갖도록 만들어 둠, 여기서는 Optional.of(article)을 반환
  // stub은 동작에 대한 검증이 아닌 결과값에 대해서만 검증을 함
  Mockito.when(loadArticlePort.findArticleById(any()))
      .thenReturn(Optional.of(article));

  Article result = sut.getArticleById(1L);

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
  @DisplayName("BDD Style Board의 Article 목록 조회")
  void getArticlesByBoard_listArticle() {
//    Article article1 = ArticleFixtures.article(1L);
//    Article article2 = ArticleFixtures.article(2L);
//
//    BDDMockito.given(loadArticlePort.findArticlesByBoardId(any()))
//        .willReturn(List.of(article1, article2));
//
//    Article result = sut.getArticleById(5L);
//
//    then(result)
//        .hasSize(2)
//        .extracting("board.id").containsOnly(5L);
  }

  @Test
  @DisplayName("Article 삭제")
    void deleteArticle() {
    BDDMockito.willDoNothing() // void 반환형 일 경우
        .given(commandArticlePort).deleteArticle(any());

    sut.deleteArticle(1L);
    verify(commandArticlePort).deleteArticle(1L);
  }
}
