package com.demo.db.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Use application-test.properties
class DbApplicationTests {

	@Test
	void contextLoads() {
		// This test just ensures the Spring context loads successfully
	}
}