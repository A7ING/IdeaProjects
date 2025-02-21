import java.awt.*;
import javax.swing.*;

public class CalculatorUI {
    private static JTextField inputBox;

    public static void createUI(JFrame frame) {
        JPanel panel = new JPanel();
        CalculatorEngine engine = new CalculatorEngine();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(layout);

        // Создаем текстовое поле для отображения ввода
        inputBox = new JTextField(10);
        inputBox.setEditable(false);
        inputBox.setFont(new Font("Arial", Font.PLAIN, 24)); // Увеличиваем шрифт
        inputBox.setPreferredSize(new Dimension(300, 50));  // Увеличиваем размер

        // Создаем кнопки с увеличенным шрифтом
        JButton[] buttons = new JButton[] {
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("/"),
                new JButton("."), new JButton("0"), new JButton("C"), new JButton("x"),
                new JButton("=")
        };

        // Настраиваем стиль кнопок
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 20)); // Увеличиваем шрифт
            button.setPreferredSize(new Dimension(70, 70));  // Увеличиваем размер
            button.addActionListener(engine);                // Добавляем действие
        }

        // Располагаем кнопки на панели
        gbc.fill = GridBagConstraints.BOTH; // Кнопки растягиваются
        gbc.insets = new Insets(5, 5, 5, 5); // Внутренние отступы
        int row = 1, col = 0;

        for (JButton button : buttons) {
            gbc.gridx = col;
            gbc.gridy = row;
            panel.add(button, gbc);

            col++;
            if (col == 4) { // Каждые 4 кнопки создаем новый ряд
                col = 0;
                row++;
            }
        }

        // Располагаем текстовое поле
        gbc.gridwidth = 4; // Текстовое поле занимает всю ширину
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 20, 10); // Больше отступов для текстового поля
        panel.add(inputBox, gbc);

        // Добавляем панель в окно
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void setInputText(String text) {
        inputBox.setText(text);
    }

    public static String getInputText() {
        return inputBox.getText();
    }
}
