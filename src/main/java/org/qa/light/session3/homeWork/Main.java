package org.qa.light.session3.homeWork;

import org.qa.light.session3.ICar;

public class Main {
    public static void main(String[] args) {
        Android xiaomi = new Android();
        IOS iPhoneAir = new IOS();

        phoneActions(xiaomi,"Garfield");
        System.out.println(" ");
        phoneActions(iPhoneAir,"Mary");
    }
    public static void phoneActions(IPhone phoneType, String contact) {
        phoneType.unlockScreen();
        phoneType.callTo(contact);
        phoneType.blockScreen();
    }
}
