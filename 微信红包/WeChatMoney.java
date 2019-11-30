package TestCode;

import java.util.HashMap;
import java.util.Map;

public class WeChatMoney {
    public int getValue(int[] gifts, int n) {
        // write code here
       Map<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<gifts.length;i++){
           int c=map.getOrDefault(n,0);
           map.put(gifts[i],c+1);
       }
       int v=0;
       double a=n/2.0;
        for (Map.Entry<Integer,Integer> e :map.entrySet()) {
           if(e.getValue()>a){
               v=e.getKey();
           }
        }
        return v;
    }


}
