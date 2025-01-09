package src.transactions;

public abstract class Transactions {

    // Attributes
    private String clientName;
    private int clientID;
    private int propertyID;
    private int bankAccountID;
    private final int transactionID;
    private static int startID = 1000242400;
    
    // Constructor
    public Transactions(String clientName, int clientID, int propertyID, int bankAccountID) {
        this.clientName = clientName;
        this.clientID = clientID;
        this.propertyID = propertyID;
        this.bankAccountID = bankAccountID;
        this.transactionID = startID + 1;
        startID++;
    }

    // Setters and Getters
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

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(int bankAccountID) {
        this.bankAccountID = bankAccountID;
    }
    public int getTransactionID() {
        return transactionID;
    }
}
