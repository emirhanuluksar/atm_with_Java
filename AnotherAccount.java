public class AnotherAccount{
    private String IBAN;
    private String firstname;
    private String lastname;
    private double balance;

    public AnotherAccount(String IBAN, String firstname, String lastname, double balance) {
        this.IBAN = IBAN;
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
    }

    public String getIBAN() {
        return IBAN;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }


}
