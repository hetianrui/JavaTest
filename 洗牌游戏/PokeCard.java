public class PokeCard {
    int value;
    String color;

    public PokeCard(int value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[%d, %s]", value, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        // 返回 obj 对象能否被 PokeCard 类型的引用指向
        // obj 对象的类型是不是 PokeCard 类型的小类型
        if (!(obj instanceof PokeCard)) {
            return false;
        }
        PokeCard other = (PokeCard)obj;
        return this.value == other.value
                && this.color.equals(other.color);
    }
}
