package org.springframework.samples.petclinic.payment;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentControllerTest {
	@Test
	public void testCardPayment() {
		PaymentRepository paymentRepository = new PaymentRepository();
		PaymentController paymentController = new PaymentController(paymentRepository);

		paymentController.cardPayment();
	}

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void getBean() {
		PaymentController bean = applicationContext.getBean(PaymentController.class);
		Assertions.assertThat(bean).isNotNull();
	}
}
