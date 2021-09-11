package com.yj.huawei2;

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Map<Integer, Integer> map = new TreeMap<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int count = scanner.nextInt();
//            int num = scanner.nextInt();
//            map.put(num, count);
//            list.add(count);
//        }
//        n = scanner.nextInt();
//        List<Integer> cost = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            cost.add(scanner.nextInt());
//        }
//        cost.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        int pos = 0;
//        for (int i = 0; i < cost.size(); i++) {
//            int come = cost.get(i);
//            for (int j : map.keySet()) {
//                if (j >= come){
//                    if(j-come!=0)
//                    map.put(j-come, map.getOrDefault(j-come, 0)+1);
//                    if (map.get(j) == 1){
//                        map.remove(j);
//                    }else{
//                        map.put(j, map.get(j)-1);
//                    }
//                    break;
//                }
//            }
//        }
//        int ans = 0;
//        for (int j:map.keySet()){
//            ans+= j *map.get(j);
//        }
//        System.out.println(ans);
//
//    }
//}

public class Main {
    public static int combine(List<String[]> list,int i,int sum) {
        sum+=Integer.parseInt(list.get(i)[1]);
        if(list.get(i).length==2){
            return sum;
        }
        int k=list.get(i).length;
        int max = 0;
        for(int j=2;j<k;j++){
            int res=combine(list,Integer.parseInt(list.get(i)[j]),sum);
            if(res>max){
                max=res;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=Integer.parseInt(scanner.nextLine());
        List<String[]> list=new ArrayList();
        for(int i=0;i<N;i++){
            String temp= scanner.nextLine();
            String[] strings=temp.split(" ");
            list.add(strings);
        }
        int res=combine(list,0,0);
        System.out.println(res);
        return;
    }
}
