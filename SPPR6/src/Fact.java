public class Fact {
    private String name;
    private double value;  // Используем double для всех значений

    // Конструктор с проверкой значения
    public Fact(String name, double value) {
        this.name = name;
        this.value = value;  // Просто передаем значение без изменений
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        // Если значение 1.0 или 0.0, выводим как true или false
        if (value == 1.0) {
            return name + " = true";
        } else if (value == 0.0) {
            return name + " = false";
        } else {
            return name + " = " + value;
        }
    }
}
