package java.my.study.databinding;

import java.beans.PropertyEditorSupport;

public class EventEditor extends PropertyEditorSupport {
  /*
   * getValue, setValue가 공유하는 value는 서로 다른 스레드에 공유가 되어 stateful하다. 상태정보를 저장하고 있음, 즉 Thread Safe 하지 않음
   * 즉 bean으로 등록해서 사용하면 안된다. 심각한 버그가 난다. ProperyEditor는 절대 빈으로 등록하면 안됨(가장 안전)
   * 필요시에는 ThreadScope의 빈으로 사용하면 문제는 없다.
   */
  @Override
  public String getAsText() {
    Event event = (Event) getValue();
    return event.getId().toString();
  }

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    setValue(new Event(Integer.parseInt(text)));
  }
}
