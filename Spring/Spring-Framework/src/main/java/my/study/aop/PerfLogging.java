package my.study.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 해당 어노테이션을 사용하면 성능을 로깅해 줍니다.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS) // annotation 정보를 얼마나 유지할 것인가. 컴파일하고 class 파일로 컴파일 될때도 남아있음
public @interface PerfLogging {

}
