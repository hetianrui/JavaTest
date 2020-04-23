public class GreenState extends AccountState {
    public GreenState(){}
    public GreenState(AccountState state){
        state.stateCheck();
    }
    @Override
    public void stateCheck() {
        System.out.println("当前用户状态为：GreenState");
    }
}
