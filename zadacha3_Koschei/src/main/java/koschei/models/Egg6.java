package koschei.models;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Яйцо, в котором находится игла (Needle7).
 * Использует внедрение через конструктор.
 */

@Component
@RequiredArgsConstructor
public class Egg6 {

    private final Needle7 needle;

    @Override
    public String toString() {
        return "в яйце игла , " + needle;
    }
}
