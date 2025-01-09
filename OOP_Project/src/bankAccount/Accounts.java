package src.bankAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private String accountType;
    private final int cardNumber;
    private static int cardNumStart = 928732100;
    private String cardExpiredDate;
    private String clientName;
    private int clientID;
    private float amount;
    private final int accountID;
    private static int startID = 92881900;

    public static List<Accounts> accountsList = new ArrayList<>();

    public Accounts(String accountType, String clientName, int clientID, int amount) {
        this.accountType = accountType;
        this.clientName = clientName;
        this.clientID = clientID;
        this.accountID = startID + 1;
        this.cardNumber = cardNumStart + 1;
        cardNumStart++;
        startID++;

        // Get today's date
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentMonth = today.getMonthValue();

        // Add 4 months manually
        int newMonth = currentMonth + 4;
        int newYear = currentYear;

        if (newMonth > 12) {
            newMonth -= 12;
            newYear += 1;
        }
        // Format the expiration date as "MM-yyyy"
        this.cardExpiredDate = String.format("%02d-%d", newMonth, newYear);
    }

    public static void addAccount(String accountType, String clientName, int clientID, int amount) {
        accountsList.add(new Accounts(accountType, clientName, clientID, amount));
        System.out.println("Bank Account Added Successfully!");
    }

    public static int searchAccount(int accountID) {
        for (int i = 0; i< accountsList.size(); i++) {
            if (accountsList.get(i).accountID == accountID) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteAccount(int accountIndex) {
        accountsList.remove(accountIndex);
        System.out.println("The account has been deleted successfully!");
    }

    public static void displayAccountInfo(int accountIndex) {
        System.out.println("1- Account type: "+ accountsList.get(accountIndex).getAccountType());
        System.out.println("2- Card Number: "+ accountsList.get(accountIndex).getCardNumber());
        System.out.println("3- Card Expired Date: "+ accountsList.get(accountIndex).getCardExpiredDate());
        System.out.println("4- User Name: "+ accountsList.get(accountIndex).getClientName());
        System.out.println("5- Client ID: "+ accountsList.get(accountIndex).getClientID());
        System.out.println("6- Account Amount: "+ accountsList.get(accountIndex).getAmount());
        System.out.println("7- Account ID: "+ accountsList.get(accountIndex).getAccountID());
    }

    // Function that return Account object
    public static Accounts getAccount(int accountIndex) {
        return accountsList.get(accountIndex);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiredDate() {
        return cardExpiredDate;
    }

    public void setCardExpiredDate(String cardExpiredDate) {
        this.cardExpiredDate = cardExpiredDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getAccountID() {
        return accountID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
}
