package koschei;

import koschei.models.Ocean1;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Главный герой — Кощей Бессмертный.
 * Через метод setOcean начинается вся цепочка.
 */

@Component
public class KoscheiTheDeathless {

    @Setter(onMethod_ = @Autowired)
    private Ocean1 ocean;

    public String getRulesByDeth() {
        return ocean.toString();
    }
}
