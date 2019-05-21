import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Account> accountList = new ArrayList<>();
        ArrayList<Account> cardList = new ArrayList<>();
        Account account = new Account();
        Cards card = new Cards();
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Choose your option\n" +
                    "1)List all accounts\n" +
                    "2)List all cards\n" +
                    "3)Add account\n" +
                    "4)Create an ATM card for an existing account\n" +
                    "5)Search by Account ID \n" +
                    "6)Deposit currency\n" +
                    "7)Withdraw Currency\n" +
                    "8)Change Currency\n" +
                    "9)Exit");
            num = Integer.parseInt(sc.nextLine());
            switch (num) {
                case 1:
                    account.printAccountList(accountList);
                    break;
                case 2:
                    card.printCardList(cardList);
                    break;
                case 3:
                    account.addaccount(accountList);
                    break;
                case 4:
                    card.createCard(cardList, accountList);
                    break;
                case 5:
                    account.searchAccount(accountList);
                    break;
                case 6:
                    account.Deposit(accountList);
                    break;
                case 7:
                    account.Withdraw(accountList);
                    break;
                case 8:
                    account.convertBalance(accountList);
                    break;
                case 9:
                    System.out.println("Thank you for using our application");
                    break;
            }
//
        }
        while (num != 9);
    }
}
