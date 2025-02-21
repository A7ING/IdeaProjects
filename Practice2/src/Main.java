/*Написать программу которая вычислит и выведет на экран
площадь треугольника если известны его стороны.*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите сторону a: ");
        double a = in.nextDouble();
        System.out.print("Введите сторону b: ");
        double b = in.nextDouble();
        System.out.print("Введите сторону c: ");
        double c = in.nextDouble();
        //полупериметр
        double p = (a + b + c) / 2;
        //формула Герона
        double res = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Площадь треугольника: " + res);
    }
    }
}