package org.qa.light.session4.homeWork;

public class homeWorkMain {

    public static void main(String[] args) {

        Phone xiaomi = new Android("Samsung Galaxy S25 Ulta", "black");

        Phone iPhone = new IOS("IPhone 17 Pro Max", "black");
        Phone iPhone2 = new IOS("IPhone 17 Pro Max", null);

        System.out.println(xiaomi.modelName.equals(iPhone.modelName));
        System.out.println(xiaomi.color.equals(iPhone2.color));
        System.out.println(xiaomi.hashCode());
        System.out.println(iPhone.hashCode());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");
        checkException(xiaomi, iPhone);
        System.out.println("----------------------");
        checkException(iPhone, iPhone2);
        System.out.println("----------------------");
        checkException(iPhone2, iPhone);

//        getHashWithNullModelName(iPhone2);
//        getHashWithNullModelName(iPhone);
//        getHashWithNullModelName(xiaomi);
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

    public static void checkException(Phone phone, Phone phone1) {
        try {
            System.out.println("Say, the model is the same?    ..    " + phone.modelName.equals(phone1.modelName));

        } catch (Exception e) {
            System.out.println("One of the phones has NULL model name");
        }

        try {
            System.out.println("Say, the color is the same?    ..    " + phone.color.equals(phone1.color));
        } catch (Exception e) {
            System.out.println("One of the phones has NULL color");
        }
    }
}
