import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<BankProfile> bankProfileList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Choose your option\n" +
                    "1)List all bank profiles\n" +
                    "2)Add account\n" +
                    "3)Create an ATM card for an existing account\n" +
                    "4)Check balance \n" +
                    "5)Deposit currency\n" +
                    "6)Withdraw Currency\n" +
                    "7)Change Currency\n" +
                    "8)Exit");
            num = Integer.parseInt(sc.nextLine());
            switch (num) {
                case 1:
                    printAccountList(bankProfileList);
                    break;
                case 2:
                    Account account = addaccount(bankProfileList);
                    Card card = createCard();
                    Customer customer = createCustomer();
                    if (card == null) {
                        bankProfileList.add(new BankProfile(account, customer));
                    } else {
                        bankProfileList.add(new BankProfile(account, card, customer));
                    }
                    break;
                case 3:
                    setCard(bankProfileList);
                    break;
                case 4:
                    checkBalance(bankProfileList);
                    break;
                case 5:
                    deposit(bankProfileList);
                    break;
                case 6:
                    withdraw(bankProfileList);
                    break;
                case 7:
                    changeValue(bankProfileList);
                    break;
                case 8:
                    System.out.println("Thank you for using our application");
                    break;
            }
//
        }
        while (num != 9);
    }

    private static BankProfile findProfile(ArrayList<BankProfile> bankProfileArrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account id:");
        int accountId = Integer.parseInt(sc.nextLine());
        for (BankProfile bankProfile : bankProfileArrayList) {
            if (bankProfile.getAccount().getAccountId() == accountId) {
                return bankProfile;
            }
        }
        System.out.println("Account with that ID does not exist.");
        return null;
    }

    private static void changeValue(ArrayList<BankProfile> bankProfileArrayList) {
        BankProfile bankProfile = findProfile(bankProfileArrayList);
        if (bankProfile != null) {
            CurrencyType currencyType = bankProfile.getAccount().getCurrencyType();
            System.out.println("Your balance is in " + currencyType);
            switch (currencyType) {
                case EUROS:
                    bankProfile.getAccount().setCurrencyType(changeCurrencyType(CurrencyType.EUROS, CurrencyType.DENARS, CurrencyType.DOLLARS));
                    break;
                case DENARS:
                    bankProfile.getAccount().setCurrencyType(changeCurrencyType(CurrencyType.DENARS, CurrencyType.EUROS, CurrencyType.DOLLARS));
                    break;
                case DOLLARS:
                    bankProfile.getAccount().setCurrencyType(changeCurrencyType(CurrencyType.DOLLARS, CurrencyType.DENARS, CurrencyType.EUROS));
                    break;
            }
        }
    }

    private static CurrencyType changeCurrencyType(CurrencyType currencyType, CurrencyType firstCurrencyType, CurrencyType secondCurrencyType) {
        System.out.println("Choose between 1. " + firstCurrencyType + ", 2. " + secondCurrencyType);
        Scanner sc = new Scanner(System.in);
        int newCurrencyType = Integer.parseInt(sc.nextLine());
        switch (newCurrencyType) {
            case 1:
                return firstCurrencyType;
            case 2:
                return secondCurrencyType;
        }
        System.out.println("You are already using this currency.");
        return currencyType;
    }

    private static void deposit(ArrayList<BankProfile> bankProfileArrayList) {
        BankProfile bankProfile = findProfile(bankProfileArrayList);
        if (bankProfile != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount you want to deposit:");
            int num = Integer.parseInt(sc.nextLine());
            bankProfile.getAccount().deposit(num);
        }
    }

    private static void withdraw(ArrayList<BankProfile> bankProfileArrayList) {
        BankProfile bankProfile = findProfile(bankProfileArrayList);
        if (bankProfile != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount you want to withdraw:");
            int num = Integer.parseInt(sc.nextLine());
            boolean succ = bankProfile.getAccount().withdraw(num);
            System.out.println(succ ? "Withdraw successful. Your balance after withdrawing is " + bankProfile.getAccount().getCurrentBalance() : " Withdraw unsuccessful.");
        }
    }

    private static void checkBalance(ArrayList<BankProfile> bankProfileArrayList) {
        BankProfile bankProfile = findProfile(bankProfileArrayList);
        if (bankProfile != null) {
            System.out.println("Your current balance is: " + bankProfile.getAccount().getCurrentBalance());
        }
    }

    private static void setCard(ArrayList<BankProfile> bankProfileArrayList) {
        BankProfile bankProfile = findProfile(bankProfileArrayList);

        if (bankProfile != null) {
            Card card = createCard();
            bankProfile.setCard(card);
            System.out.println("Created card with " + card.toString());
        }
    }

    public static void printAccountList(ArrayList<BankProfile> bankProfileArrayList) {
        for (BankProfile bankProfile : bankProfileArrayList) {
            System.out.println(bankProfile.toString());
            if (bankProfile.getCard() != null) {
                System.out.println(bankProfile.toString() + " is credit card: " + bankProfile.getCard().isCreditCard(bankProfile.getAccount().getCurrentBalance()));
            }
        }
    }

    public static Account addaccount(ArrayList<BankProfile> accountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choose your currency (1. Dollars 2. Euros 3. Denars):");
        int num = Integer.parseInt(sc.nextLine());
        switch (num) {
            case 1:
                return BankProfile.createAccount(CurrencyType.DOLLARS, accountList);
            case 2:
                return BankProfile.createAccount(CurrencyType.EUROS, accountList);
            case 3:
                return BankProfile.createAccount(CurrencyType.DENARS, accountList);
            default:
                return null;
        }
    }

    public static Card createCard() {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Do you want a card ( 1. Yes, 2. No:");
        num = Integer.parseInt(sc.nextLine());
        if (num == 1) {
            System.out.println("Choose card type ( 1. Visa, 2. MasterCard");
            num = Integer.parseInt(sc.nextLine());
            switch (num) {
                case 1:
                    return CardType.createCard(CardType.VISA);
                case 2:
                    return CardType.createCard(CardType.MASTERCARD);
                default:
                    return null;
            }
        } else {
            // dont create
            return null;
        }
    }

    private static Customer createCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter surname: ");
        String surname = sc.nextLine();
        System.out.println("Enter customer type (1. ORDINARY 2. EMPLOYEE 3.VIP ): ");
        int type = Integer.parseInt(sc.nextLine());
        switch (type) {
            case 1:
                return new Customer(name, surname, CustomerType.ORDINARY);
            case 2:
                return new Customer(name, surname, CustomerType.EMPLOYEE);
            case 3:
                return new Customer(name, surname, CustomerType.VIP);
        }
        return null;
    }
}
