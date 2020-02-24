package TestCode;

import java.util.Stack;

public class NiBolan {
   //逆波兰表达式求值
        public static int evalRPN(String[] tokens) {
            Stack<String> stack=new Stack<>();
            for(String s:tokens){
                if(s.matches("\\d+")){
                    stack.add(s);
                }else if(s.equals("+")){
                    int a=Integer.parseInt(stack.pop());
                    int b=Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(a+b));
                }else if(s.equals("-")){
                    int a=Integer.parseInt(stack.pop());
                    int b=Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(b-a));
                }else if(s.equals("*")){
                    int a=Integer.parseInt(stack.pop());
                    int b=Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(b*a));
                }else if(s.equals("/")){
                    int a=Integer.parseInt(stack.pop());
                    int b=Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(b/a));
                }
            }
            return Integer.parseInt(stack.pop());
        }
}
