//package me.study.springmvc.event;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EventService {
//  public List<Event> getEvents() {
//    Event event01 = Event.builder()
//        .name("Spring Web MVC Study - (1)")
//        .limitOfEnrollment(5)
//        .startDateTime(LocalDateTime.of(2022, 12, 30, 18,0))
//        .endDateTime(LocalDateTime.of(2023, 1, 7, 23, 50))
//        .build();
//
//    Event event02 = Event.builder()
//        .name("Spring Web MVC Study - (2)")
//        .limitOfEnrollment(5)
//        .startDateTime(LocalDateTime.of(2023, 1, 8, 0,0))
//        .endDateTime(LocalDateTime.of(2023, 1, 15, 23, 50))
//        .build();
//
//    return List.of(event01, event02);
//  }
//}
