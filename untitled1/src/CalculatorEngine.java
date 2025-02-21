import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String currentText = CalculatorUI.getInputText();

        if (command.equals("C")) {
            CalculatorUI.setInputText("");
        } else if (command.equals("=")) {
            String result = CalculatorLogic.evaluate(currentText);
            CalculatorUI.setInputText(result);
        } else {
            CalculatorUI.setInputText(currentText + command);
        }
    }
}
