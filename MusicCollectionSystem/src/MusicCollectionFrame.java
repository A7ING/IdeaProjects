import javax.swing.*;
import java.awt.*;

public class MusicCollectionFrame extends JFrame {
    private JTextField titleField, artistField, yearField, genreField;
    private JButton addButton, editButton, saveButton, deleteButton;
    private JList<String> recordList;

    public MusicCollectionFrame() {
        // Налаштування вікна
        setTitle("Колекція музичних записів");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        // Панель для компонентів
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        // Шрифт для написів
        Font labelFont = new Font("Arial", Font.BOLD, 24); // Збільшений шрифт для написів
        Font inputFont = new Font("Arial", Font.PLAIN, 18); // Шрифт для текстових полів

        // Створення написів і текстових полів
        JLabel titleLabel = new JLabel("Назва альбому:");
        titleLabel.setFont(labelFont);
        titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(250, 40));
        titleField.setFont(inputFont);

        JLabel artistLabel = new JLabel("Виконавець:");
        artistLabel.setFont(labelFont);
        artistField = new JTextField();
        artistField.setPreferredSize(new Dimension(250, 40));
        artistField.setFont(inputFont);

        JLabel yearLabel = new JLabel("Рік випуску:");
        yearLabel.setFont(labelFont);
        yearField = new JTextField();
        yearField.setPreferredSize(new Dimension(150, 40));
        yearField.setFont(inputFont);

        JLabel genreLabel = new JLabel("Жанр:");
        genreLabel.setFont(labelFont);
        genreField = new JTextField();
        genreField.setPreferredSize(new Dimension(150, 40));
        genreField.setFont(inputFont);

        // Створення кнопок
        addButton = new JButton("Додати запис");
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));

        editButton = new JButton("Редагувати запис");
        editButton.setFont(new Font("Arial", Font.PLAIN, 16));

        saveButton = new JButton("Зберегти зміни");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 16));

        deleteButton = new JButton("Видалити запис");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Список для відображення колекції
        recordList = new JList<>(MusicCollection.getListModel());
        JScrollPane listScrollPane = new JScrollPane(recordList);
        listScrollPane.setPreferredSize(new Dimension(300, 150));

        // Додавання обробників для кнопок
        addButton.addActionListener(e -> addRecord());
        editButton.addActionListener(e -> editRecord());
        saveButton.addActionListener(e -> saveRecord());
        deleteButton.addActionListener(e -> deleteRecord());

        // Додавання компонентів на панель
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(artistLabel);
        panel.add(artistField);
        panel.add(yearLabel);
        panel.add(yearField);
        panel.add(genreLabel);
        panel.add(genreField);
        panel.add(addButton);
        panel.add(editButton);
        panel.add(saveButton);
        panel.add(deleteButton);
        panel.add(listScrollPane);

        // Додавання панелі до вікна
        add(panel);
    }

    // Методи обробки дій (аналогічно попередній версії)
    private void addRecord() {
        String title = titleField.getText();
        String artist = artistField.getText();
        String year = yearField.getText();
        String genre = genreField.getText();

        if (title.isEmpty() || artist.isEmpty() || year.isEmpty() || genre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Будь ласка, заповніть усі поля!", "Помилка", JOptionPane.ERROR_MESSAGE);
        } else {
            MusicCollection.addRecord(title, artist, year, genre);
            JOptionPane.showMessageDialog(this, "Запис додано!", "Успіх", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
    }

    private void editRecord() {
        int selectedIndex = recordList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedRecord = MusicCollection.getRecord(selectedIndex);
            String[] recordParts = selectedRecord.split(" - | \\(|\\)");
            titleField.setText(recordParts[0]);
            artistField.setText(recordParts[1]);
            yearField.setText(recordParts[2]);
            genreField.setText(recordParts[3]);
        } else {
            JOptionPane.showMessageDialog(this, "Оберіть запис для редагування.", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveRecord() {
        int selectedIndex = recordList.getSelectedIndex();
        if (selectedIndex != -1) {
            String title = titleField.getText();
            String artist = artistField.getText();
            String year = yearField.getText();
            String genre = genreField.getText();

            if (title.isEmpty() || artist.isEmpty() || year.isEmpty() || genre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Будь ласка, заповніть усі поля!", "Помилка", JOptionPane.ERROR_MESSAGE);
            } else {
                MusicCollection.updateRecord(selectedIndex, title, artist, year, genre);
                JOptionPane.showMessageDialog(this, "Зміни збережено!", "Успіх", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Оберіть запис для редагування.", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRecord() {
        int selectedIndex = recordList.getSelectedIndex();
        if (selectedIndex != -1) {
            int response = JOptionPane.showConfirmDialog(this, "Ви впевнені, що хочете видалити цей запис?", "Видалення запису", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                MusicCollection.removeRecord(selectedIndex);
                JOptionPane.showMessageDialog(this, "Запис видалено.", "Успіх", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Оберіть запис для видалення.", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        titleField.setText("");
        artistField.setText("");
        yearField.setText("");
        genreField.setText("");
    }
}
