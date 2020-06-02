package Cus;

import java.util.Scanner;

public class Util {
    public static String NameCheck(String name) {

        while (true) {
            if (name.length() > 3) {
                System.out.println("最多三个字符，请重输");
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
            }
            if (name.length() <= 3) {
                break;
            }

        }
        return name;
    }
}
