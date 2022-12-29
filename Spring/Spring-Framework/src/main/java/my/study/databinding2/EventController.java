package my.study.databinding2;

import my.study.databinding.Event;
import my.study.databinding.EventEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  @InitBinder
  public void init(WebDataBinder webDataBinder) {
    webDataBinder.registerCustomEditor(my.study.databinding.Event.class, new EventEditor());
  }

  @GetMapping("/event/{event}")
  public String getEvent(@PathVariable Event event) {
    System.out.println(event);
    return event.getId().toString();
  }
}
