package src.clients;

import java.util.ArrayList;
import java.util.List;

import src.properties.Property;

// LandLords SubClass of Clients 
public class LandLords extends Clients {

    public static List<LandLords> landLordsList = new ArrayList<>();

    // Constructor using super() method
    public LandLords(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        super(clientName, clientLastName, clientEmail, phoneNumber);
    }

    /* Buyers SubClass Methods */
    public static void addLandLord(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        landLordsList.add(new LandLords(clientName, clientLastName, clientEmail, phoneNumber));
    }

    public static int searchLandLord(int landLordID) {
        for (int i = 0; i < landLordsList.size(); i++) {
            if (landLordsList.get(i).getClientID() == landLordID) {
                return i;
            }
        }
        return -1;
    }

    public static void editLandLord(int landLordIndex, String UpdatedStuff, int choice) {
        switch (choice) {
            // User name update
            case 1:

                landLordsList.get(landLordIndex).setClientName(UpdatedStuff);
                System.out.println("You have updated the User Name successfully! ");
                break;
            // user last name update
            case 2:
                landLordsList.get(landLordIndex).setClientLastName(UpdatedStuff);
                System.out.println("You have updated the User Last Name successfully! ");
                break;
            // user email update
            case 3:
                landLordsList.get(landLordIndex).setClientEmail(UpdatedStuff);
                System.out.println("You have updated the User Email successfully! ");
                break;
            // user phone number update
            case 4:
                landLordsList.get(landLordIndex).setPhoneNumber(UpdatedStuff);
                System.out.println("You have updated the User Phone Number successfully! ");
                break;
            default:
                System.out.println("Error: Invalid Choice please try again!");
                break;
        }
    }

    public static void displayLandLordInfo(int index) {
        if (landLordsList.isEmpty()) {
            System.out.println("The List of Buyers is Empty!");
            return;
        }
        System.out.println(landLordsList.get(index).toString());
    }

    public static void deleteLandLord(int landLordID, String UpdatedStuff, String UserName, int UserID) {
        int index = searchLandLord(landLordID);
        if (index == -1) {
            System.out.println("Error: Couldn't find this Land Lord ID. Please try again!");
            return;
        }
        if (UserName.equals(landLordsList.get(index).getClientName())
                && UserID == landLordsList.get(index).getClientID()) {
            landLordsList.remove(index);
            System.out.println("Account has been deleted successfully!");
        } else if (!UserName.equals(landLordsList.get(index).getClientName())
                || UserID != landLordsList.get(index).getClientID()) {
            System.out.println("Error: You don't have the permission to delete this account!");
        }
    }

    public static void displayLandLordrProperties(int LandLordID) {
        for (int i = 0; i < Property.propertiesList.size(); i++) {
            if (Property.propertiesList.get(i).getOwnerID() == LandLordID) {
                Property.displayProperty(i);
            }
        }
    }
}
