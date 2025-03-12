//Чи є число поліндромом
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть будь-яке 6-значне число: ");
            if (in.hasNextInt()) {
                int num = in.nextInt();
                in.nextLine();
                int num1 = num / 100000;
                int num2 = (num / 10000) % 10;
                int num3 = (num / 1000) % 10;
                int num4 = (num / 100) % 10;
                int num5 = (num / 10) % 10;
                int num6 = num % 10;
                if (num1 == num6 && num2 == num5 && num3 == num4) {
                    System.out.println(num + " є паліндромом");
                } else {
                    System.out.println(num + " не є паліндромом");
                }
            } else {
                System.out.println("Error: Введіть коректне ціле число!");
                in.nextLine();
                continue;
            }
            System.out.print("Хочете продовжити? так/ні: ");
            String answer = in.nextLine();
            if (!answer.equalsIgnoreCase("так")) {
                break;
            }
        }
        in.close();
    }
}