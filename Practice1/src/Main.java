/*Написать программу которая считывает 5-и значное число с
        клавиатуры и выводит цифры из которого оно состоит.*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("ВВедите любое 5 значное число:");
            String num = in.nextLine();
            if (!num.matches("\\d{5}")) {
                System.out.println("Ошибка: введите число коректно (без букв и символов)");
                continue;
            }
            System.out.println("Цифры числа:");
            for (int i = 0; i < num.length(); i++) {
                System.out.println(num.charAt(i));
            }
            System.out.print("Хотите продолжить? да/нет: ");
            String answer = in.nextLine();
            if (!answer.equalsIgnoreCase("да")) {
                break;}
        }
    }
}