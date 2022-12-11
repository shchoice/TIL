package my.study.springautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  @Qualifier("myBookRepository")
  BookRepository bookRepository;

  public void printBookRepository() {
    System.out.println(bookRepository.getClass());
  }
}
