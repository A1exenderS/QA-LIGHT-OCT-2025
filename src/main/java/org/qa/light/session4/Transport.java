package org.qa.light.session4;

public abstract class Transport {

    protected String someString;

    public Transport(String someString) {
        this.someString = someString;
    }

    public abstract void goTo(String destination);

}
