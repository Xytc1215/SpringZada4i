package hiber.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * JPA-сущность для пользователей.
 * Таблица users содержит уникальный email, имя, и ID.
 * Аннотация @Data добавляет геттеры, сеттеры, toString, equals и hashCode.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false, unique = true)
   private String email;
}
