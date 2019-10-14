package Library;

import java.util.Scanner;

public class User {
    public static User login(){
        Scanner a =new Scanner(System.in);
        System.out.println("请输入用户名：");
        String id= a.nextLine();
        System.out.println("请输入姓名");
        String name=a.nextLine();
            System.out.println("请选择你的角色");
            System.out.println("1.老师");
            System.out.println("2.学生");
            int character=a.nextInt();
            switch (character){
            case 1:
                return new Teacher();
                break;
            case 2:
                return new Student();
                break;
                default:
        }
    }
}
