package app.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Клетка для животных, в которую внедряются Dog и Timer.
 * Показывает время и вызывает метод say() у животного.
 */

@Component
@RequiredArgsConstructor
@ToString
public class AnimalsCage {

    private final Dog dog;
    private final Timer timer;

    public void whatAnimalSay() {
        dog.say();
        System.out.println("At:\n" + timer.getTime());
        System.out.println("________________________");
    }

// Используется для тестов
    public Timer getTimer() {
        return timer;
    }
}
