public class CheckingAccount extends BankAccount {
    private double fee = 0.15;

    public CheckingAccount(String name, double amount) {
        super(name, amount);
        super.setAccountNumber(getAccountNumber() + "-10");
    }

    public boolean withdraw(double amount) {
        return super.withdraw(amount + fee);
    }

}