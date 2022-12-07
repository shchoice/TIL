package org.springframework.samples.petclinic.proxy;

public class Cash implements Payment{

	@Override
	public void pay(float amount) {
		System.out.println(amount + " 현금 결제 완료");
	}
}
