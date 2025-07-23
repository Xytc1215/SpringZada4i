package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

/**
 * Сущность User — представляет пользователя в системе.
 * Связан с таблицей "users" в базе данных.
 * Используются Lombok-аннотации для сокращения кода (геттеры, сеттеры, конструкторы и toString).
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {

    /**
     * Уникальный идентификатор пользователя, генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя пользователя. Не может быть пустым.
     */
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    @Column(nullable = false)
    private String name;

    /**
     * Электронная почта пользователя. Уникальна и обязательна.
     */
    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    @Column(nullable = false, unique = true)
    private String email;
}
