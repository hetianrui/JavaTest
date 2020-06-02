package view;

import Custom.Customer;
import list.CusList;

import java.util.Scanner;

public class CusView {
    public static void main(String[] args) {
        while (true) {
            System.out.println("*********客户管理系统*********");
            System.out.println("******1、查看所有客户信息******");
            System.out.println("******2、添加客户******");
            System.out.println("******3、修改客户******");
            System.out.println("******4、删除客户******");
            System.out.println("******5、退出   ******");
            System.out.println("****************************");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    CusList.SearchCus();
                    break;
                case 2:
                    CusList.addCus();
                    break;
                case 3:
                    CusList.alterCus();
                    break;
                case 4:
                    CusList.deleteCus();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("亲，请看清数字再输入好吗");

            }
        }
    }
}
