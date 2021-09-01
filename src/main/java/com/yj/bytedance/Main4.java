package com.yj.bytedance;

import java.util.Scanner;

public class Main4 {
    private static int[][][] scores;
    private static int ans,n,m;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().trim().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        s = scanner.nextLine().trim().split(" ");
        int x = Integer.parseInt(s[0]);
        for (int i = 0; i <x ; i++) {
            ans = 0;


            s = scanner.nextLine().trim().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            map[l][r] = 0;
            scores =  new int[m][n][2];
            scores[0][0][1]=scores[0][0][0] = map[0][0]==0?0:1;
            for (int j = 1; j < m; j++) {
                scores[j][0][0] = map[j][0];

                scores[j][0][1] = map[j][0]==0?0:map[j-1][0]+1;
            }
            for (int j = 0; j < n; j++) {
                scores[0][j][1] = map[0][j];
                scores[0][j][1] = map[0][j]  ==0?0:map[0][j-1]+1;
            }
            find(map,1,1,scores);
            System.out.println(ans);
        }
    }
    public static void find(int[][] map,int i,int j,int[][][] scores){
        if(i>m||j>n) return;
        if(map[i][j]==0) scores[i][j][1]=scores[i][j][0]=0;
//        else{
//            if(i>0&&j>0&&map[i-1][j]!=0&&map[i][j-1]!=0&&map[i-1][j-1]!=0)
//                scores[i][j] = Math.max(0,0);
//            else if(i>0&&j>0&&map[i-1][j-1]==0){
////                scores[i][j] = Math.max(map[i-1][j],map[i][j-1])+1;
//            }
//        }

    }
}
