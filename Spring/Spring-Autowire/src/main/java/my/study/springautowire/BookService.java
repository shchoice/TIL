package my.study.springautowire;

import org.springframework.stereotype.Service;

@Service
public class BookService {

  BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
}
