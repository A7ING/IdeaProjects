import java.util.HashMap;
import java.util.Map;
import java.util.Random;
class VetClinic {
private Map<String, Animal> animalRegistry = new HashMap<>();

public void addAnimal(AnimalType type, String name, String ownerIpn, String ownerName,
        String diagnosis, double weight, String treatment, String lastVisitDate) {
        Animal animal;
        switch (type) {
        case CAT:
        animal = new Cat(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate, "Normal");
        break;
        case DOG:
        animal = new Dog(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate, "Normal");
        break;
        case BIRD:
        animal = new Bird(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate, "Good", "Good");
        break;
        case FISH:
        animal = new Fish(name, ownerIpn, ownerName, diagnosis, weight, treatment, lastVisitDate, "Good");
        break;
default:
        throw new IllegalArgumentException("Unsupported animal type");
        }
        animalRegistry.put(ownerIpn, animal);
        }

public void searchAnimalByOwnerIpn(String ownerIpn) {
        if (animalRegistry.containsKey(ownerIpn)) {
        Animal animal = animalRegistry.get(ownerIpn);
        System.out.println(animal);
        } else {
        System.out.println("Animal not found for owner with IPN: " + ownerIpn);
        }
        }

public void calculateVisitCost(String ownerIpn) {
        if (animalRegistry.containsKey(ownerIpn)) {
        Animal animal = animalRegistry.get(ownerIpn);
        double cost = getPriceForAnimalType(animal) * animal.getWeight();
        String clinicName = "Veterinary Clinic";
        String prophecy = getRandomProphecy();

        System.out.println("Invoice:");
        System.out.println("Owner IPN: " + ownerIpn);
        System.out.println("Clinic: " + clinicName);
        System.out.println("Total cost: $" + cost);
        System.out.println("Prophecy: " + prophecy);
        } else {
        System.out.println("Animal not found for owner with IPN: " + ownerIpn);
        }
        }

private double getPriceForAnimalType(Animal animal) {
        switch (animal.getClass().getSimpleName()) {
        case "Cat":
        return 10.0;
        case "Dog":
        return 15.0;
        case "Bird":
        return 8.0;
        case "Fish":
        return 5.0;
default:
        throw new IllegalArgumentException("Unsupported animal type");
        }
        }

private String getRandomProphecy() {
        String[] prophecies = {
        "You will have a wonderful day!",
        "Unexpected joy is coming your way.",
        "Be prepared for a positive change.",
        "Good things come to those who care for their pets.",
        "Your pet sends you love and good vibes."
        };
        Random random = new Random();
        return prophecies[random.nextInt(prophecies.length)];
        }
        }