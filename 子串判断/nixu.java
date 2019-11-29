package TestCode;



public class nixu {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean a[]=new boolean[n];
        for(int i=0;i<n;i++){
            a[i]=s.contains(p[i]);
        }
        return a;
    }

    public static void main(String[] args) {
            String s[]={"123","456","3"};
            String s1="1234";
           boolean a[]=chkSubStr(s,3,s1);
           for(int i=0;i<s.length;i++){
               System.out.println(a[i]);
           }

    }
}