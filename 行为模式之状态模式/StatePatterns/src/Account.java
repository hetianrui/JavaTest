public class Account {
    AccountState state;
    String owner;
    double balance;
    public Account(String owner,double init){
        this.owner=owner;
        balance=init;
        System.out.println("户主："+owner+" "+"初始金额为："+init);
        System.out.println("----------------------------------");
        setState(new GreenState());
    }
    public void setState(AccountState state){
        this.state=state;
    }
    public void deposit(double amount){
        System.out.println(this.owner+"存款为："+amount);
        balance+=amount;
        state.deposit(balance);
    }
    public void withdraw(double amount) {
        if (balance < (-1000)) {
            new RedState().withdraw(balance);
            System.out.println("现在余额为：" + balance);
        } else {
            System.out.println(this.owner + "取款为：" + amount);
            balance -= amount;
            state.withdraw(balance);
        }
    }
    public static void main(String[] args) {
        Account account=new Account("段誉",5);
        account.deposit(100);
        System.out.println("----------------------------------");
        account.withdraw(200);
        System.out.println("----------------------------------");
        account.deposit(1000);
        System.out.println("----------------------------------");
        account.withdraw(2000);
        System.out.println("----------------------------------");
        account.withdraw(100);
    }
}
