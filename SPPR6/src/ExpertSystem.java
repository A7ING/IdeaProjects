import java.util.ArrayList;
import java.util.List;

public class ExpertSystem {
    private List<Fact> facts;
    private List<Rule> rules;

    public ExpertSystem() {
        facts = new ArrayList<>();
        rules = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void infer() {
        boolean newFactsAdded;
        do {
            newFactsAdded = false;
            for (Rule rule : rules) {
                if (rule.isApplicable(facts)) {
                    Fact conclusion = rule.getConclusion();
                    if (!facts.contains(conclusion)) {
                        facts.add(conclusion);
                        System.out.println("Правило застосовано: " + rule.getName());
                        // Изменение вывода факта на true/false
                        String factValue = conclusion.getValue() == 1.0 ? "true" : "false";
                        System.out.println("Новий факт: " + conclusion.getName() + " = " + factValue);
                        newFactsAdded = true;
                    }
                }
            }
        } while (newFactsAdded);
    }

    public List<Fact> getFacts() {
        return facts;
    }
}
