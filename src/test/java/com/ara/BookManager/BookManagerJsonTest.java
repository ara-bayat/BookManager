package com.ara.BookManager;


import com.ara.BookManager.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import tools.jackson.databind.ObjectMapper;


import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookManagerJsonTest {

    @Autowired
    private JacksonTester<Book> bookJson;

    @Test
    void bookSerialization() throws IOException {
        Book book = new Book(79,"about something","A A Adam"
                ,50.99,"book description");
        assertThat(bookJson.write(book)).
                isEqualToJson("book.json");

        assertThat(bookJson.write(book)).
                hasJsonPathNumberValue("@.id");

        assertThat(bookJson.write(book)).
                extractingJsonPathNumberValue("@.id")
                .isEqualTo(79);
    }

}
