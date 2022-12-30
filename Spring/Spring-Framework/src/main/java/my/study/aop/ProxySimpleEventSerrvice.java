package my.study.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProxySimpleEventSerrvice implements EventService {

  @Autowired
  SimpleEventService simpleEventService;
  // 이론적으로는 인터페이스 빈을 주입 받아 사용하는 것을 추천 하지만 프록시는 Subject의 빈을 주입받아 사용,

  @Override
  public void createEvent() {
    long begin = System.currentTimeMillis();
    simpleEventService.createEvent();
    System.out.println(System.currentTimeMillis() - begin);
  }

  @Override
  public void publishEvent() {
    long begin = System.currentTimeMillis();
    simpleEventService.publishEvent();
    System.out.println(System.currentTimeMillis() - begin);
 }

  @Override
  public void deleteEvent() {
    long begin = System.currentTimeMillis();
    simpleEventService.deleteEvent();
    System.out.println(System.currentTimeMillis() - begin);
  }
}
