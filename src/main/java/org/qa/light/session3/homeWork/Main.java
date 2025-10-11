package org.qa.light.session3.homeWork;

import org.qa.light.session3.ICar;

public class Main {
    public static void main(String[] args) {
        Android xiaomi = new Android();
        IOS iPhoneAir = new IOS();

        phonesActions(xiaomi,"Garfield");
        System.out.println(" ");
        phonesActions(iPhoneAir,"Mary");
    }
    public static void phonesActions(IPhone phoneType, String contact) {
        phoneType.unlockScreen();
        phoneType.callTo(contact);
        phoneType.blockScreen();
    }
}
