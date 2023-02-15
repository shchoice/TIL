package java.my.study.databinding3;

import java.my.study.databinding2.Event;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class EventFormatter implements Formatter<Event> {

  @Override
  public Event parse(String text, Locale locale) throws ParseException {
    return new Event(Integer.parseInt(text));
  }

  @Override
  public String print(Event object, Locale locale) {
    return object.getId().toString();
  }
}
