public class Account {
    private String username;
    private String password;
    private String IBAN;
    private double balance;
    private double krediBorcu;
    public Account(String username, String password, int balance, double krediBorcu, String IBAN) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.krediBorcu = krediBorcu;
        this.IBAN = IBAN;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getIBAN() {
        return IBAN;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void setKrediBorcu(double krediBorcu) {
        this.krediBorcu = krediBorcu;
    }
    public double getKrediBorcu() {
        return krediBorcu;
    }




}
