import java.io.FileWriter;
import java.io.PrintWriter;

public class Sinus {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("sin.txt"));
            for (int i = 0; i <= 360; i++) {
                double sinValue = Math.sin(Math.toRadians(i));
                writer.printf("%d %.4f\n", i, sinValue);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
