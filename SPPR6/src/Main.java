import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ExpertSystem expertSystem = new ExpertSystem();

        // Факти фінансового стану клієнта
        Fact hasAssets = new Fact("Клієнт має активи на суму 500,000 грн.", 300000);  // 500,000 грн
        Fact hasDebts = new Fact("Клієнт має борги на суму 200,000 грн.", 200000);    // 200,000 грн
        Fact monthlyIncome = new Fact("Клієнт отримує дохід 50,000 грн на місяць.", 50000);  // 50,000 грн на місяць

        // Додавання фактів
        expertSystem.addFact(hasAssets);
        expertSystem.addFact(hasDebts);
        expertSystem.addFact(monthlyIncome);

        // Перевірка, чи борг не більший за половину активів
        if (hasDebts.getValue() <= hasAssets.getValue() / 2) {
            // Умови для високого кредитного рейтингу
            Fact hasHighCreditRating = new Fact("Клієнт має високий кредитний рейтинг", 1);  // Используем 1 для true

            // Додавання факту високого кредитного рейтингу
            expertSystem.addFact(hasHighCreditRating);

            // Правила для підвищення кредитного ліміту
            Rule rule = new Rule("Кредитний рейтинг високий", Arrays.asList(hasHighCreditRating),
                    new Fact("Розглянути підвищення кредитного ліміту", 1));  // Используем 1 для true

            // Додавання правил
            expertSystem.addRule(rule);

            // Виконання виведення
            expertSystem.infer();
        } else {
            System.out.println("Борг клієнта більше ніж половина активів. Підвищення кредитного ліміту неможливе.");
        }

        // Виведення всіх фактів
        System.out.println("Факти:");
        for (Fact fact : expertSystem.getFacts()) {
            System.out.println(fact);
        }
    }
}