package Basics.RealTime.methodChaining;
 import Basics.RealTime.methodChaining.HomePage;
public class LoginPage  {
    public HomePage LoginButton(){
        System.out.println("logon success");
        return   new HomePage();
    }
}
