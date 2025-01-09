package src.transactions;
import src.bankAccount.Accounts;

public class Payment {
    public static void payment(Accounts senderAccount, Accounts recipientAccount, float amount) {
        float temp = senderAccount.getAmount();
        senderAccount.setAmount(temp - amount);
        temp = recipientAccount.getAmount();
        recipientAccount.setAmount(temp + amount);
    }
}
