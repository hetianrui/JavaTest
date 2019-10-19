package com.htr.test;
import java.util.ArrayList;
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<>();
        a.add("十步杀一人");
        a.add("千里不留行");
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i));
            }
        System.out.println();
        a.add(1,",");
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i));

        }
        System.out.println();
        System.out.println("逗号所在下标为"+a.indexOf(","));
        a.remove(",");
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i));

        }
        System.out.println();
        System.out.println("0所在下标元素为"+a.get(0));
        if(a.contains("十步杀一人")){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }
        a.set(0,"事了拂衣去");
        a.set(1,"深藏功与名");
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i));

        }

        }
    }


