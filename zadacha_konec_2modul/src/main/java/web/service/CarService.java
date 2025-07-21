package web.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.exception.InvalidCarCountException;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы со списком автомобилей.
 * Предоставляет методы для получения полного или частичного списка машин.
 */

@Slf4j
@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>(List.of(
            new Car("Toyota", "Black", 2010),
            new Car("Honda", "White", 2012),
            new Car("Ford", "Red", 2015),
            new Car("BMW", "Blue", 2018),
            new Car("Mercedes", "Silver", 2020)
    ));

    public List<Car> getCars(int count) {
        if (count < 0) {
            log.error("Incorrect count value received: {}", count);
            throw new InvalidCarCountException("The number of cars cannot be negative: " + count);
        }

        log.info("Returns {} cars", count);
        return cars.subList(0, Math.min(count, cars.size()));
    }

    public List<Car> getAllCars() {
        log.info("Full list of vehicles requested");
        return new ArrayList<>(cars);
    }
}
