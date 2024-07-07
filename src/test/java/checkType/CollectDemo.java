package checkType;

import java.util.*;

public class CollectDemo {
    public static void main(String[] args) {
        List<String> ls = new LinkedList<>();
        ls.add("name");
        ls.add("kumar");
        ls.add("eshwa");
        ls.add("Radha");
        List<Integer> lint = new LinkedList<>();
        lint.add(1);
        lint.add(12);
        System.out.println(ls.subList(0, 3));
//        Integer a[] = lint.toArray(new Integer[0]);
        // System.out.println(Arrays.toString(l));
       // String[] ad = ls.toArray(new String[ls.size()]);
       // System.out.println(Arrays.toString(ad));
      //  Iterator<String> iterator = ls.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        ListIterator<String> stringListIterator = ls.listIterator();
        while (stringListIterator.hasNext())
            System.out.println(stringListIterator.next());
        System.out.println("previous: ");
        while (stringListIterator.hasPrevious())
            System.out.println(stringListIterator.previous());

    }
}
