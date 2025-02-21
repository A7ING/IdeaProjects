import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VetClinic clinic = new VetClinic();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the details for the new animal:");
        System.out.print("Type (CAT, DOG, BIRD, FISH): ");
        AnimalType type = AnimalType.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Owner's IPN: ");
        String ownerIpn = scanner.nextLine();

        System.out.print("Owner's Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Weight: ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Last Visit Date (YYYY-MM-DD): ");
        String lastVisitDate = scanner.nextLine();

        clinic.addAnimal(type, name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate);

        System.out.print("Enter owner's IPN to search for the animal: ");
        String searchOwnerIpn = scanner.nextLine();
        clinic.searchAnimalByOwnerIpn(searchOwnerIpn);

        System.out.print("Enter owner's IPN to calculate visit cost: ");
        String costOwnerIpn = scanner.nextLine();
        clinic.calculateVisitCost(costOwnerIpn);
    }
}