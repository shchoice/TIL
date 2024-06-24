package my.study.tdd.boardhexagonaltdd.out.persistence;

import java.time.LocalDateTime;
import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.entity.ArticleJpaEntity;
import my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.entity.BoardJpaEntity;

public class ArticleJpaEntityFixtures {
    public static ArticleJpaEntity entity(Long index) {
        var boardJpaEntity = new BoardJpaEntity("board");

        return new ArticleJpaEntity(boardJpaEntity, "subject" + index, "content" + index,
            "username" + index, LocalDateTime.parse("2023-02-10T11:12:33").plusDays(index));
    }

    public static ArticleJpaEntity entity() {
        var boardJpaEntity = new BoardJpaEntity("board");

        return new ArticleJpaEntity(boardJpaEntity, "subject", "content", "username",
            LocalDateTime.parse("2023-02-10T11:12:33"));
    }
}
