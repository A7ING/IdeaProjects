import java.util.*;

public class CatFactory {
    private List<Cat> cats = new ArrayList<>();
    private Set<String> types = new HashSet<>();
    private Map<String, List<Cat>> catsByTypes = new HashMap<>();
    private Scanner scanner;

    public CatFactory() {
        this.scanner = new Scanner(System.in);
    }

    public void generateCats(int n) {
        String[] availableTypes = {"Сіамська", "Персидська", "Британська", "Скотіш фолд", "Сибірська", "Українська левкойська", "Мейн-кун", "Бенгальська", "Курільська бобтейл"};
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String randomType = availableTypes[random.nextInt(availableTypes.length)];
            Cat cat = new Cat(randomType);
            cats.add(cat);

            types.add(randomType);

            catsByTypes.computeIfAbsent(randomType, k -> new ArrayList<>()).add(cat);
        }
    }

    public void removeCat(int index) {
        if (index >= 0 && index < cats.size()) {
            Cat removedCat = cats.remove(index);
            String type = removedCat.getType();

            List<Cat> catList = catsByTypes.get(type);
            catList.remove(removedCat);

            if (catList.isEmpty()) {
                catsByTypes.remove(type);
                types.remove(type);
            }
            System.out.println("\nUpdated Cats by Types (Count):");// Оновлення кількості котиків для кожного типу
            catsByTypes.forEach((catType, catsList) ->
                    System.out.println(catType + ": " + catsList.size()));
        }
    }

    public void addCat(String newType, int count) {
        for (int i = 0; i < count; i++) {
            Cat newCat = new Cat(newType);
            cats.add(newCat);
            types.add(newType);
            catsByTypes.computeIfAbsent(newType, k -> new ArrayList<>()).add(newCat);
        }
    }

    public void printCollections() {
        System.out.println("All Cats:");
        cats.forEach(cat -> System.out.println(cat.getType()));

        System.out.println("\nAll Types:");
        types.forEach(System.out::println);

        System.out.println("\nCats by Types:");
        catsByTypes.forEach((type, catList) ->
                System.out.println(type + ": " + catList.size()));
    }
    public int getUserInput() {
        return scanner.nextInt();
    }
    public String getUserInputString() {
        return scanner.next();
    }
}
