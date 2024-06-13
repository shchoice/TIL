package my.study.tdd.boardhexagonaltdd.article;

import java.time.LocalDateTime;
import my.study.tdd.boardhexagonaltdd.article.domain.Article;
import my.study.tdd.boardhexagonaltdd.article.domain.Board;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Ch02JUnitAssertJTest {

  private Board board;

  @BeforeEach
  void setUp() {
    board = new Board(5L, "board");
  }

  @Test
  @DisplayName("AssertJ Assertion - updateArticle")
  void updateArticleTest() {
    // Arrange
    Article article = Article.builder()
        .id(1L)
        .board(board)
        .subject("subject")
        .content("content")
        .username("user")
        .createdAt(LocalDateTime.now())
        .build();

    // Act
    article.update("new subject", "new content");

    // Assert
    // Junit과 Assert 문과 가장 개선되는 점은 actual과 expected 를 분리하는 것, 메서드 체이닝을 통해 연속으로 사용할 수 있음
    // Junit은 한번에 하나의 조건만 실행하며 actual과 expected를 같이 넣음
    Assertions.assertThat(article.getId())
        .isNotNull()
        .isEqualTo(1L)
        .isGreaterThan(0L);

    Assertions.assertThat(article)
        .hasFieldOrPropertyWithValue("id", 1L)
        .hasFieldOrPropertyWithValue("board.id", 5L)
        .hasFieldOrPropertyWithValue("subject", "new subject")
        .hasFieldOrPropertyWithValue("content", "new content")
        .hasFieldOrProperty("createdAt");
  }

  @Test
  @DisplayName("BDD Style Assertion - updateArticle")
  void updateArticle_BDDStyle() {
    // Given
    var article = Article.builder()
        .id(1L)
        .board(board)
        .subject("subject")
        .content("content")
        .username("user")
        .createdAt(LocalDateTime.now())
        .build();

    // When
    article.update("new subject", "new content");

    // Then
    BDDAssertions.then(article)
        .hasNoNullFieldsOrProperties()
        .hasFieldOrPropertyWithValue("id", article.getId())
        .hasFieldOrPropertyWithValue("board.id", article.getBoard().getId())
        .hasFieldOrPropertyWithValue("subject", "new subject")
        .hasFieldOrPropertyWithValue("content", "new content")
        .hasFieldOrPropertyWithValue("createdAt", article.getCreatedAt());
  }
}
