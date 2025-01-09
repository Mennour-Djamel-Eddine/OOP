package src.clients;

import java.util.ArrayList;
import java.util.List;
import src.properties.Property;

// Renters SubClass of Clients 
public class Renters extends Clients {

    public static List<Renters> rentersList = new ArrayList<>();

    // Constructor using super() method
    public Renters(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        super(clientName, clientLastName, clientEmail, phoneNumber);
    }

    /* Buyers SubClass Methods */
    public static void addRenter(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        rentersList.add(new Renters(clientName, clientLastName, clientEmail, phoneNumber));
    }

    public static int searchRenter(int renterID) {
        for (int i = 0; i < rentersList.size(); i++) {
            if (rentersList.get(i).getClientID() == renterID) {
                return i;
            }
        }
        return -1;
    }

    public static void editRenter(int renterIndex, String UpdatedStuff, int choice) {
        switch (choice) {
            // User name update
            case 1:
                rentersList.get(renterIndex).setClientName(UpdatedStuff);
                System.out.println("You have updated the User Name successfully! ");
                break;
            // user last name update
            case 2:
                rentersList.get(renterIndex).setClientLastName(UpdatedStuff);
                System.out.println("You have updated the User Last Name successfully! ");
                break;
            // user email update
            case 3:
                rentersList.get(renterIndex).setClientEmail(UpdatedStuff);
                System.out.println("You have updated the User Email successfully! ");
                break;
            // user phone number update
            case 4:
                rentersList.get(renterIndex).setPhoneNumber(UpdatedStuff);
                System.out.println("You have updated the User Phone Number successfully! ");
                break;
            default:
                System.out.println("Error: Invalid Choice please try again!");
                break;
        }
    }

    public static void displayRenterInfo(int index) {
        if (rentersList.isEmpty()) {
            System.out.println("The List of Buyers is Empty!");
            return;
        }
        System.out.println(rentersList.get(index).toString());
    }

    public static void deleteRenter(int renterIndex) {

        rentersList.remove(renterIndex);
        System.out.println("Account has been deleted successfully!");
    }

    public static void showProperties() {
        String type = "Rent";
        for (int i = 0; i < Property.propertiesList.size(); i++) {
            if (type.equals(Property.propertiesList.get(i).getPropertyType())) {
                Property.displayProperty(i);
            }
        }
    }
}
