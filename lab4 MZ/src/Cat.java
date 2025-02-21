import java.util.Objects;

public class Cat {
    private String type;

    public Cat(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cat cat = (Cat) obj;
        return Objects.equals(type, cat.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
