package src.clients;

import java.util.ArrayList;
import java.util.List;
import src.properties.Property;

// Buyers SubClass of Clients 
public class Buyers extends Clients {
    // declaring the Buyers array
    public static List<Buyers> buyersList = new ArrayList<>();

    // Constructor using super() method
    public Buyers(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        super(clientName, clientLastName, clientEmail, phoneNumber);
    }

    /* Buyers SubClass Methods */
    public static void addBuyer(String clientName, String clientLastName, String clientEmail, String phoneNumber) {
        buyersList.add(new Buyers(clientName, clientLastName, clientEmail, phoneNumber));
    }

    public static int searchBuyer(int buyerID) {
        for (int i = 0; i < buyersList.size(); i++) {
            if (buyersList.get(i).getClientID() == buyerID) {
                return i;
            }
        }
        return -1;
    }

    public static void editBuyer(String UpdatedStuff, int choice, int buyerIndex) {
        switch (choice) {
            // User name update
            case 1:
                buyersList.get(buyerIndex).setClientName(UpdatedStuff);
                System.out.println("You have updated the User Name successfully! ");

                break;
            // user last name update
            case 2:
                buyersList.get(buyerIndex).setClientLastName(UpdatedStuff);
                System.out.println("You have updated the User Last Name successfully! ");

                break;
            // user email update
            case 3:
                buyersList.get(buyerIndex).setClientEmail(UpdatedStuff);
                System.out.println("You have updated the User Email successfully! ");

                break;
            // user phone number update
            case 4:
                buyersList.get(buyerIndex).setPhoneNumber(UpdatedStuff);
                System.out.println("You have updated the User Phone Number successfully! ");

                break;
            default:
                System.out.println("Error: Invalid Choice please try again!");
                break;
        }
    }

    public static void displayBuyerInfo(int index) {
        if (buyersList.isEmpty()) {
            System.out.println("The List of Buyers is Empty!");
            return;
        }
        System.out.println(buyersList.get(index).toString());
    }

    public static void deleteBuyer(int index) {
        buyersList.remove(index);
        System.out.println("Account has been deleted successfully!");
    }

    public static void showProperties() {
        String type = "Sell";
        for (int i = 0; i < Property.propertiesList.size(); i++) {
            if (type.equals(Property.propertiesList.get(i).getPropertyType())) {
                Property.displayProperty(i);
            }
        }
    }
}
