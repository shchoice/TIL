//package me.study.springmvc.event;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class EventController {
//  @Autowired
//  EventService eventService;
//
//  // 예전 방식 - @RequestMapping(value = "/events", method = RequestMethod.GET)
//  @GetMapping("/events")
//  public String events(Model model) {
//    model.addAttribute("events", eventService.getEvents());
//    return "events";
//  }
//}
