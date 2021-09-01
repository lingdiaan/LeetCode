package com.yj;

public class Add {
    public static void main(String[] args) {
        int i = 1;
        int c = 1;
        int count = 2;
        int n = 4;
        while(n>1){
            int now = count;

            while (now>0&&n>1) {
                c+=count;
                i += c;
                now--;
                n--;
            }
            count++;
        }
        System.out.println(i);
    }
}
