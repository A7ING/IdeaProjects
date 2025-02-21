import java.util.Scanner;
public class View {
    private final static Scanner scanner = new Scanner(System.in);

    public void printMenuData() {
        System.out.println("Електронний журнал:");
        System.out.println("1 - Додати дані про іспит");
        System.out.println("2 - Знайти дані");
        System.out.println("3 - Змінити дані");
        System.out.println("4 - Видалити результат");
        System.out.println("5 - Завершення роботи");
    }

    public Integer readCommand() {
        return scanner.nextInt();
    }

    public void printIncomingString(String incomingString) {
        System.out.println(incomingString);
    }

    public String name() {
        System.out.println("Введіть ім'я студента:");
        String firstName = scanner.next();

        System.out.println("Введіть прізвище студента:");
        String lastName = scanner.next();

        return firstName + " " + lastName;
    }
    public void printData(Data data) {
        System.out.println("Дані: Предмет: " + data.getSubject() + ", Особиста інформація: " + data.getPersonInf() + ", Група: " + data.getGroup() + ", Оцінка: " + data.getMark());
    }

    public String group() {
        System.out.println("Введіть групу студента:");
        return scanner.next();
    }

    public String subject() {
        System.out.println("Введіть предмет іспиту:");
        return scanner.next();
    }

    public Integer mark(String prompt) {
        if(!prompt.isEmpty()) {
            System.out.println(prompt);
        } else {
            System.out.println("Введіть оцінку за іспит: ");
        }
        return scanner.nextInt();
    }
}