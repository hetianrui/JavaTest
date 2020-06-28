
public class StaticReplace {
    public static void main(String[] args) {
        Fac fac=new Pro(new Nike());
        fac.work();
    }
}
interface Fac{
    void work();
}
class Pro implements Fac{
    Fac like;
    public Pro(Fac fac){
        this.like=fac;
    }
    @Override
    public void work() {
        System.out.println("代理模式开始...");
        like.work();

    }
}
class Nike implements Fac{
    @Override
    public void work() {
        System.out.println("生产Nike.");
    }
}