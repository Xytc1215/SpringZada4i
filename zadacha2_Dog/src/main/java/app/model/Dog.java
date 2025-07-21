package app.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Компонент-собака.
 * Представляет животное и выводит фразу при вызове.
 */

@Component("dog")
@ToString
public class Dog {

    public void say() {
        System.out.println("Im a Dog");
    }
}
