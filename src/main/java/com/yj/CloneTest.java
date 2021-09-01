package com.yj;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        ArrayList<Integer> integers = objects;
        integers.set(2,4);
        for (int i = 0; i < 3; i++) {
            System.out.println(integers.get(i));
            System.out.println(objects.get(i));
        }
        Object clone = objects.clone();
        System.out.println(clone);
        System.out.println(clone.getClass());
        ArrayList clone1 = (ArrayList) clone;
        clone1.set(2,5);
        for (int i = 0; i < clone1.size(); i++) {
            System.out.println(objects.get(i));

            System.out.println(clone1.get(i));
        }
    }
}
