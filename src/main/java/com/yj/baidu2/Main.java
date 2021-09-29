package com.yj.baidu2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> odd= new ArrayList<>();
            List<Integer> dou= new ArrayList<>();
            for (int l = 0; l < n; l++) {
                int a = scanner.nextInt();
                if (a%2==1) odd.add(a);
                else dou.add(a);
            }
            long ans = 0;
            int douCount = 0;
            if (k%2==1) {
                douCount = dou.size() % 2 == 0 ? dou.size() - 1 : dou.size();
            }
                else douCount = dou.size()%2==0?dou.size():dou.size()-1;

                int oddCount = k-douCount;
                if(oddCount < 0){
                    oddCount=0;
                    douCount=k;
                }
                while(true){
                    if(oddCount>odd.size()||douCount<0)
                        break;
                    ans+= combination(oddCount, odd.size())*combination(douCount, dou.size() );
                    douCount-=2;
                    oddCount+=2;
            }
            System.out.println(ans %1000000008);
        }
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     */
    private static long factorial(int n) {
        long sum = 1;
        while( n > 0 ) {
            sum = sum * n--;
        }
        return sum;
    }

    /**
     * 组合计算公式C<sup>m</sup><sub>n</sub> = n! / (m! * (n - m)!)
     * @param m
     * @param n
     * @return
     */
    public static long combination(int m, int n) {
//        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
        if(m == 0) return 1;
        long ans = 0;
        if(m<=n) ans = factorial(n) / (factorial(m) * factorial((n - m)));
        return ans;
    }

    /**
     * 组合选择（从列表中选择n个组合）
     * @param dataList 待选列表
     * @param n 选择个数
     */
    public static void combinationSelect(String[] dataList, int n) {
        System.out.println(String.format("C(%d, %d) = %d", dataList.length, n, combination(n, dataList.length)));
        combinationSelect(dataList, 0, new String[n], 0);
    }

    /**
     * 组合选择
     * @param dataList 待选列表
     * @param dataIndex 待选开始索引
     * @param resultList 前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

    //    /**
//     * 排列计算公式A = n!/(n - m)!
//     */
//    public static long arrangement(int m, int n) {
//        return m <= n ? factorial(n) / factorial(n - m) : 0;
//    }
//
//    /**
//     * 排列选择（从列表中选择n个排列）
//     * @param dataList 待选列表
//     * @param n 选择个数
//     */
//    public static void arrangementSelect(String[] dataList, int n) {
//        System.out.println(String.format("A(%d, %d) = %d", dataList.length, n, arrangement(n, dataList.length)));
//        arrangementSelect(dataList, new String[n], 0);
//    }
//
//    /**
//     * 排列选择
//     * @param dataList 待选列表
//     * @param resultList 前面（resultIndex-1）个的排列结果
//     * @param resultIndex 选择索引，从0开始
//     */
//    private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {
//        int resultLen = resultList.length;
//        if(resultIndex >= resultLen) { // 全部选择完时，输出排列结果
//            System.out.println(Arrays.asList(resultList));
//            return;
//        }
//
//        // 递归选择下一个
//        for(int i = 0; i < dataList.length; i++) {
//            // 判断待选项是否存在于排列结果中
//            boolean exists = false;
//            for (int j = 0; j < resultIndex; j++) {
//                if (dataList[i].equals(resultList[j])) {
//                    exists = true;
//                    break;
//                }
//            }
//            if (!exists) { // 排列结果不存在该项，才可选择
//                resultList[resultIndex] = dataList[i];
//                arrangementSelect(dataList, resultList, resultIndex + 1);
//            }
//        }
//    }
}
