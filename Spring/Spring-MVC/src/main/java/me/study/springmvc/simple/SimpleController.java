package me.study.springmvc.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable("name") Person person) {
    return "Hello " + person.getName();
  }
}
