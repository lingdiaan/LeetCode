package com.yj.huawei;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
public class Main {
    private static long ans;
    private static Set<String> set;
    private  static Map<String, Node> map;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        set = new HashSet<>();
        String first = scanner.nextLine().trim();
        map = new HashMap<>();
//        while(scanner.hasNextLine()){
        for (int j = 0; j < 4; j++) {
            String[] s = scanner.nextLine().trim().split(",");
            List<String> list = null;
            if (s.length>2){
            list = new ArrayList<>();
                for (int i = 2; i < s.length; i++) {
                    list.add(s[i]);
                }
            }
            map.put(s[0], new Node(s[0],Integer.valueOf(s[1]),list));
        }
        ans = 0;
        Node node = map.get(first);
        ans+=node.getTime();
        List<String> son = node.getSon();
        digui(son);
        System.out.println(ans);
    }

    public static void digui(List<String> son){
        if(son == null)return;
        Iterator<String> iterator = son.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            Node node1 = map.get(next);
            if(!set.contains(node1.getName())){
            ans += node1.getTime();
            set.add(node1.getName());
            if(node1.getSon()!=null){
                digui(node1.getSon());
            }

        }}
    }
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Node {
    String name;
    int time;
    List<String> son;
}


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
//
//    public List<String> getSon() {
//        return son;
//    }
//
//    public void setSon(List<String> son) {
//        this.son = son;
//    }
//
//    public Node(String name, int time, List<String> son) {
//        this.name = name;
//        this.time = time;
//        this.son = son;
//    }
//
//    public Node(String name, int time){
//        this.name = name;
//        this.time = time;
//    }

