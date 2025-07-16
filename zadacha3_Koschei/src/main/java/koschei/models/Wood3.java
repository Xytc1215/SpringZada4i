package koschei.models;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Дерево, в котором сидит заяц.
 * Используется внедрение через конструктор.
 */

@Component
@RequiredArgsConstructor
public class Wood3 {

    private final Rabbit4 rabbit;

    @Override
    public String toString() {
        return "в дереве заяц , " + rabbit;
    }
}
