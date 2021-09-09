package com.yj.baidu;

import java.util.*;

public class Main {
    private static List<Integer> values;
    private static long count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().trim().split(" ") ;
        int n = Integer.valueOf(nums[0]);
        int k = Integer.valueOf(nums[1]);
        char[] ss = scanner.nextLine().trim().toCharArray();


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            int now = map.get(ss[i])==null?0:map.get(ss[i]);
            map.put(ss[i], now+1);
        }
        if(map.size() <k)
            System.out.println(0);
        count = map.size()==k?1:0;
        values = new ArrayList<>(map.values());
        for (int i = 0; i < ss.length-k; i++) {
            digui(i, k-1, values.get(i));
        }

    }
    public static void digui(int start, int k ,int sum){
        if(start>values.size()) return;
        if(k==0){
            count+=sum;
            System.out.println(count);
            return ;
        }
        for (int i = start+1; i < values.size()-k; i++) {
            digui(i, k-1, sum*values.get(i));
        }



    }
}
