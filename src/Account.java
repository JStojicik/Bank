public class Account {
    private final int accountId;
    private CurrencyType currencyType;
    private double currentBalance = 0.0;

    public Account(int accountId, CurrencyType currencyType) {
        this.accountId = accountId;
        this.currencyType = currencyType;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void deposit(double currentBalance) {
        this.currentBalance += currentBalance;
    }

    public boolean withdraw(double currentBalance) {
        if (this.currentBalance < currentBalance) {
            return false;
        }
        this.currentBalance -= currentBalance;
        return true;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        if (this.currencyType != currencyType) {
            switch (currencyType) {
                case DOLLARS:
                    if (this.currencyType == CurrencyType.DENARS) {
                        currentBalance = currentBalance / 55.54;
                    } else if (this.currencyType == CurrencyType.EUROS) {
                        currentBalance = currentBalance * 0.9;
                    }
                    break;
                case DENARS:
                    if (this.currencyType == CurrencyType.DOLLARS) {
                        currentBalance = currentBalance * 55.54;
                    } else if (this.currencyType == CurrencyType.EUROS) {
                        currentBalance = currentBalance * 61.5;
                    }
                    break;
                case EUROS:
                    if (this.currencyType == CurrencyType.DENARS) {
                        currentBalance = currentBalance / 61.5;
                    } else if (this.currencyType == CurrencyType.DOLLARS) {
                        currentBalance = currentBalance / 0.9;
                    }
                    break;
            }
            this.currencyType = currencyType;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", currencyType='" + currencyType + '\'' +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
