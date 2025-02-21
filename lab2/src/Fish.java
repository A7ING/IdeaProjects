class Fish extends Animal {
    private String finState;

    public Fish(String name, String ownerIpn, String ownerName, String diagnosis, double weight,
                String treatment, String lastVisitDate, String finState) {
        super(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate);
        this.finState = finState;
    }

    @Override
    public String toString() {
        return super.toString() + ", finState='" + finState + '\'';
    }
}


