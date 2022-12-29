package java.my.study.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {
  @EventListener
  public void handler(MyEvent myEvent) {
    // 2가지 핸들러가 있을 때 무엇이 먼저일지는 모르지만 하나씩 처리가 된다.
    System.out.println(Thread.currentThread().toString());
    System.out.println("Another " + myEvent.getData());
  }
}
