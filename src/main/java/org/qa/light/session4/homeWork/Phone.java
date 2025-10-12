package org.qa.light.session4.homeWork;

//TODO: Add model name and color to Android and IOS classes
//TODO: add equals and hashcode methods.
//TODO: create android/ios with null model and/or hashcode,
// and try to handle exceptions if they appear

public class Phone {

    protected String modelName;
    protected String color;

    public Phone(String modelName, String color) {
        this.modelName = modelName;
        this.color = color;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Phone p) {
            return this.modelName.equals(p.modelName) && this.color.equals(p.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (modelName + color).hashCode();
    }
}
