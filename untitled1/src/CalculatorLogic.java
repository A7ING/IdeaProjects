import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class CalculatorLogic extends JPanel implements ActionListener {
    // Создаем текстовое поле
    private JTextField display;

    // Сохраняем оператор и операнды
    private String operand1, operator, operand2;

    // Конструктор
    public CalculatorLogic() {
        operand1 = operator = operand2 = "";

        // Инициализируем текстовое поле
        display = new JTextField(16);
        display.setEditable(false);

        // Создаем кнопки
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton clearButton = new JButton("C");
        JButton equalsButton = new JButton("=");
        JButton dotButton = new JButton(".");

        // Добавляем слушатели действий
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);
        equalsButton.addActionListener(this);
        dotButton.addActionListener(this);

        // Добавляем элементы в панель
        setLayout(new GridLayout(5, 4, 5, 5));
        add(display);
        add(numberButtons[1]);
        add(numberButtons[2]);
        add(numberButtons[3]);
        add(addButton);
        add(numberButtons[4]);
        add(numberButtons[5]);
        add(numberButtons[6]);
        add(subButton);
        add(numberButtons[7]);
        add(numberButtons[8]);
        add(numberButtons[9]);
        add(mulButton);
        add(dotButton);
        add(numberButtons[0]);
        add(clearButton);
        add(equalsButton);
        add(divButton);
    }

    // Метод обработки событий
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Обработка чисел и точки
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            if (operator.isEmpty()) {
                operand1 += command;
            } else {
                operand2 += command;
            }
            display.setText(operand1 + operator + operand2);
        } else if (command.equals("C")) { // Очистка
            operand1 = operator = operand2 = "";
            display.setText("");
        } else if (command.equals("=")) { // Вычисление результата
            if (!operand1.isEmpty() && !operand2.isEmpty()) {
                double result;
                switch (operator) {
                    case "+" -> result = Double.parseDouble(operand1) + Double.parseDouble(operand2);
                    case "-" -> result = Double.parseDouble(operand1) - Double.parseDouble(operand2);
                    case "*" -> result = Double.parseDouble(operand1) * Double.parseDouble(operand2);
                    case "/" -> result = Double.parseDouble(operand1) / Double.parseDouble(operand2);
                    default -> throw new IllegalStateException("Unexpected value: " + operator);
                }
                display.setText(operand1 + operator + operand2 + "=" + result);
                operand1 = String.valueOf(result);
                operator = operand2 = "";
            }
        } else { // Обработка операторов
            if (!operand1.isEmpty() && operand2.isEmpty()) {
                operator = command;
            }
            display.setText(operand1 + operator);
        }
    }
}
