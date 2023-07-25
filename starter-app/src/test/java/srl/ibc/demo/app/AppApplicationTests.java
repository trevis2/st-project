package srl.ibc.demo.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class AppApplicationTests {

	@Container
	public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:12.14").withUsername("duke")
			.withPassword("password").withDatabaseName("test");

	// l'ordine di esecuzione è mantenuto nella classe

	@BeforeAll
	static void beforeAll() {
		System.out.println("---------beforeAll---------");
	}

	public AppApplicationTests() {
		System.out.println("---------constructor AppApplicationTests---------");
	}

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", () -> container.getJdbcUrl());
		registry.add("spring.datasource.username", () -> container.getUsername());
		registry.add("spring.datasource.password", () -> container.getPassword());
		System.out.println("---------DynamicPropertySource---------");

	}

	@BeforeEach
	protected void beforeEach() {
		System.out.println("---------beforeEach---------");
	}

	@AfterEach
	void afterEach() {
		System.out.println("---------afterEach---------");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("---------afterAll---------");
	}

}
