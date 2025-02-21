public class Account<T, U> {
    private T id;
    private U fullName;
    private int creditAccount;
    private double personalAccount;

    public Account(T id, U fullName, int creditAccount, double personalAccount) {
        this.id = id;
        this.fullName = fullName;
        this.creditAccount = creditAccount;
        this.personalAccount = personalAccount;
    }

    public T getId() {
        return id;
    }

    public U getFullName() {
        return fullName;
    }

    public boolean validateClientId() {
        return id.toString().matches("\\d{5}");
    }
    public String getClientInfo() {
        return "Client ID: " + id + ", Full Name: " + fullName;
    }
    public double getAccountBalance() {
        if (creditAccount != 0 && personalAccount != 0) {
            return creditAccount + personalAccount;
        } else if (creditAccount != 0) {
            return creditAccount;
        } else if (personalAccount != 0) {
            return personalAccount;
        } else {
            return 0;
        }
    }
}