package my.study.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  BookRepository bookRepository;

  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
}
