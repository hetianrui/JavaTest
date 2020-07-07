package DuckShop;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter

public class ds {
    private String name;
    private List<duck> ducks;

    @Override
    public String toString() {
        return "店名=" + name +
                ", 鸭子有=" + ducks;
    }
}
