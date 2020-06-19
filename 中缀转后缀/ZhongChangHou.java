package TestCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZhongChangHou {
    public static int  Compare(String s){
        int res=0;
        switch (s){
            case "+":
                res=1;
                break;
            case "-":
                res=1;
                break;
            case "*":
                res=2;
                break;
            case "/":
                res=2;
                break;

        }
        return res;
    }
    public static List<String> change(String[] a){
        Stack<String> stack = new Stack<>();//字符栈
        List<String> list = new ArrayList<>();//数字栈
        for (String s : a) {
            if (s.matches("[+-]?\\d+")) {
                list.add(s);
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                while (!(stack.size() == 0 || stack.peek().equals("(") || Compare(s) > Compare(stack.peek()))) {
                    list.add(stack.pop());
                }
                stack.push(s);
            } else if (s.equals(")")) {
                while (true) {
                    list.add(stack.pop());
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        break;
                    }
                }
            } else if (s.equals("(")) {
                stack.push(s);
            }
        }
        while (stack.size() != 0) {
            list.add(stack.pop());
        }
        return list;
    }
}
