package ru.javamentor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Простой POJO, содержащий сообщение.
 * Используется как singleton бин.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorld {
    private String message;
}
