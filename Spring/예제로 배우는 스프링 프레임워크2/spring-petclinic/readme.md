# Spring Framework 공부

* 강의 : 예제로 배우는 스프링 입문
* 강사 : 백기선(인프런)

Spring-petclinic 예제를 통해 거시적인 스프링에 대해 공부한 내용입니다.
기존 프로젝트에서 다음과 같이 변경을 하며 공부를 하였습니다.

* LastName으로 검색하는 것을 FirstName으로 검색
  * Model : findByFirstName 메소드 추가
  * View : HTML 단순 Text만 변경
  * Controller : processFindForm에서 lastName -> firstName 으로 정정
  * Test : OwnerControllerTests 클래스 에서 lastName 관련 내용 firstName으로 변경
    * testProcessFindFormSuccess()
    * testProcessFindFormByFirstName()
    * testProcessFindFormNoOwnersFound()
* DB 사용 변경(h2 -> hsqldb)
  * pom.xml 에서 dependency hsqldb 로 변경 (h2 -> hsqldb)
  * application.properties 에서 DB 설정 변경 (h2 -> hsqldb)
* DB 사용 3가지 방법(Embedded Mode, In-Memory Mode, Server Mode)
  * h2 3가지 사용법 알기(https://kukim.tistory.com/105)
* 이름 검색 시 처음부터 일치해야 하는 것이 아닌 중간에도 이름이 동일한 경우에도 적용
  * Model : findByFirstName 메소드에서 Like 구문에서 %:firstName% 으로 작성
* Owner에 age 필드 추가
  * Model 변경
  * Schema 변경
  * Data 변경
  * View 변경

