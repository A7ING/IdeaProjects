import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Запуск графического интерфейса в потоке обработки событий Swing
        SwingUtilities.invokeLater(() -> {
            MusicCollectionFrame frame = new MusicCollectionFrame();
            frame.setVisible(true);
        });
    }
}