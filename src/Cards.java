import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cards extends Customer implements Interface {
    private int cardNumber;
    private boolean creditCard;

    public Cards() {
    }

    public Cards(int accountId, String currency, String nameSurname, String customerType, int cardNumber, boolean creditCard) {
        super(accountId, currency, nameSurname, customerType);
        this.cardNumber = cardNumber;
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return
                "Name&Surname: " + getNameSurname()
                        + "| accountId: " + getAccountId()
                        + "| Currency: " + getCurrency()
                        + "| Credit Card: "+isCreditCard()+"| Credit card no.: "+getCardNumber();
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isCreditCard() {
        return creditCard;
    }

    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }

    public void createCard(ArrayList<Account> cardList, ArrayList<Account> accountList) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int num, accNo;
        boolean type;
        System.out.println("Enter account number");
        accNo = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accountList.size(); i++) {
            if (accNo == accountList.get(i).getAccountId()) {
                if (accountList.get(i).getCurrentBallance() > 10000) {
                    type = true;
                } else {
                    type = false;
                }
                num = rand.nextInt(900000000) + 100000000;
                Account card1 = new Cards(accountList.get(i).getAccountId(), accountList.get(i).getCurrency(), accountList.get(i).getNameSurname(), accountList.get(i).getCustomerType(), num, type);
                cardList.add(card1);
                System.out.println("You have created a card with for this account" + cardList.get(cardList.size() - 1));

            }

        }

    }

    public void printCardList(ArrayList<Account> cardList) {
        for (int i = 0; i < cardList.size(); i++) {
            System.out.println(cardList.get(i));
        }
    }

    @Override
    public String cardType(String cardNumber) {
        return null;
    }
}
