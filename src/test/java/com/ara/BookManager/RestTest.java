package com.ara.BookManager;

import com.ara.BookManager.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
public class RestTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testRest(){
        ResponseEntity<Book> response=testRestTemplate.getForEntity(
                "/books/1",
                Book.class
        );

        System.out.println(response.getBody());
    }
}
