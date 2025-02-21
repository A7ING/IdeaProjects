import java.util.List;
public class Controller {
    public void initController() {
        View view = new View();
        Model model = new Model();

        while (true) {
            view.printMenuData();
            Integer command = view.readCommand();
            if (command.equals(5)) {
                break;
            } else if (command.equals(1)) {
                view.printIncomingString("Введіть дані для додавання:");
                String name = view.name();
                String group = view.group();
                String subject = view.subject();
                Integer mark = view.mark("");
                model.create(name, mark, group, subject);
                view.printIncomingString("Дані додано");
            } else if (command.equals(2)) {
                view.printIncomingString("Введіть дані для пошуку:");
                String subject = view.subject();
                List<Data> foundData = model.find(subject);
                if (!foundData.isEmpty()) {
                    for (Data data : foundData) {
                        view.printData(data);
                    }
                } else {
                    view.printIncomingString("Дані не знайдено");
                }
            } else if (command == 3) {
                view.printIncomingString("Введіть дані: ");
                String name = view.name();
                String subject = view.subject();
                Integer newMark = view.mark("Введіть нову оцінку: ");

                Data newData = model.update(name, subject, newMark);

                view.printIncomingString("Результат оновлення:");
                if (newData != null) {
                    view.printData(newData);
                } else {
                    view.printIncomingString("Нічого оновлювати");
                }
            } else if (command == 4) {
                view.printIncomingString("Введіть дані для видалення результату:");
                String subject = view.subject();
                String name = view.name();
                int index = model.delete(name, subject);
                if (index != -1) {
                    view.printIncomingString("Результат студента - " + name + " з предмету - " + subject + " було видалено");
                } else {
                    view.printIncomingString("Дані з предметом " + subject + " та ім'ям " + name + " не були знайдені для видалення");
                }
            } else {
                view.printIncomingString("Невірна команда");
            }
        }
    }
}