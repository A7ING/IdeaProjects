class Animal {
    private String name;
    private String ownerIpn;
    private String ownerName;
    private String diagnosis;
    private double weight;
    private String treatment;
    private String lastVisitDate;

    public Animal(String name, String ownerIpn, String ownerName, String diagnosis, double weight,
                  String treatment, String lastVisitDate) {
        this.name = name;
        this.ownerIpn = ownerIpn;
        this.ownerName = ownerName;
        this.diagnosis = diagnosis;
        this.weight = weight;
        this.treatment = treatment;
        this.lastVisitDate = lastVisitDate;
    }
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", ownerIpn='" + ownerIpn + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", weight=" + weight +
                ", treatment='" + treatment + '\'' +
                ", lastVisitDate='" + lastVisitDate + '\'' +
                '}';
    }
}