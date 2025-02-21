import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Введите радиус круга: ");
            double radius = scanner.nextDouble();

            // Вычисляем площадь круга
            double area = Math.PI * Math.pow(radius, 2);
            System.out.println("Площадь круга с радиусом " + radius + " равна: " + area);

            // Спрашиваем, хочет ли пользователь продолжить
            System.out.print("Хотите ввести другой радиус? (да/нет): ");
            choice = scanner.next();

        } while (choice.equalsIgnoreCase("да")); // Продолжаем, пока ввод "да"
        System.out.println("Программа завершена.");
        scanner.close();
    }
}