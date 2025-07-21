package hiber.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Сущность Car — представляет машину пользователя.
 * Используется для связи "один к одному" с User.
 */

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Include
    @Column(name = "model", nullable = false)
    private String model;

    @ToString.Include
    @Column(name = "series", nullable = false)
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}
