package my.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {
  @Around("@annotation(PerfLogging)")
  // Around advice(아래내용)를 포인트컷(괄호안 value)를 넣거나 직접 정의
  // around는 메소드 호출을 감싸 메소드 호출 전/후/특정한 사건 이후에도 역할을 할 수 있음
  public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
    long begin = System.currentTimeMillis();
    Object retVal = pjp.proceed();
    System.out.println(System.currentTimeMillis() - begin);

    return retVal;
  }
}
