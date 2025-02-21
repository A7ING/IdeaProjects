public class CalculatorLogic {
    public static String evaluate(String expression) {
        // Убираем пробелы из выражения
        expression = expression.replaceAll("\\s+", "");

        // Заменяем символ "x" на "*", чтобы правильно обрабатывать операцию умножения
        expression = expression.replace("x", "*");

        // Разделение строки на части
        String[] operands = expression.split("[+\\-*/]");  // Разделим по операторам
        String operator = expression.replaceAll("[0-9\\.]","");

        if (operands.length == 2) {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = 0;

            // Выполнение вычислений в зависимости от оператора
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":  // Используем "*" для умножения
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        return "Error: Division by zero!";
                    }
                    break;
                default:
                    return "Invalid operator!";
            }

            return String.valueOf(result);
        } else {
            return "Invalid expression!";
        }
    }
}
