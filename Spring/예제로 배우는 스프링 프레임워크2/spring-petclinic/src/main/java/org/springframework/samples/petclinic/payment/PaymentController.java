package org.springframework.samples.petclinic.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;

	public PaymentController() {}
	public PaymentController(PaymentRepository paymentRepository) { //Spring IoC 컨테이너 즉, ApplicationContext가 bean을 찾아서 넣어줌) 의존성 주입은 bean끼리만 가능함, 즉 Spring IoC 컨테이너 안에 들어있는 것 끼리만 의존성 주입이 가능함
		this.paymentRepository = paymentRepository;
	}
	public void cardPayment() {
		this.paymentRepository.save(); // 스프링이 아니었다면 new를 하지 않았기 때문에 NullPointException 이어야함
	}
}
