package java.springframework.book;

import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
      book.setCreated(new Date());
      book.setBookStatus(BookStatus.DRAFT);
      return bookRepository.save(book);
    }

    @PostConstruct
    public void postConstruct() {
      System.out.println("===========");
      System.out.println("Hello");
      System.out.println("===========");
    }
}
