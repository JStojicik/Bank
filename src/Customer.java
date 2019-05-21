public class Customer extends Account {
    private String NameSurname;
    private String customerType;

    public Customer() {
    }

    public Customer(int accountId, String currency, String nameSurname, String customerType) {
        super(accountId, currency);
        this.NameSurname = nameSurname;
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return
                          "Name&Surname: " + NameSurname
                        + "| accountId: " + getAccountId()
                        + "| Currency: " + getCurrency()
                        + "| customerType: " + customerType ;
    }

    public String getNameSurname() {
        return NameSurname;
    }

    public void setNameSurname(String nameSurname) {
        NameSurname = nameSurname;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
