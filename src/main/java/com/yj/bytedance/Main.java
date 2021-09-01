package com.yj.bytedance;

import com.sun.xml.internal.ws.util.StringUtils;
import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 第二题
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(a[0]);
        int q = Integer.parseInt(a[1]);
        StringBuilder sb = new StringBuilder();
            sb.append(scanner.nextLine());
        for (int i = 0; i < q   ; i++) {
            a = scanner.nextLine().trim().split(" ");
        int l = Integer.parseInt(a[0]);;
        int r = Integer.parseInt(a[1]);;


            for (int j = l-1; j <= r; j++) {
                sb.setCharAt(j,sb.charAt(j)=='0'?'1':'0');
            }
        }
        System.out.println(sb.toString());
//        char[] c = {'a','b','c'};
//        String s = new String(c);
//        System.out.println(s);



    }

}
