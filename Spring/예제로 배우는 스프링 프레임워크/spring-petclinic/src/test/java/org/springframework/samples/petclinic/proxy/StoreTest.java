package org.springframework.samples.petclinic.proxy;


import org.junit.jupiter.api.Test;

class StoreTest {
	@Test
	public void testPay() {
//		Payment payment = new CashPerf();  // 지금 상태로는 인터페이스의 이점이 없음
		String args = "cachperf";   // 나중에 사용자 입력 > 동적으로 변화
		Payment payment = PaymentFactory.get(args);
		Store store = new Store(payment);
		store.buySomething(100);
	}
}
// 1. 클라이언트 코드(인터페이스를 불러서 사용하는 곳)
// 2. 상황
// 1) 마리아 DB / 오라클 DB >> 클라이언트 코드는 관심이 없음
// 2) 실제 클라이언트 동작과 무관한 수정일 경우, 클라이언트 코드 수정을 없게 하고 싶다 > 개발 비용
