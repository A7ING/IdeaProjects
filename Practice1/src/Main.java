/*Написать программу которая считывает 5-и значное число с
        клавиатуры и выводит цифры из которого оно состоит.*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("ВВедите любое 5 значное число:");
            String num = in.nextLine();
            String res = num.replaceAll("[^0-9]", "");
            if (res.length() != 5) {
                System.out.println("Ошибка: число должно содержать ровно 5 цифр.");
                return;
            }
            System.out.println("Цифры числа:");
            for (int i = 0; i < res.length(); i++) {
                System.out.println(res.charAt(i));
            }
        }
    }
}