package koschei.models;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Остров, на котором растёт дерево.
 */

@Component
@RequiredArgsConstructor
public class Island2 {

    private final Wood3 wood;

    @Override
    public String toString() {
        return "на острове дерево , " + wood;
    }
}
