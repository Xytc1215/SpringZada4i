package app;

import app.config.AppConfig;
import app.model.AnimalsCage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Класс для запуска приложения.
 * Создаёт контекст и вызывает метод у AnimalsCage.
 */

public class Application {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            AnimalsCage cage = context.getBean(AnimalsCage.class);

            for (int i = 0; i < 5; i++) {
                cage.whatAnimalSay();
            }
        }
    }
}
