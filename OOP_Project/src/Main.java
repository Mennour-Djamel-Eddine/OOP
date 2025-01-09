/* Developed By: Mennour Djamel Eddine                 */
/* Project: Real Estate Agency Management Application */

// Package Declaration 
package src;

import java.util.Scanner;
import src.clients.*;
import src.properties.*;
import src.transactions.*;
import src.bankAccount.*;
import src.reports.*;

// Main Class
public class Main {
    /* Sign-In Sign-Up Log-out System */
    // Sign-Up Function
    public static int Sign_up(String Name, String LastName, String Email, String PhoneNumber, String AccountType) {
        if (AccountType.equals("Buyer")) {
            // Add the user in the buyers array
            Buyers.addBuyer(Name, LastName, Email, PhoneNumber);
            int index = Buyers.buyersList.size() - 1;
            return Buyers.buyersList.get(index).getClientID();
        } else if (AccountType.equals("Seller")) {
            // Add the user in the sellers array
            Sellers.addSeller(Name, LastName, Email, PhoneNumber);
            int index = Sellers.sellersList.size() - 1;
            return Sellers.sellersList.get(index).getClientID();
        } else if (AccountType.equals("Renter")) {
            // Add the user in the renters array
            Renters.addRenter(Name, LastName, Email, PhoneNumber);
            int index = Renters.rentersList.size() - 1;
            return Renters.rentersList.get(index).getClientID();
        } else if (AccountType.equals("Land Lord")) {
            // Add the user in the land lords array
            LandLords.addLandLord(Name, LastName, Email, PhoneNumber);
            int index = LandLords.landLordsList.size() - 1;
            return LandLords.landLordsList.get(index).getClientID();
        }

        return -1;
    }

