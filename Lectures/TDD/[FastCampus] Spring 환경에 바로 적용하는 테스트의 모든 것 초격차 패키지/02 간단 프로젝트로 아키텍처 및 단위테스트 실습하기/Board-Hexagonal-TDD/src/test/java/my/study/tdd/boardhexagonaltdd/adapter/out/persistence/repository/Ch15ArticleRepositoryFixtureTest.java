package my.study.tdd.boardhexagonaltdd.adapter.out.persistence.repository;

import static org.assertj.core.api.BDDAssertions.then;

import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("/data/ArticleRepositoryFixtureTest.sql")
class Ch15ArticleRepositoryFixtureTest {
  @Autowired
  private ArticleRepository repository;

  @Test
  @Sql("/data/ArticleRepositoryFixtureTest.listAllArticles2.sql")
  void listAllArticles2() {
    var result = repository.findByBoardId(5L);

    then(result)
        .hasSize(3);
  }
}
