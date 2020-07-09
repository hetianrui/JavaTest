import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack s1=new Stack();
        if(chars.length==0){
            return true;
        }
        for(int i=0;i<chars.length;i++){

            if(chars[i]=='(' || chars[i]=='{' ||chars[i]=='['){
                s1.add(chars[i]);
            }else if(chars[i]==')' || chars[i]=='}' ||chars[i]==']'){
                if(s1.empty()){
                    return false;
                }
                char temp=(char) s1.pop();
                if( (temp=='(' && chars[i]==')') ||
                        (temp=='{' && chars[i]=='}') ||
                        (temp=='[' && chars[i]==']') ){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if( s1.size() == chars.length ){
            return false;
        }
        if(s1.isEmpty()){
            return true;
        }
        return false;

    }


}
