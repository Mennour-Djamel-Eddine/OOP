package src.reports;

public class Contract {
    // Static method to generate a contract
    public static void generateContract(int propertyID, String ownerName, int ownerID, 
                                        String clientName, int clientID, String contractType, float price) {
        // Display the contract details
        System.out.println("=== Contract Details ===");
        System.out.println("Contract Type: " + contractType);
        System.out.println("Property ID: " + propertyID);
        System.out.println("Owner: " + ownerName + " (ID: " + ownerID + ")");
        System.out.println("Client: " + clientName + " (ID: " + clientID + ")");
        System.out.println("Price: $" + price);
        System.out.println("========================");
    }
}
