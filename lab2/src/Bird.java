class Bird extends Animal {
    private String featherState;
    private String beakState;

    public Bird(String name, String ownerIpn, String ownerName, String diagnosis, double weight,
                String treatment, String lastVisitDate, String featherState, String beakState) {
        super(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate);
        this.featherState = featherState;
        this.beakState = beakState;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", featherState='" + featherState + '\'' +
                ", beakState='" + beakState + '\'';
    }
}