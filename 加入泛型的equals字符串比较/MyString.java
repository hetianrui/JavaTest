package com.hello;

import java.util.HashMap;

public class MyString<T> {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public boolean equles(Object obj) {
        if (obj == null) {
            return false;
        }

        //返回obj对象能否被MyString类型的引用指向
        //obj对象的类型是不是MyString类型的小类型
        if (!(obj instanceof MyString)) {
            return false;
        }
        MyString other = (MyString) obj;
        return this.name == other.name;
    }

    public String value() {
        return null;
    }
}
    /*public String toUpper() {
     MyString s1=new MyString();
    }
}



public class Main {
    public static void main(String[] args) {

    }
}
}*/
