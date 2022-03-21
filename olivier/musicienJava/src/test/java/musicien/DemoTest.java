package musicien;


import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemoTest {

	@Test
	void firstTest() {
		int a=2;
		assertTrue(2==a);
		assertEquals(2, 1+1);
		assertThrows(ArithmeticException.class, ()->{
			int n=2/0;
		});
	}

	@Test
	@Disabled
	void autreTest() {
		fail("fail");
	}
}
