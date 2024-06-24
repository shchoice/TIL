package my.study.tdd.boardhexagonaltdd.domain.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.study.tdd.boardhexagonaltdd.domain.Board;

@Entity
@Table(name = "board")
@NoArgsConstructor
@Getter
public class BoardJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public BoardJpaEntity(String name) {
        this.name = name;
    }

    private BoardJpaEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Board toDomain() {
        return new Board(this.id, this.name);
    }

    public static BoardJpaEntity fromDomain(Board board) {
        return new BoardJpaEntity(board.getId(), board.getName());
    }
}
