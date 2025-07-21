package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель автомобиля.
 * Хранит данные о марке, цвете и годе выпуска.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String model;
    private String color;
    private int year;
}
