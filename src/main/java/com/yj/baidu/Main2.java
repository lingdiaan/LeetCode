package com.yj.baidu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int now = scanner.nextInt();
            StringBuilder s = new StringBuilder(String.valueOf(now));
            for (int j = s.length()-1; j>=0; j--) {
                if(s.charAt(j)-'0'>=4){
                    s.replace(j,j+1, "3");
                }
                if(s.charAt(j) == '0'){
                    s.replace(0, j+1, (Integer.valueOf(s.substring(0,j+1))-1)/10+"3");
                }
            }
            System.out.println(s);
        }
    }
}
