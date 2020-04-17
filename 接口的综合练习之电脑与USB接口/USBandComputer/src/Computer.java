public class Computer {
    public void turnon(){
        System.out.println("Turn on the computer");
    }
    public void turnoff(){
        System.out.println("Turn off the computer");
    }
    public void use(USB usb){
        usb.open();
        usb.close();
    }
}
