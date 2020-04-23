

public abstract class AccountState {

    public abstract void stateCheck();
    public void check(double amount){
        if (amount < 0 && amount >= (-1000)) {
            new YellowState();

        }
        if (amount >= 0) {
            new GreenState(this);

        }
        if (amount < -1000) {
            new RedState();

        }

    }
    public  void deposit(double amount){
        System.out.println("余额为："+amount);
        check(amount);

    }
    public void withdraw(double amount){
        System.out.println("余额为："+amount);
        check(amount);
    }

}
