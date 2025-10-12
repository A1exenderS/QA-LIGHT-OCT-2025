package org.qa.light.session4;

//TODO: Add model name and color to Android and IOS classes
//TODO: add equals and hashcode methods.
//TODO: create android/ios with null model and/or hascode,
// and try to handle exceptions if they appear

public class Boat {

    public String color;
    public String name;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Boat) {
            Boat b = (Boat) obj;
            return this.color.equals(b.color) && this.name.equals(b.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (name + color).hashCode();
    }
}
