package ru.javamentor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Конфигурационный класс. Определяет, какие бины создаются в контексте Spring.
 */

@Configuration
public class AppConfig {

    @Bean(name = "helloworld")
    public HelloWorld helloWorld() {
        return new HelloWorld("Hello from Spring + Lombok!");
    }

    @Bean(name = "cat")
    @Scope("prototype")
    public Cat cat() {
        return new Cat("Barsik");
    }
}
