package Basics.RealTime.methodChaining;

public class HomePage {
    public HomePage  findContact(){
        System.out.println("id found for sending message");
        return  this;
    }

    public  HomePage sendMessage(){
        System.out.println("message send with Hi");
        return  this;

    }
}
