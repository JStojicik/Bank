import java.util.Random;
import java.util.regex.Pattern;

public enum CardType {
    UNKNOWN,
    VISA("^4[0-9]{12}(?:[0-9]{3}){0,2}$"),
    MASTERCARD("^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$");

    private Pattern pattern;

    CardType() {
        this.pattern = null;
    }

    CardType(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public static CardType detect(String cardNumber) {

        for (CardType cardType : CardType.values()) {
            if (null == cardType.pattern) continue;
            if (cardType.pattern.matcher(cardNumber).matches()) return cardType;
        }

        return UNKNOWN;
    }

    public static Card createCard(CardType cardType) {
        StringBuilder generatedCardNumber = new StringBuilder(16);
        switch (cardType) {
            case VISA:
                generatedCardNumber.append(40);
                break;
            case MASTERCARD:
                generatedCardNumber.append(51);
                break;
        }
        Random rand = new Random();
        for (int i = 0; i < 14; i++) {
            int num = rand.nextInt(9);
            generatedCardNumber.append(num);
        }

        return new Card(cardType, generatedCardNumber.toString());
    }

}
