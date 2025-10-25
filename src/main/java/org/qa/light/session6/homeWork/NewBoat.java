package org.qa.light.session6.homeWork;

import java.util.Set;

public class NewBoat {

    public String name;
    public Set<Owner> owners;

    public NewBoat(String name, Set<Owner> owners) {
        this.name = name;
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Boat - " + name + " is owned by " + owners;
    }

}
