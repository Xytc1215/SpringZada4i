package koschei.models;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Утка, которая несёт яйцо.
 * Используется setter-инъекция.
 */

@Component
public class Duck5 {

    @Setter(onMethod_ = @Autowired)
    private Egg6 egg;

    @Override
    public String toString() {
        return "в утке яйцо , " + egg;
    }
}
