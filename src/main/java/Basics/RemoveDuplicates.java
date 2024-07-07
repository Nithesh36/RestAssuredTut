package Basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
  static  ArrayList<Integer> num;

    public static void usingSetFetchUnique(){

        HashSet<Integer>duplicates=new HashSet<>();
        for(int i=0;i<num.size();i++){
            if(!duplicates.add(num.get(i))){
                num.remove(num.get(i));
            }
            else
                num.add(num.get(i));
        }
        System.out.println(num  );
    }
    public static void main(String[] args) {
        num = new ArrayList<Integer>(List.of(1, 34, 5, 34, 7,1, 7, 8 ,34,9,5));
       /* for (int i = 0; i < num.size(); i++) {
            if (num.indexOf(num.get(i)) != num.lastIndexOf(num.get(i))) {
                System.out.println("debug: ");
                System.out.println(num.get(i));
                int finalI = i;
                num.removeIf(n -> n.equals(num.get(finalI))); //iteration
                i--;

            }

        }*/
       usingSetFetchUnique();
    }
}
