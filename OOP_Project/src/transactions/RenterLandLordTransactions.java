package src.transactions;

import java.util.ArrayList;
import java.util.List;

public class RenterLandLordTransactions extends Transactions {
    public static List<RenterLandLordTransactions> transactionsList = new ArrayList<>();

    public RenterLandLordTransactions(String clientName, int clientID, int propertyID, int bankAccountID) {
        super(clientName, clientID, propertyID, bankAccountID);
    }

    public static void addTransaction(String clientName, int clientID, int propertyID, int bankAccountID) {
        transactionsList.add(
                new RenterLandLordTransactions(clientName, clientID, propertyID, bankAccountID));
    }

    public static int searchTransaction(int TransactionID) {
        for (int i = 0; i < transactionsList.size(); i++) {
            if (transactionsList.get(i).getTransactionID() == TransactionID) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteTransaction(int TransactionIndex) {
        transactionsList.remove(TransactionIndex);
        System.out.println("The Transaction has been deleted successfully!");

    }

    protected static void displayTransaction(int index) {
        System.out.println("Buyer ID: " + transactionsList.get(index).getClientID());
        System.out.println("Buyer Name: " + transactionsList.get(index).getClientName());
        System.out.println("Requested Property ID: " + transactionsList.get(index).getPropertyID());
        System.out.println("Transaction ID: " + transactionsList.get(index).getTransactionID());
    }

    public static void showUserTransactions(int UserID) {
        int found = -1;
        for (int i = 0; i < transactionsList.size(); i++) {
            if (transactionsList.get(i).getClientID() == UserID) {
                displayTransaction(i);
                found = 1;
            }
        }
        if (found == -1) {
            System.out.println("There's no transactions for this user!");
        }
    }
}
