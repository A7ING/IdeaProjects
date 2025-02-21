class Dog extends Animal {
    private String tailState;

    public Dog(String name, String ownerIpn, String ownerName, String diagnosis, double weight,
               String treatment, String lastVisitDate, String tailState) {
        super(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate);
        this.tailState = tailState;
    }

    @Override
    public String toString() {
        return super.toString() + ", tailState='" + tailState + '\'';
    }
}