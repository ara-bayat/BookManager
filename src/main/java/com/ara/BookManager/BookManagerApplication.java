package com.ara.BookManager;

import com.ara.BookManager.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class, args);

		Car car = new Car("Toyota","camery","1995",25000.0);
		System.out.println(car);


	}

}
