package Basics;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String,Object>tr=new TreeMap<>();
        tr.put("name",null);
        tr.put(null,"s");
        tr.put("age",22);
        tr.put("age",22);
        System.out.println(tr);
        TreeSet<Integer>td=new TreeSet<>();
        td.add(3);
        td.add(1);
        td.add(9);
        System.out.println(td);
    }
}
