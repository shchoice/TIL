package my.study.spel;

import org.springframework.stereotype.Component;

@Component
public class sample {
  private int data = 200;

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
