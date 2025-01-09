package src.transactions;
import src.properties.Property;

public class TransactionsManager {
    public static void showRequests(String type, String OwnerName, int OwnerID) {
        if (type == "Seller") { //Buyer --> Seller transaction
            for (int i = 0; i< BuyerSellerTransactions.transactionsList.size(); i++) {
                int propertyID = BuyerSellerTransactions.transactionsList.get(i).getPropertyID();
                int propertyIndex = Property.searchInArray(propertyID);
                
                if (OwnerName.equals(Property.propertiesList.get(propertyIndex).getOwnerName()) && 
                        OwnerID == Property.propertiesList.get(propertyIndex).getOwnerID()) {
                    BuyerSellerTransactions.displayTransaction(i);
                }
            }
        } else if (type == "Land Lord") { // Renter --> Land Lord
            for (int i = 0; i< RenterLandLordTransactions.transactionsList.size(); i++) {
                int propertyID = RenterLandLordTransactions.transactionsList.get(i).getPropertyID();
                int propertyIndex = Property.searchInArray(propertyID);
                
                if (OwnerName.equals(Property.propertiesList.get(propertyIndex).getOwnerName()) && 
                        OwnerID == Property.propertiesList.get(propertyIndex).getOwnerID()) {
                    RenterLandLordTransactions.displayTransaction(i);
                }
            }
        }
    }

    public static int searchTransaction(int transactionID) {
        for (int i = 0; i< BuyerSellerTransactions.transactionsList.size(); i++) {
            if (BuyerSellerTransactions.transactionsList.get(i).getTransactionID() == transactionID) {
                return i;
            }
        }
        return -1;
    }

    public static void acceptRequest(String type, int transactionIndex) {
        if (type == "Seller") { // Buyer --> Seller
            // Changing the owner proprty name and id to the new one
            int propertyID = BuyerSellerTransactions.transactionsList.get(transactionIndex).getPropertyID();
            int propertyIndex = Property.searchInArray(propertyID);
            Property.deleteProperty(propertyIndex); // Delete from the list of properties for (sale/rent)
            BuyerSellerTransactions.deleteTransaction(transactionIndex);

            System.out.println("The request has been accepted successfully!");

        } else if (type == "Land Lord") {
            // Changing the owner proprty name and id to the new one
            int propertyID = RenterLandLordTransactions.transactionsList.get(transactionIndex).getPropertyID();
            int propertyIndex = Property.searchInArray(propertyID);
            Property.deleteProperty(propertyIndex); // Delete from the list of properties for (sale/rent)
            RenterLandLordTransactions.deleteTransaction(transactionIndex);

            System.out.println("The request has been accepted successfully!");
        }
    }
}
