package my.study.event;

import org.springframework.context.ApplicationEvent;
public class MyEvent {

  private int data;
  private Object source;

  public int getData() {
    return data;
  }

  public MyEvent(Object source, int data) {
    this.source = source;
    this.data = data;
  }
}
