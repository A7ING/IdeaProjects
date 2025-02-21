import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість котиків (n): ");
        int n = scanner.nextInt();

        CatFactory catFactory = new CatFactory();
        catFactory.generateCats(n);

        catFactory.printCollections();

        System.out.print("Введіть номер котика для видалення: ");
        int catIndexToRemove = catFactory.getUserInput() - 1;
        catFactory.removeCat(catIndexToRemove);

        System.out.print("Введіть новий тип котика: ");
        String newType = catFactory.getUserInputString();
        System.out.print("Введіть кількість котиків: ");
        int count = catFactory.getUserInput();
        catFactory.addCat(newType, count);

        catFactory.printCollections();

        scanner.close();
    }
}