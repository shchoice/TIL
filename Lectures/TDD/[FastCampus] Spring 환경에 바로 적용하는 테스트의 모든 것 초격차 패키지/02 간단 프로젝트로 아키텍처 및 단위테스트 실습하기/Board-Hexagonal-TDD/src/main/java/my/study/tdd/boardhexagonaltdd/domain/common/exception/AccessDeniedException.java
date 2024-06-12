package my.study.tdd.boardhexagonaltdd.domain.common.exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
