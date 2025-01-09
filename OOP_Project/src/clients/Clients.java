package src.clients;

// Parent Class
public class Clients {
    // Atributes declaration 
    private String clientName;
    private String clientLastName;
    private final int clientID;
    private String clientEmail;
    private String phoneNumber;
    private static int startID = 24242400;

    // Constructor Declaration 
    public Clients(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientID = startID + 1;
        this.clientEmail = clientEmail;
        this.phoneNumber = phoneNumber;
        startID++;
    }

    // Getters and Setters Methods
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientLastName() {
        return clientLastName;
    }
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }
    public int getClientID() {
        return clientID;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Clients [clientName=" + clientName + ", clientLastName=" + clientLastName + ", clientID=" + clientID
                + ", clientEmail=" + clientEmail + ", phoneNumber=" + phoneNumber + "]";
    }
}
