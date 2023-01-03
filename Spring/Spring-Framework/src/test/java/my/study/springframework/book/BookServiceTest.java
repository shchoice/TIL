package my.study.springframework.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
class BookServiceTest {
    @Mock
    BookRepository bookRepository;

    @Test
    public void save() {
      Book book = new Book();

      when(bookRepository.save(book)).thenReturn(book);
      BookService bookService = new BookService(bookRepository);

      Book result = bookService.save(book);

      assertThat(book.getCreated()).isNotNull();
      assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFT);
      assertThat(result).isNotNull();
    }
}