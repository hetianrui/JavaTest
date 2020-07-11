package Scan;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class duck {
    private String name;
    private int age;

    public duck(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public duck() {
    }
}
