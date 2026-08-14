package com.ara.BookManager.config;

import com.ara.BookManager.model.BeanTest;
import com.ara.BookManager.repository.InMemoryBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean("beanTest")
    public BeanTest beanTest() {
        return new BeanTest("beanTest");
    }

    @Bean("beanTest2")
    public BeanTest beanTest2() {
        return new BeanTest("beanTest2");
    }
}