    // Sign-In Function
    public static boolean Sign_in(String Name, int ID, String AccountType) {
        if (AccountType.equals("Buyer")) {
            // Search in buyers array
            int index = Buyers.searchBuyer(ID);
            if (index == -1) {
                System.out.println("The ID You entered isn't Correct! ");
                return false;
            } else {
                if (Name.equals(Buyers.buyersList.get(index).getClientName())
                        && ID == Buyers.buyersList.get(index).getClientID()) {
                    return true;
                }
                return false;
            }
        } else if (AccountType.equals("Seller")) {
            // Search in buyers array
            int index = Sellers.searchSeller(ID);
            if (index == -1) {
                System.out.println("The ID You entered isn't Correct! ");
                return false;
            } else {
                if (Name.equals(Sellers.sellersList.get(index).getClientName())
                        && ID == Sellers.sellersList.get(index).getClientID()) {
                    return true;
                }
                return false;
            }
        } else if (AccountType.equals("Renter")) {
            // Search in buyers array
            int index = Renters.searchRenter(ID);
            if (index == -1) {
                System.out.println("The ID You entered isn't Correct! ");
                return false;
            } else {
                if (Name.equals(Renters.rentersList.get(index).getClientName())
                        && ID == Renters.rentersList.get(index).getClientID()) {
                    return true;
                }
                return false;
            }
        } else if (AccountType.equals("Land Lord")) {
            // Search in buyers array
            int index = LandLords.searchLandLord(ID);
            if (index == -1) {
                System.out.println("The ID You entered isn't Correct! ");
                return false;
            } else {
                if (Name.equals(LandLords.landLordsList.get(index).getClientName())
                        && ID == LandLords.landLordsList.get(index).getClientID()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void displayMenu(String accountType) {
        // Buyer Account
        if (accountType.equals("Buyer")) {
            System.out
                    .println("==================================== Buyer Account ====================================");
            System.out.println("1- Properties: ");
            System.out.println("\t1.1- Show All Available Properties That Are For Sale");
            System.out.println("\t1.2- Search For Properties using Specific Criteria(Price/ID/Owner ...etc)");
            System.out.println("\t1.3- Search For a Specific Property using Property ID");
            System.out.println("2- Account: ");
            System.out.println("\t2.1- Edit Your Account's Information");
            System.out.println("\t2.2- Display Your Account's Information");
            System.out.println("\t2.3- Delete Your Account");
            System.out.println("3- Bank Account: ");
            System.out.println("\t3.1- Add Bank Account");
            System.out.println("\t3.2- Set Amount.");
            System.out.println("\t3.3- Delete Bank Account");
            System.out.println("4- Transactions: ");
            System.out.println("\t4.1- Request a Specific Property(Add Transaction)");
            System.out.println("\t4.2- Delete a Transaction");
            System.out.println("\t4.3- Display All My Transactions");
            System.out.println("5- Exit Application ");
            System.out.println("6- Logout");
            System.out.println(
                    "========================================================================================");
        }
        // Seller Account
        else if (accountType.equals("Seller")) {
            System.out.println(
                    "==================================== Seller Account ====================================");
            System.out.println("1- Properties: ");
            System.out.println("\t1.1- Add Property");
            System.out.println("\t1.2- Display My Properties");
            System.out.println("\t1.3- Edit a Specific Property's Information");
            System.out.println("\t1.4- Delete a Specific Property");
            System.out.println("2- Account: ");
            System.out.println("\t2.1- Edit Your Account's Information");
            System.out.println("\t2.2- Display Your Account's Information");
            System.out.println("\t2.3- Delete Your Account");
            System.out.println("3- Bank Account: ");
            System.out.println("\t3.1- Add Bank Account");
            System.out.println("\t3.2- Set Amount.");
            System.out.println("\t3.3- Delete Bank Account");
            System.out.println("4- Transactions: ");
            System.out.println("\t4.1- Accept a Specific Property Request");
            System.out.println("\t4.2- Show Buy Requests");
            System.out.println("5- Exit Application ");
            System.out.println("6- Logout");
            System.out.println(
                    "========================================================================================");
        }
        // Reneter Account
        else if (accountType.equals("Renter")) {
            System.out.println(
                    "==================================== Renter Account ====================================");
            System.out.println("1- Properties: ");
            System.out.println("\t1.1- Show All Available Properties That Are For Rent");
            System.out.println("\t1.2- Search For Properties using Specific Criteria(Price/ID/Owner ...etc)");
            System.out.println("\t1.3- Search For a Specific Property using Property ID");
            System.out.println("2- Account: ");
            System.out.println("\t2.1- Edit Your Account's Information");
            System.out.println("\t2.2- Display Your Account's Information");
            System.out.println("\t2.3- Delete Your Account");
            System.out.println("3- Bank Account: ");
            System.out.println("\t3.1- Add Bank Account");
            System.out.println("\t3.2- Set Amount.");
            System.out.println("\t3.3- Delete Bank Account");
            System.out.println("4- Transactions: ");
            System.out.println("\t4.1- Request a Specific Property(Add Transaction)");
            System.out.println("\t4.2- Delete a Transaction");
            System.out.println("\t4.3- Display All My Transactions");
            System.out.println("5- Exit Application ");
            System.out.println("6- Logout");
            System.out.println(
                    "========================================================================================");
        }
        // Land Lord Account
        else if (accountType.equals("Land Lord")) {
            System.out.println(
                    "==================================== Land Lord Account ====================================");
            System.out.println("1- Properties: ");
            System.out.println("\t1.1- Add Property");
            System.out.println("\t1.2- Display My Properties");
            System.out.println("\t1.3- Edit a Specific Property's Information");
            System.out.println("\t1.4- Delete a Specific Property");
            System.out.println("2- Account: ");
            System.out.println("\t2.1- Edit Your Account's Information");
            System.out.println("\t2.2- Display Your Account's Information");
            System.out.println("\t2.3- Delete Your Account");
            System.out.println("3- Bank Account: ");
            System.out.println("\t3.1- Add Bank Account");
            System.out.println("\t3.2- Set Amount.");
            System.out.println("\t3.3- Delete Bank Account");
            System.out.println("4- Transactions: ");
            System.out.println("\t4.1- Accept a Specific Property Request");
            System.out.println("\t4.2- Show Buy Requests");
            System.out.println("5- Exit Application ");
            System.out.println("6- Logout");
            System.out.println(
                    "==========================================================================================");
        }
    }

    public static void main(String[] args) {

        // Declaring a scanner
        Scanner scanner = new Scanner(System.in);
        // Account Check
        int choice;
        System.out.println(
                "============================== Welcom To Our Agency Application ==============================");

        String menuChoice;
        do {
            String CurrentUserName = "null";
            int CurrentUserID = -100;
            String CurrentAccountType = "null";
            boolean is_valid = false;

            // Main loop to handle sign-in and sign-up
            while (!is_valid) {
                System.out.println("\nDo You have an Account(Y/n)?");
                choice = scanner.next().charAt(0);
                scanner.nextLine();

                if (choice == 'Y' || choice == 'y') {
                    System.out.println("Enter the user name: ");
                    String UserName = scanner.nextLine();

                    System.out.println("Enter Your user ID: ");
                    int UserID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Your account type (Buyer/Seller/Renter/Land Lord):");
                    String UserAccountType = scanner.nextLine();

                    if (Sign_in(UserName, UserID, UserAccountType)) {
                        CurrentUserName = UserName;
                        CurrentUserID = UserID;
                        CurrentAccountType = UserAccountType;
                        is_valid = true;
                        System.out.println("Login successfully!");
                    }
                } else if (choice == 'N' || choice == 'n') {
                    System.out.println("Enter the user name: ");
                    String UserName = scanner.nextLine();

                    System.out.println("Enter Your last name: ");
                    String userLastName = scanner.nextLine();

                    System.out.println("Enter the Email Address: ");
                    String emailAdress = scanner.nextLine();

                    System.out.println("Enter the phone number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.println("Enter the Account Type(Buyer/Seller/Renter/Land Lord): ");
                    String UserAccountType = scanner.nextLine();

                    int isValidID = Sign_up(UserName, userLastName, emailAdress, phoneNumber, UserAccountType);
                    if (isValidID != -1) {
                        System.out.println("You have been Signed up successfully!(ID: " + isValidID + ")");
                        CurrentUserID = isValidID;
                        CurrentUserName = UserName;
                        CurrentAccountType = UserAccountType;
                        is_valid = true;
                    } else {
                        System.out.println("Error while trying to sign up. Please try again!");
                    }
                } else {
                    System.out.println("Invalid choice. Please try again!");
                }
            }

            boolean exit = false;
            do {
                displayMenu(CurrentAccountType);
                System.out.println("Enter you choice(1.1 to 6):");
                menuChoice = scanner.nextLine();

                if (menuChoice.equals("6") || menuChoice.equals("5")) {
                    CurrentAccountType = "null";
                    CurrentUserID = -100;
                    CurrentUserName = "null";
                    exit = true;
                }

                if (CurrentAccountType.equals("Buyer") || CurrentAccountType.equals("Renter")) {
                    if (CurrentAccountType.equals("Buyer")) {
                        // Show available properties for sale
                        if (menuChoice.equals("1.1")) {
                            if (Property.propertiesList.size() == 0) {
                                System.out.println("Properties list is empty!");
                            } else {
                                System.out.println("----------------------------------------");
                                System.out.println("Properties List: ");
                                System.out.println("----------------------------------------");
                                Buyers.showProperties();
                                System.out.println("----------------------------------------");
                            }
                            
                            // Search properties using specific criteria
                        } else if (menuChoice.equals("1.2")) {
                            if (Property.propertiesList.size() == 0) {
                                System.out.println("Properties list is empty!");
                            } else {
                                System.out.println("Enter Your choice: ");
                                choice = scanner.nextInt();
                                scanner.nextLine();
                                if (choice == 1) {
                                    String size;
                                    System.out.println("Enter the size: ");
                                    size = scanner.nextLine();
                                    Property.searchProperties(size, choice, CurrentAccountType);
                                } else if (choice == 2) {
                                    float price;
                                    System.out.println("Enter the price: ");
                                    price = scanner.nextFloat();
                                    scanner.nextLine();
                                    Property.searchProperties(price, CurrentAccountType);
                                } else if (choice == 3) {
                                    String location;
                                    System.out.println("Enter the location: ");
                                    location = scanner.nextLine();
                                    Property.searchProperties(location, choice, CurrentAccountType);
                                } else if (choice == 4) {
                                    String OwnerName;
                                    System.out.println("Enter the Owner Name: ");
                                    OwnerName = scanner.nextLine();
                                    Property.searchProperties(OwnerName, choice, CurrentAccountType);
                                } else if (choice == 5) {
                                    int OwnerID;
                                    System.out.println("Enter the Owner ID: ");
                                    OwnerID = scanner.nextInt();
                                    scanner.nextLine();
                                    Property.searchProperties(OwnerID, CurrentAccountType);
                                } else {
                                    System.out.println("Invalid input. Please try again!");
                                }
                            }
                            // search property using property ID
                        } else if (menuChoice.equals("1.3")) {
                            if (Property.propertiesList.size() == 0) {
                                System.out.println("Properties list is empty!");
                            }
                            else {
                                int propertyID;
                                System.out.println("Enter the property ID: ");
                                propertyID = scanner.nextInt();
                                scanner.nextLine();
    
                                if (Property.searchProperty(propertyID) == -1) {
                                    System.out.println("Property ID is wrong!");
                                } else {
                                    int index = Property.searchInArray(propertyID);
                                    Property.displayProperty(index);
                                }
                            }
                            // Edit account information
                        } else if (menuChoice.equals("2.1")) {
                            int buyerIndex = Buyers.searchBuyer(CurrentUserID);

                            if (buyerIndex == -1) {
                                System.out.println("Invalid ID. Please try again!");
                            } else {
                                System.out.println("You can edit the following fields: ");
                                System.out.println("1- Change user name");
                                System.out.println("2- Change user last name");
                                System.out.println("3- Change user email");
                                System.out.println("4- Change user phone number");

                                System.out.println("Enter your choice: ");
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Enter the updated version: ");
                                String UpdatedStuff = scanner.nextLine();

                                if (choice >= 1 && choice <= 4) {
                                    Buyers.editBuyer(UpdatedStuff, choice, buyerIndex);
                                    System.out.println("Information Updated Successfully!");
                                } else {
                                    System.out.println("Invalid choice! Please try again later");
                                }
                            }
                            // Display account information
                        } else if (menuChoice.equals("2.2")) {
                            int index = Buyers.searchBuyer(CurrentUserID);
                            if (index == -1) {
                                System.out.println("The ID that you've entered is wrong! Please try again");
                            } else {
                                System.out.println("---------------------------------------------");
                                System.out.println("Buyer information:");
                                System.out.println("---------------------------------------------");
                                Buyers.displayBuyerInfo(index);
                                System.out.println("---------------------------------------------");
                            }
                            // Delete account
                        } else if (menuChoice.equals("2.3")) {
                            int index = Buyers.searchBuyer(CurrentUserID);
                            if (index == -1) {
                                System.out.println("Wrong ID");
                            } else {
                                System.out.println("Are you sure you want to delete your account(Y/n)?");
                                char confirmation = scanner.nextLine().charAt(0);
                                if (confirmation == 'Y' || confirmation == 'y') {
                                    Buyers.deleteBuyer(index);
                                    CurrentAccountType = "null";
                                    CurrentUserID = -100;
                                    CurrentUserName = "null";
                                    exit = true;
                                    System.out.println("---------------------------------------------");
                                    System.out.println("Account deleted successfully!");
                                    System.out.println("---------------------------------------------");
                                } else {
                                    System.out.println("Account not deleted!");
                                }
                            }
                            // Create My Bank Account
                        } else if (menuChoice.equals("3.1")) {
                            Accounts.addAccount(CurrentAccountType, CurrentUserName, CurrentUserID, 0);
                            int temp = Accounts.accountsList.size() - 1;
                            int accountID = Accounts.accountsList.get(temp).getAccountID();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account does not exist! ");
                            } else {
                                System.out.println("---------------------------------------------");
                                Accounts.displayAccountInfo(index);
                                System.out.println("---------------------------------------------");
                            }
                        } else if (menuChoice.equals("3.2")) {
                            float amount;
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                System.out.println("Enter the amount: ");
                                amount = scanner.nextFloat();
                                Accounts acc = Accounts.getAccount(index);
                                acc.setAmount(amount);
                                System.out.println("---------------------------------------------");
                                System.out.println("Amount setted successfully!");
                                System.out.println("---------------------------------------------");

                            } else {
                                System.out.println("You don't have the permission to delete this account!");
                            }
                        }
                        // Delete my Bank Account
                        else if (menuChoice.equals("3.3")) {
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();

                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                Accounts.deleteAccount(index);
                                System.out.println("---------------------------------------------");
                                System.out.println("Bank account deleted successfully!");
                                System.out.println("---------------------------------------------");

                            } else {
                                System.out.println("You don't have the permission to delete this account!");

                            }
                            // Add Transaction
                        } else if (menuChoice.equals("4.1")) {
                            int propertyID;
                            System.out.println("Enter the property ID: ");
                            propertyID = scanner.nextInt();
                            scanner.nextLine();

                            int bankAccountID;
                            System.out.println("Enter your bank account ID: ");
                            bankAccountID = scanner.nextInt();
                            scanner.nextLine();

                            int index = Accounts.searchAccount(bankAccountID);
                            if (index == -1) {
                                System.out.println("The Account ID is not valid!");
                            } else if (Accounts.accountsList.get(index).getClientID() == CurrentUserID &&
                                    CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())) {
                                BuyerSellerTransactions.addTransaction(CurrentUserName, CurrentUserID, propertyID,
                                        bankAccountID);
                                System.out.println("---------------------------------------------");
                                System.out.println("Transaction added successfully!");
                                System.out.println("---------------------------------------------");

                            } else {
                                System.out.println("You do not have the permission to access this account!");
                            }
                            // Delete Transaction
                        } else if (menuChoice.equals("4.2")) {
                            int index, transactionsID;
                            System.out.println("Enter the Transaction ID:");
                            transactionsID = scanner.nextInt();
                            scanner.nextLine();

                            index = BuyerSellerTransactions.searchTransaction(transactionsID);
                            if (index == -1) {
                                System.out.println("The transaction ID does not exists!");
                            } else if (CurrentUserName
                                    .equals(BuyerSellerTransactions.transactionsList.get(index).getClientName())
                                    && CurrentUserID == BuyerSellerTransactions.transactionsList.get(index)
                                            .getClientID()) {

                                BuyerSellerTransactions.deleteTransaction(index);
                                System.out.println("---------------------------------------------");
                                System.out.println("Transaction deleted successfully!");
                                System.out.println("---------------------------------------------");

                            } else {
                                System.out.println("You do not have the permission to access this account!");
                            }
                            // Display all my transactions
                        } else if (menuChoice.equals("4.3")) {
                            BuyerSellerTransactions.showUserTransactions(CurrentUserID);
                        }
                    } else {
                        // Show available properties for rent
                        if (menuChoice.equals("1.1")) {
                            Renters.showProperties();
                            // Search properties using specific criteria
                        } else if (menuChoice.equals("1.2")) {
                            System.out.println("Enter Your choice: ");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if (choice == 1) {
                                String size;
                                System.out.println("Enter the size: ");
                                size = scanner.nextLine();
                                Property.searchProperties(size, choice, CurrentAccountType);
                            } else if (choice == 2) {
                                float price;
                                System.out.println("Enter the price: ");
                                price = scanner.nextFloat();
                                scanner.nextLine();
                                Property.searchProperties(price, CurrentAccountType);
                            } else if (choice == 3) {
                                String location;
                                System.out.println("Enter the location: ");
                                location = scanner.nextLine();
                                Property.searchProperties(location, choice, CurrentAccountType);
                            } else if (choice == 4) {
                                String OwnerName;
                                System.out.println("Enter the Owner Name: ");
                                OwnerName = scanner.nextLine();
                                Property.searchProperties(OwnerName, choice, CurrentAccountType);
                            } else if (choice == 5) {
                                int OwnerID;
                                System.out.println("Enter the Owner ID: ");
                                OwnerID = scanner.nextInt();
                                scanner.nextLine();
                                Property.searchProperties(OwnerID, CurrentAccountType);
                            } else {
                                System.out.println("Invalid input. Please try again!");
                            }
                            // search property using property ID
                        } else if (menuChoice.equals("1.3")) {
                            int propertyID;
                            System.out.println("Enter the property ID: ");
                            propertyID = scanner.nextInt();
                            scanner.nextLine();

                            if (Property.searchProperty(propertyID) == -1) {
                                System.out.println("Property ID is wrong!");
                            }
                            // Edit account information
                        } else if (menuChoice.equals("2.1")) {
                            int renterIndex = Renters.searchRenter(CurrentUserID);

                            if (renterIndex == -1) {
                                System.out.println("Invalid ID. Please try again!");
                            } else {
                                System.out.println("You can edit the following fields: ");
                                System.out.println("1- Change user name");
                                System.out.println("2- Change user last name");
                                System.out.println("3- Change user email");
                                System.out.println("4- Change user phone number");

                                System.out.println("Enter your choice: ");
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Enter the updated version: ");
                                String UpdatedStuff = scanner.nextLine();

                                if (choice >= 1 && choice <= 4) {
                                    Renters.editRenter(renterIndex, UpdatedStuff, choice);
                                } else {
                                    System.out.println("Invalid choice! Please try again later");
                                }
                            }
                            // Display account information
                        } else if (menuChoice.equals("2.2")) {
                            int index = Renters.searchRenter(CurrentUserID);
                            if (index == -1) {
                                System.out.println("The ID that you've entered is wrong! Please try again");
                            } else {
                                Renters.displayRenterInfo(index);
                            }
                            // Delete account
                        } else if (menuChoice.equals("2.3")) {
                            int index = Renters.searchRenter(CurrentUserID);
                            if (index == -1) {
                                System.out.println("Wrong ID");
                            } else {
                                System.out.println("Are you sure you want to delete your account(Y/n)?");
                                char confirmation = scanner.nextLine().charAt(0);
                                if (confirmation == 'Y' || confirmation == 'y') {
                                    Renters.deleteRenter(index);
                                    CurrentAccountType = "null";
                                    CurrentUserID = -100;
                                    CurrentUserName = "null";
                                    exit = true;
                                } else {
                                    System.out.println("Account not deleted!");
                                }
                            }
                            // Create My Bank Account
                        } else if (menuChoice.equals("3.1")) {
                            Accounts.addAccount(CurrentAccountType, CurrentUserName, CurrentUserID, 0);
                            int temp = Accounts.accountsList.size() - 1;
                            int accountID = Accounts.accountsList.get(temp).getAccountID();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account does not exist! ");
                            } else {
                                Accounts.displayAccountInfo(index);
                            }
                        }
                        else if (menuChoice.equals("3.2")) {
                            float amount;
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                System.out.println("Enter the amount: ");
                                amount = scanner.nextFloat();
                                Accounts acc = Accounts.getAccount(index);
                                acc.setAmount(amount);
                            } else {
                                System.out.println("You don't have the permission to delete this account!");
                            }
                        }
                        // Delete my Bank Account
                        else if (menuChoice.equals("3.3")) {
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();

                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                Accounts.deleteAccount(index);
                            } else {
                                System.out.println("You don't have the permission to delete this account!");
                            }
                            // Add Transaction
                        } else if (menuChoice.equals("4.1")) {
                            int propertyID;
                            System.out.println("Enter the property ID: ");
                            propertyID = scanner.nextInt();
                            scanner.nextLine();

                            int bankAccountID;
                            System.out.println("Enter your bank account ID: ");
                            bankAccountID = scanner.nextInt();
                            scanner.nextLine();

                            int index = Accounts.searchAccount(bankAccountID);
                            if (index == -1) {
                                System.out.println("The Account ID is not valid!");
                            } else if (Accounts.accountsList.get(index).getClientID() == CurrentUserID &&
                                    CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())) {
                                RenterLandLordTransactions.addTransaction(CurrentUserName, CurrentUserID, propertyID,
                                        bankAccountID);
                            } else {
                                System.out.println("You do not have the permission to access this account!");
                            }
                            // Delete Transaction
                        } else if (menuChoice.equals("4.2")) {
                            int index, transactionsID;
                            System.out.println("Enter the Transaction ID:");
                            transactionsID = scanner.nextInt();
                            scanner.nextLine();

                            index = RenterLandLordTransactions.searchTransaction(transactionsID);
                            if (index == -1) {
                                System.out.println("The transaction ID does not exists!");
                            } else if (CurrentUserName
                                    .equals(RenterLandLordTransactions.transactionsList.get(index).getClientName())
                                    && CurrentUserID == RenterLandLordTransactions.transactionsList.get(index)
                                            .getClientID()) {

                                RenterLandLordTransactions.deleteTransaction(index);
                            } else {
                                System.out.println("You do not have the permission to access this account!");
                            }
                            // Display all my transactions
                        } else if (menuChoice.equals("4.3")) {
                            RenterLandLordTransactions.showUserTransactions(CurrentUserID);
                        }
                    }
                } else {
                    if (CurrentAccountType.equals("Seller")) {
                        // Add Property
                        if (menuChoice.equals("1.1")) {
                            String size;
                            System.out.println("Enter the size of the property: ");
                            size = scanner.nextLine();

                            float price;
                            System.out.println("Enter the property's price: ");
                            price = scanner.nextFloat();
                            scanner.nextLine();

                            String location;
                            System.out.println("Enter the location: ");
                            location = scanner.nextLine();

                            Property.addProperty("Sell", size, price, location, false, CurrentUserName, CurrentUserID);
                            // Display my properties
                        } else if (menuChoice.equals("1.2")) {
                            Sellers.displaySellerProperties(CurrentUserID);
                            // Edit a specific property information
                        } else if (menuChoice.equals("1.3")) {
                            System.out.println("Enter the property ID: ");
                            int propertyID = scanner.nextInt();
                            scanner.nextLine();

                            int propertyIndex = Property.searchInArray(propertyID);

                            if (propertyIndex == -1) {
                                System.out.println("The property ID is wrong! ");
                            } else if (CurrentUserName.equals(Property.propertiesList.get(propertyIndex).getOwnerName())
                                    && CurrentUserID == Property.propertiesList.get(propertyIndex).getOwnerID()) {
                                System.out.println("You can edit the following fields: ");
                                System.out.println(
                                        "1- Property's type\n2-Property's size\n3-Property's location\n4-Owner Name");
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                if (choice >= 1 && choice <= 4) {
                                    String UpdatedStuff;
                                    System.out.println("Enter the updated version");
                                    UpdatedStuff = scanner.nextLine();

                                    Property.editProperty(UpdatedStuff, choice, propertyIndex);
                                }

                            } else {
                                System.out
                                        .println("You don't have the permission to change this property information!");
                            }
                            // Delete a specific property
                        } else if (menuChoice.equals("1.4")) {
                            int propertyID;
                            System.out.println("Enter the property ID: ");
                            propertyID = scanner.nextInt();
                            scanner.nextLine();

                            int propertyIndex = Property.searchInArray(propertyID);

                            if (propertyIndex == -1) {
                                System.out.println("The property ID is wrong! ");
                            } else if (CurrentUserName.equals(Property.propertiesList.get(propertyIndex).getOwnerName())
                                    && CurrentUserID == Property.propertiesList.get(propertyIndex).getOwnerID()) {
                                Property.deleteProperty(propertyIndex);
                            } else {
                                System.out
                                        .println("You don't have the permission to delete this property information!");
                            }
                            // Edit account information
                        } else if (menuChoice.equals("2.1")) {
                            int sellerIndex = Sellers.searchSeller(CurrentUserID);

                            if (sellerIndex == -1) {
                                System.out.println("Invalid ID. Please try again!");
                            } else {
                                System.out.println("You can edit the following fields: ");
                                System.out.println("1- Change user name");
                                System.out.println("2- Change user last name");
                                System.out.println("3- Change user email");
                                System.out.println("4- Change user phone number");

                                System.out.println("Enter your choice: ");
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Enter the updated version: ");
                                String UpdatedStuff = scanner.nextLine();

                                if (choice >= 1 && choice <= 4) {
                                    Sellers.editSeller(sellerIndex, UpdatedStuff, choice);
                                } else {
                                    System.out.println("Invalid choice! Please try again later");
                                }
                            }
                            // Display account information
                        } else if (menuChoice.equals("2.2")) {
                            int index = Sellers.searchSeller(CurrentUserID);
                            if (index == -1) {
                                System.out.println("The ID that you've entered is wrong! Please try again");
                            } else {
                                Sellers.displaySellerInfo(index);
                            }
                            // Delete account
                        } else if (menuChoice.equals("2.3")) {
                            int index = Renters.searchRenter(CurrentUserID);
                            if (index == -1) {
                                System.out.println("Wrong ID");
                            } else {
                                System.out.println("Are you sure you want to delete your account(Y/n)?");
                                char confirmation = scanner.nextLine().charAt(0);
                                if (confirmation == 'Y' || confirmation == 'y') {
                                    Renters.deleteRenter(index);
                                    CurrentAccountType = "null";
                                    CurrentUserID = -100;
                                    CurrentUserName = "null";
                                    exit = true;
                                } else {
                                    System.out.println("Account not deleted!");
                                }
                            }
                            // Create My Bank Account
                        } else if (menuChoice.equals("3.1")) {
                            Accounts.addAccount(CurrentAccountType, CurrentUserName, CurrentUserID, 0);
                            int temp = Accounts.accountsList.size() - 1;
                            int accountID = Accounts.accountsList.get(temp).getAccountID();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account does not exist! ");
                            } else {
                                Accounts.displayAccountInfo(index);
                            }
                        }
                        else if (menuChoice.equals("3.2")) {
                            float amount;
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                System.out.println("Enter the amount: ");
                                amount = scanner.nextFloat();
                                Accounts acc = Accounts.getAccount(index);
                                acc.setAmount(amount);
                            } else {
                                System.out.println("You don't have the permission to delete this account!");
                            }
                        }
                        // Delete my Bank Account
                        else if (menuChoice.equals("3.2")) {
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();

                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                Accounts.deleteAccount(index);
                            } else {
                                System.out.println("You do not have the permission to delete this account");
                            }
                        }
                        // Accept a specific property request
                        else if (menuChoice.equals("4.1")) {
                            int transactionID;
                            System.out.println("Enter the transaction ID: ");
                            transactionID = scanner.nextInt();
                            scanner.nextLine();

                            int transactionIndex = TransactionsManager.searchTransaction(transactionID);
                            int propertyID = BuyerSellerTransactions.transactionsList.get(transactionIndex)
                                    .getPropertyID();
                            int propertyIndex = Property.searchInArray(propertyID);

                            if (transactionIndex == -1) {
                                System.out.println("The transaction ID is wrong! Try again");

                            } else if (CurrentUserName.equals(Property.propertiesList.get(propertyIndex).getOwnerName())
                                    &&
                                    CurrentUserID == Property.propertiesList.get(propertyIndex).getOwnerID()) {

                                int senderID = BuyerSellerTransactions.transactionsList.get(transactionIndex)
                                        .getClientID();
                                int senderIndex = Accounts.searchAccount(senderID);
                                Accounts senderAccount = Accounts.getAccount(senderIndex);

                                int recipientIndex = Accounts.searchAccount(CurrentUserID);
                                Accounts recipientAccount = Accounts.getAccount(recipientIndex);

                                float price;
                                price = Property.propertiesList.get(propertyIndex).getPrice();

                                Payment.payment(senderAccount, recipientAccount, price);
                                String senderName = Accounts.accountsList.get(senderIndex).getClientName();
                                Contract.generateContract(propertyID, CurrentUserName, CurrentUserID, senderName,
                                        senderID, "Buyer/Seller", price);
                            }
                            // Show Buy Requests
                        } else if (menuChoice.equals("4.2")) {
                            TransactionsManager.showRequests(CurrentAccountType, CurrentUserName, CurrentUserID);
                        }
                    } else {
                        if (menuChoice.equals("1.1")) {
                            String size;
                            System.out.println("Enter the size of the property: ");
                            size = scanner.nextLine();

                            float price;
                            System.out.println("Enter the property's price: ");
                            price = scanner.nextFloat();
                            scanner.nextLine();

                            String location;
                            System.out.println("Enter the location: ");
                            location = scanner.nextLine();

                            Property.addProperty("Rent", size, price, location, false, CurrentUserName, CurrentUserID);
                            // Display my properties
                        } else if (menuChoice.equals("1.2")) {
                            LandLords.displayLandLordrProperties(CurrentUserID);
                            // Edit a specific property information
                        } else if (menuChoice == "1.3") {
                            System.out.println("Enter the property ID: ");
                            int propertyID = scanner.nextInt();
                            scanner.nextLine();

                            int propertyIndex = Property.searchInArray(propertyID);

                            if (propertyIndex == -1) {
                                System.out.println("The property ID is wrong! ");
                            } else if (CurrentUserName.equals(Property.propertiesList.get(propertyIndex).getOwnerName())
                                    && CurrentUserID == Property.propertiesList.get(propertyIndex).getOwnerID()) {
                                System.out.println("You can edit the following fields: ");
                                System.out.println(
                                        "1- Property's type\n2-Property's size\n3-Property's location\n4-Owner Name");
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                if (choice >= 1 && choice <= 4) {
                                    String UpdatedStuff;
                                    System.out.println("Enter the updated version: ");
                                    UpdatedStuff = scanner.nextLine();

                                    Property.editProperty(UpdatedStuff, choice, propertyIndex);
                                }

                            } else {
                                System.out
                                        .println("You don't have the permission to change this property information!");
                            }
                            // Delete a specific property
                        } else if (menuChoice.equals("1.4")) {
                            int propertyID;
                            System.out.println("Enter the property ID: ");
                            propertyID = scanner.nextInt();
                            scanner.nextLine();

                            int propertyIndex = Property.searchInArray(propertyID);

                            if (propertyIndex == -1) {
                                System.out.println("The property ID is wrong! ");
                            } else if (CurrentUserName.equals(Property.propertiesList.get(propertyIndex).getOwnerName())
                                    && CurrentUserID == Property.propertiesList.get(propertyIndex).getOwnerID()) {
                                Property.deleteProperty(propertyIndex);
                            } else {
                                System.out
                                        .println("You don't have the permission to delete this property information!");
                            }
                            // Edit account information
                        } else if (menuChoice.equals("2.1")) {
                            int LandLordIndex = LandLords.searchLandLord(CurrentUserID);

                            if (LandLordIndex == -1) {
                                System.out.println("Invalid ID. Please try again!");
                            } else {
                                System.out.println("You can edit the following fields: ");
                                System.out.println("1- Change user name");
                                System.out.println("2- Change user last name");
                                System.out.println("3- Change user email");
                                System.out.println("4- Change user phone number");

                                System.out.println("Enter your choice: ");
                                choice = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Enter the updated version: ");
                                String UpdatedStuff = scanner.nextLine();

                                if (choice >= 1 && choice <= 4) {
                                    LandLords.editLandLord(LandLordIndex, UpdatedStuff, choice);
                                } else {
                                    System.out.println("Invalid choice! Please try again later");
                                }
                            }
                            // Display account information
                        } else if (menuChoice.equals("2.2")) {
                            int index = LandLords.searchLandLord(CurrentUserID);
                            if (index == -1) {
                                System.out.println("The ID that you've entered is wrong! Please try again");
                            } else {
                                LandLords.displayLandLordInfo(index);
                            }
                            // Delete account
                        } else if (menuChoice.equals("2.3")) {
                            int index = Renters.searchRenter(CurrentUserID);
                            if (index == -1) {
                                System.out.println("Wrong ID");
                            } else {
                                System.out.println("Are you sure you want to delete your account(Y/n)?");
                                char confirmation = scanner.nextLine().charAt(0);
                                if (confirmation == 'Y' || confirmation == 'y') {
                                    Renters.deleteRenter(index);
                                    CurrentAccountType = "null";
                                    CurrentUserID = -100;
                                    CurrentUserName = "null";
                                    exit = true;
                                } else {
                                    System.out.println("Account not deleted!");
                                }
                            }
                            // Create My Bank Account
                        } else if (menuChoice.equals("3.1")) {
                            Accounts.addAccount(CurrentAccountType, CurrentUserName, CurrentUserID, 0);
                            int temp = Accounts.accountsList.size() - 1;
                            int accountID = Accounts.accountsList.get(temp).getAccountID();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account does not exist! ");
                            } else {
                                Accounts.displayAccountInfo(index);
                            }
                        }
                        else if (menuChoice.equals("3.2")) {
                            float amount;
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();
                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                System.out.println("Enter the amount: ");
                                amount = scanner.nextFloat();
                                Accounts acc = Accounts.getAccount(index);
                                acc.setAmount(amount);
                            } else {
                                System.out.println("You don't have the permission to delete this account!");
                            }
                        }
                        // Delete my Bank Account
                        else if (menuChoice.equals("3.2")) {
                            int accountID;
                            System.out.println("Enter the account ID: ");
                            accountID = scanner.nextInt();
                            scanner.nextLine();

                            int index = Accounts.searchAccount(accountID);
                            if (index == -1) {
                                System.out.println("The Account ID does not exist! ");
                            } else if (CurrentUserName.equals(Accounts.accountsList.get(index).getClientName())
                                    && CurrentUserID == Accounts.accountsList.get(index).getClientID()) {
                                Accounts.deleteAccount(index);
                            } else {
                                System.out.println("You do not have the permission to delete this account");
                            }
                        }
                        // Accept a specific property request
                        else if (menuChoice.equals("4.1")) {
                            int transactionID;
                            System.out.println("Enter the transaction ID: ");
                            transactionID = scanner.nextInt();
                            scanner.nextLine();

                            int transactionIndex = TransactionsManager.searchTransaction(transactionID);
                            int propertyID = RenterLandLordTransactions.transactionsList.get(transactionIndex)
                                    .getPropertyID();
                            int propertyIndex = Property.searchInArray(propertyID);

                            if (transactionIndex == -1) {
                                System.out.println("The transaction ID is wrong! Try again");

                            } else if (CurrentUserName.equals(Property.propertiesList.get(propertyIndex).getOwnerName())
                                    &&
                                    CurrentUserID == Property.propertiesList.get(propertyIndex).getOwnerID()) {

                                int senderID = RenterLandLordTransactions.transactionsList.get(transactionIndex)
                                        .getClientID();
                                int senderIndex = Accounts.searchAccount(senderID);
                                Accounts senderAccount = Accounts.getAccount(senderIndex);

                                int recipientIndex = Accounts.searchAccount(CurrentUserID);
                                Accounts recipientAccount = Accounts.getAccount(recipientIndex);

                                float price;
                                price = Property.propertiesList.get(propertyIndex).getPrice();

                                Payment.payment(senderAccount, recipientAccount, price);
                                String senderName = Accounts.accountsList.get(senderIndex).getClientName();
                                Contract.generateContract(propertyID, CurrentUserName, CurrentUserID, senderName,
                                        senderID, "Renter/Land Lord", price);
                            }
                            // Show Buy Requests
                        } else if (menuChoice.equals("4.2")) {
                            TransactionsManager.showRequests(CurrentAccountType, CurrentUserName, CurrentUserID);
                        }
                    }
                }
            } while (exit == false);
        } while (!menuChoice.equals("5"));

        scanner.close();
    }
}
