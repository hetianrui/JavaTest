package TestCode;

public class Coo {
    public String toLowerCase(String str) {
        char ch[]=str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]>=65&&ch[i]<=90){
                ch[i]+=32;
            }
        }
        StringBuilder a=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            a.append(ch[i]);
        }
        return a.toString();
    }

}
