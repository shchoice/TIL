package my.study.tdd.boardhexagonaltdd.domain;

import lombok.Getter;

@Getter
public class Board {
    private Long id;
    private String name;

    public Board(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
