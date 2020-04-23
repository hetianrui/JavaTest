public class YellowState extends AccountState {
    public YellowState(){
        stateCheck();
    }
    @Override
    public void stateCheck() {
        System.out.println("当前用户状态为：YellowState");
    }
}
