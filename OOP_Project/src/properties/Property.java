package src.properties;

// Done and all functions work perfectly 
// Import modules 
import java.util.ArrayList;
import java.util.List;

// Property Class
public class Property {
    // Define Attributes
    private final int propertyID;
    private String propertyType; // For (Sale/Rent)
    private String size;
    private float price;
    private String location;
    private boolean status;
    private String ownerName;
    private int ownerID;
    // List of propesties created
    public static List<Property> propertiesList = new ArrayList<>();
    private static int startID = 2024000;

    // Genrate Parameterized Constructor
    public Property(String propertyType, String size, float price, String location, boolean status, String ownerName,
            int ownerID) {
        this.propertyType = propertyType;
        this.size = size;
        this.price = price;
        this.location = location;
        this.status = status;
        this.ownerName = ownerName;
        this.ownerID = ownerID;
        this.propertyID = startID + 1;
        startID++;
    }

    // Generate Getters and Setters Functions for each Attribute
    public int getPropertyID() {
        return this.propertyID;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public static void addProperty(String propertyType, String size, float price, String location, boolean status,
            String ownerName, int ownerID) {
        propertiesList.add(new Property(propertyType, size, price, location, status, ownerName, ownerID));
        System.out.println("Property added successfully! ");
    }

    public static int searchInArray(int propertyID) {
        for (int i = 0; i < propertiesList.size(); i++) {
            if (propertiesList.get(i).getPropertyID() == propertyID) {
                return i;
            }
        }
        return -1;
    }

    public static void displayProperty(int propertyIndex) {
        System.out.println("1-Property ID: " + propertiesList.get(propertyIndex).propertyID);
        System.out.println("2-Property Type: " + propertiesList.get(propertyIndex).propertyType);
        System.out.println("3-Property Size: " + propertiesList.get(propertyIndex).size);
        System.out.println("4-Property Price: " + propertiesList.get(propertyIndex).price);
        System.out.println("5-Property Location: " + propertiesList.get(propertyIndex).location);
        System.out.println("6-Property Status: " + propertiesList.get(propertyIndex).status);
        System.out.println("7-Property Owner Name: " + propertiesList.get(propertyIndex).ownerName);
        System.out.println("8-Property Owner ID: " + propertiesList.get(propertyIndex).ownerID);
    }

    // Applying Over Loading Method
    public static void searchProperties(String criteria, int choice, String accountType) {
        switch (choice) {
            case 1:
                for (int i = 0; i < propertiesList.size(); i++) {
                    if (criteria.equals(propertiesList.get(i).getSize())) {
                        if (accountType.equals(propertiesList.get(i).getPropertyType()))
                            displayProperty(i);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < propertiesList.size(); i++) {
                    if (criteria.equals(propertiesList.get(i).getLocation())) {
                        if (accountType.equals(propertiesList.get(i).getPropertyType()))
                            displayProperty(i);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < propertiesList.size(); i++) {
                    if (criteria.equals(propertiesList.get(i).getOwnerName())) {
                        if (accountType.equals(propertiesList.get(i).getPropertyType()))
                            displayProperty(i);
                    }
                }
                break;
            default:
                System.out.println("Error: Invalid choice, please enter a number from 1 to 6!");
                break;
        }
    }

    public static int searchProperty(int propertyID) {
        for (int i = 0; i < propertiesList.size(); i++) {
            if (propertiesList.get(i).getPropertyID() == propertyID) {
                displayProperty(propertyID);
                return 1;
            }
        }
        return -1; // not found
    }

    public static void searchProperties(int criteria, String AccountType) {
        for (int i = 0; i < propertiesList.size(); i++) {
            if (criteria == propertiesList.get(i).getOwnerID()) {
                if (AccountType.equals(propertiesList.get(i).getPropertyType()))
                    displayProperty(i);
            }
        }

    }

    public static void searchProperties(float criteria, String AccountType) {
        for (int i = 0; i < propertiesList.size(); i++) {
            if (criteria == propertiesList.get(i).getPrice()) {
                if (AccountType.equals(propertiesList.get(i).getPropertyType()))
                    displayProperty(i);
            }
        }
    }

    // Using OverLoading method
    public static void editProperty(String UpdatedStuff, int choice, int propertyIndex) {

        switch (choice) {
            case 1:
                propertiesList.get(propertyIndex).setPropertyType(UpdatedStuff);
                System.out.println("Criteria Updated Successfully! ");
                break;
            case 2:
                propertiesList.get(propertyIndex).setSize(UpdatedStuff);
                System.out.println("Criteria Updated Successfully! ");
                break;
            case 3:
                propertiesList.get(propertyIndex).setLocation(UpdatedStuff);
                System.out.println("Criteria Updated Successfully! ");
                break;
            case 4:
                propertiesList.get(propertyIndex).setOwnerName(UpdatedStuff);
                System.out.println("Criteria Updated Successfully! ");
                break;
            default:
                System.out.println("Error: Invalid choice, please enter a number between (1-6)");
                break;
        }
    }

    public static void editProperty(int propertyIndex, int choice, int UpdatedStuff) {
        // it can be either owner id or property price

        System.out.println("You can Edit the following criteria: \n1-Owner ID\n2-Property Price");
        System.out.println("Enter Your Choice(1-2): ");

        switch (choice) {
            case 1:
                propertiesList.get(propertyIndex).setOwnerID(UpdatedStuff);
                System.out.println("Owner ID Updated Successfully");
                break;
            case 2:
                propertiesList.get(propertyIndex).setPrice(UpdatedStuff);
                System.out.println("Property Price Updated Successfully");
                break;
            default:
                System.out.println("Error: Invalid Choice, please enter a number from 1 to 2!");
                break;
        }

    }

    public static void deleteProperty(int propertyIndex) {
        propertiesList.remove(propertyIndex);
        System.out.println("The property has been deleted properly!");
    }
}
