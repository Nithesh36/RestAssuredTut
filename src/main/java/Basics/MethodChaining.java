package Basics;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodChaining {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("apple", "mango");
       // Stream<String> nameStream = names.stream();
        //Stream<String> updatedName = nameStream.map(e -> e + " Fruits");
        System.out.println("new Names:");
        //System.out.println(updatedName.collect(Collectors.toList()));
        // --multiple methods are chained is   method chaining - note below code
        List<String> nameStream = names.stream().map(e -> e + " Fruits").collect(Collectors.toList());
    }
}
