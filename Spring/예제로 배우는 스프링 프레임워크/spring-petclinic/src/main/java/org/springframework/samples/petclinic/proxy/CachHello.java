package org.springframework.samples.petclinic.proxy;

public class CachHello implements Payment{

	@Override
	public void pay(float amount) {
		System.out.println("hello world");
	}
}
