package ru.javamentor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс Cat используется как бин с прототипным скоупом.
 * Каждый вызов getBean создает новый объект.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String name;
}
