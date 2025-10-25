package org.qa.light.session6.homeWork;

import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HomeWorkMain {
    static Faker faker = new Faker();
    static int amoutOfBoats = new Random().nextInt(10);

    public static void main(String[] args) {

        System.out.println((printBoatWithOneOwner(amoutOfBoats)));
    }

    public static String generateBoatName() {
        String name = faker.gameOfThrones().dragon();
        return name;
    }

    public static Owner generateOwnerName() {
        String name = faker.gameOfThrones().character();
        return new Owner(name);
    }

    public static NewBoat createBoat() {

        String boatName = generateBoatName();

        int numberOfOwners = new Random().nextInt(5) + 1;
        Set<Owner> owners = new HashSet<>();

        for (int i = 0; i < numberOfOwners; i++) {
            owners.add(generateOwnerName());
        }
        return new NewBoat(boatName, owners);
    }

    public static Set<NewBoat> printBoatWithOneOwner(int amountOfBoats) {
        Set<NewBoat> squadronOfBoats = new HashSet<>();
        for (int i = 0; i < amountOfBoats; i++) {
            System.out.println("------------------------------");
            NewBoat boat = createBoat();
            System.out.println(boat);
            if (boat.owners.size() == 1) {
                squadronOfBoats.add(boat);
            }
        }
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Finally, list of boats with only one owner");
        return squadronOfBoats;
    }
}
