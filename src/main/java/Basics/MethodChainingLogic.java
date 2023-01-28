package Basics;

public class MethodChainingLogic {
public  MethodChainingLogic returnObject(){
    System.out.println("i am return Object for chaining");
    return  this;
}
public  MethodChainingLogic returnChainedMethod(){
    System.out.println("i am  returnChainedMethod");
    return  this;
}

    public static void main(String[] args) {
      new MethodChainingLogic().returnObject().returnChainedMethod();
    }

}
