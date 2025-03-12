/*
С помощью циклов вывести на экран все простые числа от 1 до 100.
Простое число — число которое делиться нацело только на единицу или само на себя.
Первые простые числа это — 2,3,5,7
*/
public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.print(i + ", ");
            }
        }
    }
}
