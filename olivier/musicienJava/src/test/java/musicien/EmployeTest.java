package musicien;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musicien.config.AppConfig;

public class EmployeTest {

	static AnnotationConfigApplicationContext ctx;
	@BeforeEach
	void beforeEach() {
		//avant chaque test
		System.out.println("beforeEach");
	}
	
	@AfterEach
	void afterEach() {
		//apres chaque test
		System.out.println("afterEach");
	}
	
	@BeforeAll
	static void beforeAll() {
		//execution 1 fois avant le premier test
		 ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		 System.out.println("beforeAll");
	}
	
	@AfterAll
	static void afterAll() {
		//execution 1 fois apres le dernier test
		ctx.close();
		System.out.println("afterAll");
	}
	
	@Test
	void recuperationBeanEmploye() {
		assertNotNull(ctx.getBean("guitariste"));
		
	}
	
	@Test
	void recuperationPiano() {
		assertNotNull(ctx.getBean("piano"));
	}
}
