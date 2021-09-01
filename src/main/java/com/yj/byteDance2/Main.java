package com.yj.byteDance2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static List<int[]> ans = new ArrayList<>();
    private static int sq;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        sq = n*n;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <= (n-4)*(n-4); i++) {
            digui(i, i, 0, 1);
        }
        System.out.println(ans.size());
    }

    public static void digui(int start, int now, int count, int add){

        if (count == 5){
            ans.add(new int[]{now/n, now%n});
            return ;
        }
        if (now > sq)
            return;
        if(count != 0 && count!=5 && add ==0 && map[now/n][now%n] == 0){
            return;
        }
        if(count == 0){
            if (now+1 < sq)
            digui(now, now+1, 1, 0);
            if (now+n < sq)
            digui(now, now+n, 1, 0);
            if (now+n+1 < sq)
            digui(now, now+n+1, 1, 0);
        }
        else{
            if(now % n == start%n){
                if(add == 1&&map[now/n][now%n] == 0)digui(start, now+n, count+1, 0 );
                if(map[now/n][now%n] == 1) digui(start, now+n, count+1, add );
            }else if(now/n == start/n){
                if(add == 1&&map[now/n][now%n] == 0)digui(start, now+1, count+1, 0 );
                if(map[now/n][now%n] == 1) digui(start, now+1, count+1, add );
            }else {
                if(add == 1&&map[now/n][now%n] == 0)digui(start, now+1, count+1, 0 );
                if(map[now/n][now%n] == 1) digui(start, now+1+n, count+1, add );
            }
        }
    }

}
@Data
@AllArgsConstructor
class Point{
    int x;
    int y;

}