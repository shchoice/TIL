package my.study.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
// 클래스 기반의 프록시로 감싸라. Single Singleton이 직접 참조하지 않고 Proxy를 거쳐 참조해야함
// 매번 바꿔줄 수 있도록 프록시로 감싼 것임!
// CG 라이브러리로 클래스도 프록시로 만들게 해줌(Java 프록시는 인터페이스만 가능한 반면)
public class Proto {

  // Proto Type 빈에서 Singleton 빈을 참조하는 것은 전혀 문제가 없음
 @Autowired
  Single single;

}
