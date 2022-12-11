package my.study.springapplicationcontext;

public class BookService {
  BookRepository bookRepository;

  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
}
