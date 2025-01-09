package src.clients;

import java.util.ArrayList;
import java.util.List;
import src.properties.Property;

// Sellers SubClass of Clients 
public class Sellers extends Clients {

    public static List<Sellers> sellersList = new ArrayList<>();

    // Constructor using super() method
    public Sellers(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        super(clientName, clientLastName, clientEmail, phoneNumber);
    }

    /* Buyers SubClass Methods */
    public static void addSeller(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        sellersList.add(new Sellers(clientName, clientLastName, clientEmail, phoneNumber));
    }

    public static int searchSeller(int sellerID) {
        for (int i = 0; i < sellersList.size(); i++) {
            if (sellersList.get(i).getClientID() == sellerID) {
                return i;
            }
        }
        return -1;
    }

    public static void editSeller(int sellerIndex, String UpdatedStuff, int choice) {
        switch (choice) {
            // User name update
            case 1:
                sellersList.get(sellerIndex).setClientName(UpdatedStuff);
                System.out.println("You have updated the User Name successfully! ");
                break;
            // user last name update
            case 2:
                sellersList.get(sellerIndex).setClientLastName(UpdatedStuff);
                System.out.println("You have updated the User Last Name successfully! ");
                break;
            // user email update
            case 3:
                sellersList.get(sellerIndex).setClientEmail(UpdatedStuff);
                System.out.println("You have updated the User Email successfully! ");
                break;
            // user phone number update
            case 4:
                sellersList.get(sellerIndex).setPhoneNumber(UpdatedStuff);
                System.out.println("You have updated the User Phone Number successfully! ");
                break;
            default:
                System.out.println("Error: Invalid Choice please try again!");
                break;
        }
    }

    public static void displaySellerInfo(int index) {
        if (sellersList.isEmpty()) {
            System.out.println("The List of Buyers is Empty!");
            return;
        }
        System.out.println(sellersList.get(index).toString());
    }

    public static void deleteSeller(int sellerID, String UpdatedStuff, String UserName, int UserID) {
        int index = searchSeller(sellerID);
        if (index == -1) {
            System.out.println("Error: Couldn't find this Buyer ID. Please try again!");
            return;
        }
        if (UserName.equals(sellersList.get(index).getClientName()) && UserID == sellersList.get(index).getClientID()) {
            sellersList.remove(index);
            System.out.println("Account has been deleted successfully!");
        } else if (!UserName.equals(sellersList.get(index).getClientName())
                || UserID != sellersList.get(index).getClientID()) {
            System.out.println("Error: You don't have the permission to delete this account!");
        }
    }

    public static void displaySellerProperties(int SellerID) {
        for (int i = 0; i < Property.propertiesList.size(); i++) {
            if (Property.propertiesList.get(i).getOwnerID() == SellerID) {
                Property.displayProperty(i);
            }
        }
    }
}
