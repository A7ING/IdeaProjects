import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("sin.txt"));
            double[][] values = new double[361][2];
            int i = 0;
            while (scanner.hasNext()) {
                values[i][0] = scanner.nextDouble();
                values[i][1] = scanner.nextDouble();
                i++;
            }
            scanner.close();

            Scanner inputScanner = new Scanner(new File("input.txt"));
            double inputAngle = inputScanner.nextDouble();
            inputScanner.close();

            int index = (int) Math.round(inputAngle);
            System.out.printf("Значение синуса для угла %d: %.4f\n", index, values[index][1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}