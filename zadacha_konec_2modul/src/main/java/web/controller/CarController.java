package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

/**
 * Контроллер для обработки запросов на /cars.
 * Отображает таблицу с автомобилями.
 */

@Slf4j
@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        log.info("Request /cars with parameter count={}", count);

        model.addAttribute("cars", (count == null || count >= 5)
                ? carService.getAllCars()
                : carService.getCars(count));

        return "cars";
    }
}
