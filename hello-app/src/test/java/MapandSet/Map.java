package MapandSet;


import javax.xml.soap.Node;
import java.util.Set;

public class Map {
    public static void main(String[] args) {
        String s = "900 google.mail.com";
        String[] t = s.split(" ");
        System.out.println(t[0]);
        System.out.println(t[1]);

        int n = Integer.valueOf(t[0]);

        String[] u = t[1].split("\\.");
        System.out.println(u[0]);
        System.out.println(u[1]);
        System.out.println(u[2]);

        String[] v = {"google", "com"};
        String w = String.join(".", v);
        System.out.println(w);
    }
}
    /*public int getOrDefault(int key,int defaultValue){
        Map<
    }
    public static class Entry{
        int key;
        int value;
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
    public Set<Entry> entrySet(){
        if(
    }
}*/
