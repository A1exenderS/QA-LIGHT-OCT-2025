package org.qa.light.session5;

import org.qa.light.session4.Boat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: each boat has one or more owners
//TODO: each owner must be unique
//TODO*: print boat names for boats with only one owner
//TODO**: generate boats and owners and boat / owners params automatically and randomly

public class CollectionsDemo {

    public static void main(String[] args) {
        //Bob: boat1, boat2, boat3
        //Bill: boat4, boat5
        Map<String, List<Boat>> ownedBoats = new HashMap<>();
        ownedBoats.put("Bob", new ArrayList<>());
        ownedBoats.put("Bill", new ArrayList<>());

        addBoats(ownedBoats.get("Bill"), 2);
        addBoats(ownedBoats.get("Bob"), 3);

//        setBoatParams(ownedBoats.get("Bob").get(0), "Bob's Boat 1", "red");
//        setBoatParams(ownedBoats.get("Bob").get(1), "Bob's Boat 2", "blue");
//        setBoatParams(ownedBoats.get("Bob").get(2), "Bob's Boat 3", "green");
//
//        setBoatParams(ownedBoats.get("Bill").get(0), "Bill's Boat 1", "yellow");
//        setBoatParams(ownedBoats.get("Bill").get(1), "Bill's Boat 2", "purple");

//        ownedBoats.get("Bob").add(new Boat());
//        ownedBoats.get("Bob").add(new Boat());
//        ownedBoats.get("Bob").add(new Boat());

//        ownedBoats.get("Bill").get(0).name = "Bill's Boat 1";
//        ownedBoats.get("Bill").get(0).color = "yellow";
//
//        ownedBoats.get("Bill").get(1).name = "Bill's Boat 2";
//        ownedBoats.get("Bill").get(1).color = "purple";

        System.out.println(ownedBoats);

//        Map<String, List<String>> map = new HashMap<>();
//        map.put("new users", new ArrayList<>());
//        map.put("yesterday users", new ArrayList<>());
//        map.put("blacklisted users", new ArrayList<>());
//
//        map.get("new users").add("John");
//        map.get("new users").add("Jane");
//        map.get("yesterday users").add("Bob");
//        map.get("yesterday users").add("Bill");
//
//        System.out.println(map.size());
    }

    public static void addBoats(List<Boat> boats, int amount) {
        for (int i = 0; i < amount; i++) {
            Boat boat = new Boat();
            setBoatParams(boat, "Boat " + i, "red");
            boats.add(boat);
        }
    }

    public static void setBoatParams(Boat boat, String name, String color) {
        boat.name = name;
        boat.color = color;
    }

    public static String pickRandomColor() {
        //TODO: pick random color
        return "red";
    }

    public static String pickRandomName(int i) {
        return "random name " + i;
    }
}
