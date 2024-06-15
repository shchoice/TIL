package my.study.tdd.boardhexagonaltdd.domain;

import java.time.LocalDateTime;
import my.study.tdd.boardhexagonaltdd.domain.domain.Article;
import my.study.tdd.boardhexagonaltdd.domain.domain.Board;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Ch01JUnitTest {

  @BeforeAll
  static void initAll() {
    System.out.println("Beofore All \n");
  }

  @AfterAll
  static void tearDownAll() {
    System.out.println("After All \n");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Before Each");
  }

  @AfterEach
  void tearDown() {
    System.out.println("After Each\n");
  }

  @Test
  @DisplayName("성공 테스트 - Article 생성")
  void constructArticleTest() {
    // Arrange (준비)
    var board = new Board(5L, "board");

    // Act (실행)
    var article = Article.builder()
        .id(1L)
        .board(board)
        .subject("subject")
        .content("content")
        .username("user")
        .createdAt(LocalDateTime.now())
        .build();

    // Assert (검증)
    Assertions.assertEquals(1L, article.getId());
    Assertions.assertTrue(article.getBoard().equals(board));
    Assertions.assertEquals("subject", article.getSubject());
    Assertions.assertEquals("content", article.getContent());
    Assertions.assertNotEquals("subject2", article.getSubject());
    Assertions.assertNotNull(article.getCreatedAt());

    System.out.println("succeedingTest");
  }
}
