import java.util.Random;

public class Card {
    private final String cardNumber;
    private final CardType cardType;

    public Card(CardType cardType, String cardNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public boolean isCreditCard(double currentBalance) {
        return currentBalance > 10000;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardType=" + cardType +
                '}';
    }
}
