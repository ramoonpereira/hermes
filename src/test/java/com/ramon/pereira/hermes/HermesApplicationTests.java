package com.ramon.pereira.hermes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
class HermesApplicationTests {

	@Test
	public void main() {
		HermesApplication.main(new String[] {"--spring.config.location=classpath:application-test.yml"});
	}

}
