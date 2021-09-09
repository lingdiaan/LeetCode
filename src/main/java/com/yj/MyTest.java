package com.yj;

public class MyTest {
    public static void main(String[] args) {
        Long a = 1234567799998l;
        System.out.println(a);
        int i = a.intValue();
        get(i);
    }
    public static void get(int n){
        System.out.println(n);
    }
}
