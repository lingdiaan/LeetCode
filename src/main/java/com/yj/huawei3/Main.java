package com.yj.huawei3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class Main {
    private static Map<String, List<Device>> map;
    private static int tail = 0, tailNow = 0;
    private static int head = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        s = scanner.nextLine().trim().split(" ");
        String start = s[0];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine().trim().split(" ");
            List<Device> orDefault = map.getOrDefault(s[0], new ArrayList<>());
            orDefault.add(new Device(s[1], s[2]));
            map.put(s[0], orDefault);
        }
        findHead(start);
        findTail(start);
        System.out.println(head + 1 + tail);
    }
    public static void findTail(String start){
        List<Device> devices = map.get(start);
        for (int i = 0; i < devices.size(); i++) {
            String out = devices.get(i).getOut();
            if (out.equals("null")){
                tail = Math.max(tail, tailNow);
                tailNow--;
                continue;
            }
            tailNow ++;
            findTail(out);
        }
    }

    public static void findHead(String start){
        Device device = map.get(start).get(0);
        String in = device.getIn();
        if(in.equals("null")) return;
        head ++;
        findHead(in);
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Device{
    String in;
    String out;
}
/*
4
d1
d1 d2 d3
d2 null d1
d3 d1 d4
d4 d3 null

8
d3
d1 null d2
d2 d1 d3
d2 d1 d5
d2 d1 d4
d3 d2 null
d4 d2 null
d5 d2 d6
d6 d5 null
*/