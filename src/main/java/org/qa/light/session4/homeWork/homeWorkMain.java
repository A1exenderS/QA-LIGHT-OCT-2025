package org.qa.light.session4.homeWork;

public class homeWorkMain {

    public static void main(String[] args) {

        Phone xiaomi = new Android("Samsung Galaxy S25 Ulta", "black");

        Phone iPhone = new IOS("IPhone 17 Pro Max", "black");
        Phone iPhone2 = new IOS(null, "black");

        System.out.println(xiaomi.modelName.equals(iPhone2.modelName));
        System.out.println(xiaomi.color.equals(iPhone2.color));
        System.out.println(xiaomi.hashCode());
        System.out.println(iPhone.hashCode());
        getHashWithNullModelName(iPhone2);
        getHashWithNullModelName(iPhone);
        getHashWithNullModelName(xiaomi);
    }

    public static void getHashWithNullModelName(Phone phone) {
        try {
            phone.hashCode();
            System.out.println("Hashcode is " + phone.hashCode());
        } catch (Exception e) {

            // works only if model and color == null, if one of them exists - hash also exists
            System.out.println("The phone model is Null - fix it!");
        }
    }
}
