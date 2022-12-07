package org.springframework.samples.petclinic.proxy;

public class PaymentFactory {
	public static Payment get(String str) {
		if (str.equalsIgnoreCase("cachperf"))
			return new CashPerf();
		else if (str.equalsIgnoreCase("cach")) {
			return new Cash();
		}
		return new CachHello();
	}
}
