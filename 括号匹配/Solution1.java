import java.util.ArrayList;

 class Soluton1{
public boolean isVaild(String S){

        ArrayList<Character> stack=new ArrayList<>();
        for(int i=0;i<S.length();i++){
        char ch=S.charAt(i);
        switch (ch){
        case '(':
        case'{':
        case '[':
        stack.add(ch);
        break;
        case ')':
        case'}':
        case']':
        if(stack.isEmpty()){
        return false;
        }
        char left=stack.remove(stack.size()-1);
        if(!match(left,ch)){
        return false;
        }
        break;
        }
        }
        if(!stack.isEmpty()){
        return false;
        }
        return true;
        }

private boolean match(char left, char ch) {
        if(left=='('&&ch==')'){
        return true;
        }
        if(left=='{'&&ch=='}'){
        return true;
        }
        if(left=='['&&ch==']'){
        return true;
        }
        return false;
        }

public static void main(String[] args) {
        Soluton1 s=new Soluton1();
        String a="()";
        System.out.println(s.isVaild(a));

        }

}

