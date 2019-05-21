import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account {
    private int accountId;
    private String currency;
    private double currentBalance = 0.0;

    public Account() {
    }

    public Account(int accountId, String currency) {
        this.accountId = accountId;
        this.currency = currency;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return
                "Account number:" + getAccountId() + " Currency: " + getCurrency() + " Current balance: " + getCurrentBallance();

    }

    public String getNameSurname() {
        return getNameSurname();
    }

    public String getCustomerType() {
        return getCustomerType();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCurrentBallance() {
        return currentBalance;
    }

    public void setCurrentBallance() {
        this.currentBalance = 0.0;
    }

    public void Deposit(ArrayList<Account> accountList) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an account number to deposit currency");
        num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accountList.size(); i++) {
            if (num == accountList.get(i).getAccountId()) {
                System.out.println("Here is the account" + accountList.get(i));
                System.out.println("The current balance is" + accountList.get(i).getCurrentBallance());
                System.out.println("Enter the amount you want to deposit");
                int cash = Integer.parseInt(sc.nextLine());
                accountList.get(i).currentBalance += cash;
                System.out.println("Your balance after depositing money is " + accountList.get(i).getCurrentBallance());
            } else {
                System.out.println("Account does not exist");
            }
        }
    }

    public void Withdraw(ArrayList<Account> accountList) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an account number to withdraw currency");
        num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accountList.size(); i++) {
            if (num == accountList.get(i).getAccountId()) {
                System.out.println("Here is the account" + accountList.get(i));
                System.out.println("The current balance is " + accountList.get(i).getCurrentBallance());
                System.out.println("Enter the amount you want to withdraw");
                int cash = Integer.parseInt(sc.nextLine());
                if (cash < accountList.get(i).getCurrentBallance()) {
                    accountList.get(i).currentBalance -= cash;
                    System.out.println("your ballance after withdrawing is " + accountList.get(i).getCurrentBallance());
                } else {
                    System.out.println("You do not have enough currency in your account");
                }

            } else {
                System.out.println("Account does not exist");
            }
        }
    }

    public void printAccountList(ArrayList<Account> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println(accountList.get(i));
        }
    }

    public void convertBalance(ArrayList<Account> accountList) {
        Scanner sc = new Scanner(System.in);
        int num;
        String currency;
        System.out.println("Enter an account number to find the account");
        num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accountList.size(); i++) {
            if (num == accountList.get(i).getAccountId()) {
                System.out.println("enter the currency you want to change to(Euro, Dollar or Denar)");
                currency = sc.nextLine();
                if (accountList.get(i).getCurrency() == "Dollar" && currency == "Dollar") {
                    System.out.println("You are allready using " + accountList.get(i).getCurrency());
                } else if (accountList.get(i).getCurrency() == "Dollar" && currency == "Euro") {
                    accountList.get(i).currentBalance *= 0.9;
                    accountList.get(i).setCurrency(currency);
                    System.out.println("your new balance is: " + accountList.get(i).getCurrentBallance() + " in " + accountList.get(i).getCurrency());
                } else if (accountList.get(i).getCurrency() == "Dollar" && currency == "Denar") {
                    accountList.get(i).currentBalance *= 55.15;
                    accountList.get(i).setCurrency(currency);
                    System.out.println("your new balance is: " + accountList.get(i).getCurrentBallance() + " in " + accountList.get(i).getCurrency());

                } else if (accountList.get(i).getCurrency() == "Euro" && currency == "Dollar") {
                    accountList.get(i).currentBalance /= 0.9;
                    accountList.get(i).setCurrency(currency);
                    System.out.println("your new balance is: " + accountList.get(i).getCurrentBallance() + " in " + accountList.get(i).getCurrency());
                } else if (accountList.get(i).getCurrency() == "Euro" && currency == "Denar") {
                    accountList.get(i).currentBalance *= 61.54;
                    accountList.get(i).setCurrency(currency);
                    System.out.println("your new balance is: " + accountList.get(i).getCurrentBallance() + " in " + accountList.get(i).getCurrency());

                } else if (accountList.get(i).getCurrency() == "Euro" && currency == "Euro") {
                    System.out.println("You are allready using " + accountList.get(i).getCurrency());
                } else if (accountList.get(i).getCurrency() == "Denar" && currency == "Dollar") {
                    accountList.get(i).currentBalance /= 55.15;
                    accountList.get(i).setCurrency(currency);
                    System.out.println("your new balance is: " + accountList.get(i).getCurrentBallance() + " in " + accountList.get(i).getCurrency());

                } else if (accountList.get(i).getCurrency() == "Denar" && currency == "Euro") {
                    accountList.get(i).currentBalance /= 55.15;
                    accountList.get(i).setCurrency(currency);
                    System.out.println("your new balance is: " + accountList.get(i).getCurrentBallance() + " in " + accountList.get(i).getCurrency());

                } else if (accountList.get(i).getCurrency() == "Denar" && currency == "Denar") {
                    System.out.println("You are allready using " + accountList.get(i).getCurrency());
                }
            }
        }

    }

    public void addaccount(ArrayList<Account> accountList) {
        String nameSurname, currency, type;
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name and surname");
        nameSurname = sc.nextLine();
        System.out.println("Enter the Currency you will be using");
        currency = sc.nextLine();
        System.out.println("Enter your membership type");
        type = sc.nextLine();
        Random rand = new Random();
        num = rand.nextInt(9000000) + 1000000;
        Account customer1 = new Customer(num, currency, nameSurname, type);
        accountList.add(customer1);
        System.out.println("You have created an account with " + accountList.get(accountList.size() - 1));
    }

    public void searchAccount(ArrayList<Account> accountList) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter an account number to find the account");
        num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accountList.size(); i++) {
            if (num == accountList.get(i).getAccountId()) {
                System.out.println("Here is the account " + accountList.get(i));
            }
        }
    }
}
