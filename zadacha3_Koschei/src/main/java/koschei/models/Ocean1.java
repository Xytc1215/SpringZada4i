package koschei.models;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Океан, в котором находится остров.
 */

@Component
public class Ocean1 {

    @Setter(onMethod_ = @Autowired)
    private Island2 island;

    @Override
    public String toString() {
        return "На свете есть океан , " + island;
    }
}
