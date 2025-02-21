import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Создаем окно
            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Добавляем информацию о программе
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BorderLayout());
            // Создаем интерфейс калькулятора
            CalculatorUI.createUI(frame);

            // Добавляем информационную панель в окно
            frame.getContentPane().add(infoPanel, BorderLayout.NORTH);

            // Устанавливаем размер и отображаем
            frame.setSize(300, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}