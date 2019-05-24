import java.util.ArrayList;
import java.util.Random;

public class BankProfile {

    private Account account;
    private Card card;
    private final Customer customer;

    public BankProfile(Account account, Card card, Customer customer) {
        this.account = account;
        this.card = card;
        this.customer = customer;
    }

    public BankProfile(Account account, Customer customer) {
        this.account = account;
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public static Account createAccount(CurrencyType currencyType, ArrayList<BankProfile> bankProfileArrayList) {
        Random ran = new Random();
        int accountId = ran.nextInt(900000000) + 100000000;
        while (doesAccountIdExist(accountId, bankProfileArrayList)) {
            accountId = ran.nextInt(900000000) + 100000000;
        }

        return new Account(accountId, currencyType);
    }

    private static boolean doesAccountIdExist(int accountId, ArrayList<BankProfile> bankProfileArrayList) {
        for (BankProfile bankProfile : bankProfileArrayList) {
            if (bankProfile.getAccount().getAccountId() == accountId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankProfile{" +
                "account=" + account +
                ", card=" + card +
                ", customer=" + customer +
                '}';
    }
}
