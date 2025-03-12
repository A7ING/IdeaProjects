/*. С помощью цикла (только одного) нарисовать такую фигуру.
Причем максимальная высота этой фигуры вводиться с клавиатуры (в примере максимальная высота - 4)
*

***
****
***

*
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть висоту піраміди: ");
            if (in.hasNextInt()) {
                int height = in.nextInt();
                in.nextLine();
                for (int i = 1; i <= height * 2 - 1; i++) {
                    int stars = (i <= height) ? i : (height * 2 - i);

                    if (stars == 2) {
                        System.out.println();
                        continue;
                    }

                    for (int j = 0; j < stars; j++) {
                        System.out.print("*");
                    }
                    System.out.println();

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