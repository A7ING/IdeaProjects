import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Пошук рядка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JLabel searchLabel = new JLabel("Введіть номер рядка для пошуку:");
        JTextField searchField = new JTextField(10);
        JTextArea inputArea = new JTextArea();
        JTextArea outputArea = new JTextArea();
        JButton searchButton = new JButton("Пошук");

        JPanel panel = new JPanel();
        panel.add(searchLabel);
        panel.add(searchField);
        panel.add(searchButton);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String searchText = searchField.getText();
                    int searchLine = Integer.parseInt(searchText);

                    String inputText = inputArea.getText();
                    String[] lines = inputText.split("\n");
                    if (searchLine <= 0 || searchLine > lines.length) {
                        throw new IllegalArgumentException("Введений номер рядка не відповідає кількості рядків у тексті.");
                    }
                    String resultText = lines[searchLine - 1];

                    outputArea.setText(resultText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Введено некоректний номер рядка.", "Помилка", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}