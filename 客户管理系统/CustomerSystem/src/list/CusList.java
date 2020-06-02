package list;

import Cus.Util;
import Custom.Customer;

import java.util.Scanner;

public class CusList {
    Customer cusList[];
    int total;

    public void add(Customer customer) {
        cusList[total++] = customer;
    }

    public CusList() {
        cusList = new Customer[10];
    }

    static CusList list = new CusList();

    public static void addCus() {

        if (list.total >= list.cusList.length) {
            System.out.println("客户满了，无法添加");
            return;
        }
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);

        customer.setId(list.total);
        System.out.println("请输入客户姓名：");
        customer.setName(Util.NameCheck(scanner.nextLine()));

        System.out.println("请输入客户年龄：");
        customer.setAge(scanner.nextInt());

        list.add(customer);
        System.out.println("添加成功");
    }

    public static void alterCus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要修改的客户编号");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("是否修改姓名（Y/N）：");
        String alter = scanner.nextLine();
        if (alter.equals("Y")) {
            System.out.println("修改姓名：");
            String str = Util.NameCheck(scanner.nextLine());
            list.cusList[a].setName(str);
        }
        System.out.println("修改年龄：");
        int age = scanner.nextInt();

        list.cusList[a].setAge(age);
        System.out.println("修改成功");

    }

    public static void deleteCus() {
        if (list.total == 0) {
            System.out.println("没有客户，无法删除");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("要删除的客户编号：");
        int a = scanner.nextInt();
        if (a < 0 || a > list.total) {
            System.out.println("没有此客户，无法删除");
            return;
        }
        if (list.total == 1) {
            list.cusList[0] = null;
        } else {
            for (int i = a; i < list.total - 1; i++) {
                list.cusList[i].setName(list.cusList[i + 1].getName());
                list.cusList[i].setAge(list.cusList[i + 1].getAge());
            }
            list.cusList[list.total - 1] = null;
            list.total--;
        }
        System.out.println("删除成功");
    }

    public static void SearchCus(Customer customer) {
    }

    public static void SearchCus() {
        System.out.println("编号" + "\t\t" + "姓名" + "\t\t" + "年龄");
        for (int i = 0; i < list.total; i++) {
            System.out.println(list.cusList[i]);
        }
    }
}
