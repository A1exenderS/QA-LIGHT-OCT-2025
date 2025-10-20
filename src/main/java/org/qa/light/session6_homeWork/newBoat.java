package org.qa.light.session6_homeWork;

import java.util.Set;

public class newBoat {

    public String name;
    public Set<Owner> owners;

    public newBoat(String name, Set<Owner> owners) {
        this.name = name;
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Boat - " + name + " is owned by " + owners;
    }

}
