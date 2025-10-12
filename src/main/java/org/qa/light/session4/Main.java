package org.qa.light.session4;

public class Main {

    public static final String s = "abcdefg";
    public static final Boat b = new Boat();

    public static void main(String[] args) {
        Boat boat1 = new Boat();
        Boat boat2 = new Boat();
        boat1.color = "red";
        boat1.name = "1";
        boat2.color = "red";
        boat2.name = "2";
        System.out.println(boat1.equals(boat2));
        System.out.println(boat1.hashCode());
        System.out.println(boat2.hashCode());
        b.name = "test";
        b.color = "blue";
    }

}
