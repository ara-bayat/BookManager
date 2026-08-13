package com.ara.BookManager;


import com.ara.BookManager.model.BookRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;


import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookManagerJsonTest {

    @Autowired
    private JacksonTester<BookRecord> bookJson;

    @Test
    void bookSerialization() throws IOException {
        BookRecord book = new BookRecord(79,"about something","A A Adam"
                , BigDecimal.valueOf(50.99),"book description");
        assertThat(bookJson.write(book)).
                isEqualToJson("book.json");

        assertThat(bookJson.write(book)).
                hasJsonPathNumberValue("@.id");

        assertThat(bookJson.write(book)).
                extractingJsonPathNumberValue("@.id")
                .isEqualTo(79);
    }

}
