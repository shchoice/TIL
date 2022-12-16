package my.study.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
// 이벤트 핸들러는 빈으로 등록해야하지만 이벤트 자체는 빈이 아님
public class MyEventHandler {

  @EventListener
  public void handle(MyEvent event) {
    System.out.println("Event Received, Data : " + event.getData());
  }
}
