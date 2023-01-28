package Basics.RealTime.methodChaining;

public class FacebookScript {
    public static void main(String[] args) {
        new LoginPage().LoginButton().findContact().sendMessage();
    }
}
