package java.springframework.book;

import java.util.Date;

public class Book {

  private Date created;
  private BookStatus bookStatus;

  public BookStatus getBookStatus() {
    return bookStatus;
  }

  public void setCreated(Date date) {
    this.created = created;
  }

  public void setBookStatus(BookStatus bookStatus) {
    this.bookStatus = bookStatus;
  }

  public boolean getCreated() {
    return true;
  }
}
