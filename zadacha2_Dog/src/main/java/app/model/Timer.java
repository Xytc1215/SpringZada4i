package app.model;
import java.time.Instant;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;


/**
 * Компонент-секундомер.
 * Хранит время создания экземпляра.
 */

@Component
@Getter
@ToString
public class Timer {

    private final Long time;

    public Timer() {
        this.time = Instant.now().toEpochMilli();
    }
}
