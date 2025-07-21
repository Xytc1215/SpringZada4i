package koschei.models;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Заяц, в котором спрятана утка.
 * Внедрение зависимости через поле.
 */

@Component
@RequiredArgsConstructor
public class Rabbit4 {

    private final Duck5 duck;

    @Override
    public String toString() {
        return "в зайце утка , " + duck;
    }
}
