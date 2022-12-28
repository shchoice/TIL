package my.study.spel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
  public static void main(String[] args) {
    String text = "2016-07-05 02:14:35.000";
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    LocalDateTime localDateTime = LocalDateTime.parse(text, format);
    System.out.println(localDateTime);
  }
}
