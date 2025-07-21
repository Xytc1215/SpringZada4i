package web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Глобальный обработчик исключений.
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCarCountException.class)
    public String handleInvalidCarCount(InvalidCarCountException ex, Model model) {
        log.error("Exception handled: {}", ex.getMessage());
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
