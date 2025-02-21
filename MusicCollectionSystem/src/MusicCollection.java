import javax.swing.*;
import java.util.ArrayList;

public class MusicCollection {
    private static ArrayList<String> collection = new ArrayList<>();
    private static DefaultListModel<String> listModel = new DefaultListModel<>();

    // Получение списка записей
    public static DefaultListModel<String> getListModel() {
        return listModel;
    }

    // Добавление записи
    public static void addRecord(String title, String artist, String year, String genre) {
        String record = title + " - " + artist + " (" + year + ") [" + genre + "]";
        collection.add(record);
        listModel.addElement(record);
    }

    // Редактирование записи
    public static void updateRecord(int index, String title, String artist, String year, String genre) {
        String updatedRecord = title + " - " + artist + " (" + year + ") [" + genre + "]";
        collection.set(index, updatedRecord);
        listModel.set(index, updatedRecord);
    }

    // Удаление записи
    public static void removeRecord(int index) {
        collection.remove(index);
        listModel.remove(index);
    }

    // Получение записи по индексу
    public static String getRecord(int index) {
        return collection.get(index);
    }
}
