package ru.javamentor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс приложения. Загружает контекст Spring и демонстрирует скоупы бинов.
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld1 = context.getBean("helloworld", HelloWorld.class);
        HelloWorld helloWorld2 = context.getBean("helloworld", HelloWorld.class);

        Cat cat1 = context.getBean("cat", Cat.class);
        Cat cat2 = context.getBean("cat", Cat.class);

        logger.info("Message from HelloWorld: {}", helloWorld1.getMessage());
        logger.info("helloWorld1 == helloWorld2? {}", helloWorld1 == helloWorld2);
        logger.info("cat1 == cat2? {}", cat1 == cat2);
    }
}
