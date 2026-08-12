package com.ara.BookManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BookManagerApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void test() {
		assertThat(1).isEqualTo(2);
	}

}
