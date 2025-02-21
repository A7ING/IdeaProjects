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

        // Создаем кнопки
        JButton[] buttons = new JButton[] {
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("/"),
                new JButton("."), new JButton("0"), new JButton("C"), new JButton("x"),
                new JButton("=")
        };

        // Назначаем действия для кнопок
        for (JButton button : buttons) {
            button.addActionListener(engine);
        }

        // Располагаем кнопки на панели
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int row = 0, col = 0;
        for (JButton button : buttons) {
            gbc.gridx = col;
            gbc.gridy = row;
            panel.add(button, gbc);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        // Располагаем текстовое поле и кнопку "="
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = row + 1;
        panel.add(inputBox, gbc);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void setInputText(String text) {
        inputBox.setText(text);
    }

    public static String getInputText() {
        return inputBox.getText();
    }
}
