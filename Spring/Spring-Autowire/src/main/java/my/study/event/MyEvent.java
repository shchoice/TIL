package my.study.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

  private int data;

  public int getData() {
    return data;
  }

  public MyEvent(Object source) {
    super(source);
  }

  public MyEvent(Object source, int data) {
    super(source);
  }
}
