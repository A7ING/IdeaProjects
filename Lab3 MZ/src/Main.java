import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter client ID: ");
        String clientId = scanner.nextLine();

        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter credit account: ");
        int creditAccount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter personal account: ");
        double personalAccount = scanner.nextDouble();
        scanner.nextLine();
        while (true) {
            System.out.print("Enter client ID again: ");
            String enteredId = scanner.nextLine();

            System.out.print("Enter client name again: ");
            String enteredName = scanner.nextLine();

            if (clientId.equals(enteredId) && clientName.equals(enteredName)) {
                break;
            } else {
                System.out.println("IDs or names do not match. Please try again.");
            }
        }

        Account<String, String> bankAccount = new Account<>(clientId, clientName, creditAccount, personalAccount);

        if (bankAccount.validateClientId()) {
            System.out.println("Client Info: " + bankAccount.getClientInfo());
            System.out.println("Account Balance: $" + bankAccount.getAccountBalance());
        } else {
            System.out.println("Invalid client ID. Exiting program.");
        }

        scanner.close();
    }
}