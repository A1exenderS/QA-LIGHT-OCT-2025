package org.qa.light.session3.homeWork;

public class Main {
    public static void main(String[] args) {
        Android xiaomi = new Android();
        IOS iPhoneAir = new IOS();

        xiaomi.unlockScreen();
        xiaomi.callTo("Garfield");
        xiaomi.blockScreen();

        System.out.println(" ");

        iPhoneAir.unlockScreen();
        iPhoneAir.callTo("Eleonore");
        iPhoneAir.blockScreen();
    }
}
