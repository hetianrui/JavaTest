public class RedState extends AccountState {
    @Override
    public void stateCheck() {
        System.out.println("当前用户状态为：RedState");
    }
    public RedState(){
       stateCheck();
    }
    public void withdraw(double amount){
        System.out.println("账户被冻结，取款失败");

    }
}
