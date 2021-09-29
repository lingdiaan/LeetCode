package com.yj.baidu2;

public class B extends A{
    private String name ="B";
    B(){
        show();
    }
    public void show(){
        System.out.println("B"+name);
    }

    public static void main(String[] args) {
        new B();
    }
}
