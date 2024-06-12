package my.study.tdd.boardhexagonaltdd.article.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Article {
    private Long id;
    private Board board;
    private String subject;
    private String content;
    private String username;
    private LocalDateTime createdAt;

    public void update(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
