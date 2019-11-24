package TestCode;


import java.util.*;

public class TheSamllestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String str1[] = str.split(" ");
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < str1.length; i++) {
                map.put(i, str1[i]);
            }

            if (Integer.parseInt(map.get(0)) == 0) {
                for (Map.Entry<Integer, String> e : map.entrySet()) {
                    Integer n = e.getKey();
                    String a = e.getValue();
                    for (int i = 0; i < Integer.parseInt(String.valueOf(a)); i++) {
                        System.out.print(n);
                    }


                }

            } else {
                int count = 0;
                for (int i = 1; i < map.size() - 1; i++) {
                    int c = Integer.parseInt(map.get(i));
                    if (Integer.parseInt(map.get(i)) > 0) {
                        map.put(i, String.valueOf(c - 1));
                        count = i;
                        break;

                    }
                }

                System.out.print(count);
                for (Map.Entry<Integer, String> e : map.entrySet()) {
                    Integer n1 = e.getKey();
                    String a = e.getValue();
                    for (int i = 0; i < Integer.parseInt(String.valueOf(a)); i++) {
                         System.out.print(n1);
                    }

                }


            }
        }
    }
}
