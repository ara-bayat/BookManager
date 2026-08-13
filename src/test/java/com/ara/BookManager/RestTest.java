package com.ara.BookManager;

import com.ara.BookManager.model.BookRecord;
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
        ResponseEntity<BookRecord> response=testRestTemplate.getForEntity(
                "/books/1",
                BookRecord.class
        );

        System.out.println(response.getBody());
    }
}
