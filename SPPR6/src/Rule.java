import java.util.List;

class Rule {
    private String name;
    private List<Fact> conditions;
    private Fact conclusion;

    public Rule(String name, List<Fact> conditions, Fact conclusion) {
        this.name = name;
        this.conditions = conditions;
        this.conclusion = conclusion;
    }

    public String getName() {
        return name;
    }

    public List<Fact> getConditions() {
        return conditions;
    }

    public Fact getConclusion() {
        return conclusion;
    }

    public boolean isApplicable(List<Fact> facts) {
        for (Fact condition : conditions) {
            boolean matched = false;
            for (Fact fact : facts) {
                if (condition.getName().equals(fact.getName()) && condition.getValue() == fact.getValue()) {
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }
}