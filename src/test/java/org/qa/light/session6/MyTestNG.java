package org.qa.light.session6;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyTestNG {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("------ Before Suite -----");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(">>>>>>>");
    }

    @Test
    public void test1() {
        System.out.println("Hello NG Test! 1.1");
    }

    @Test
    public void test2() {
        System.out.println("Hello NG Test! 1.2");
    }

    @Test
    public void test3() {
        System.out.println("Hello NG Test! 1.3");
    }

    @Test
    public void test4() {
        System.out.println("Hello NG Test! 1.4");
    }

    @Test
    public void test5() {
        System.out.println("Hello NG Test! 1.5");
    }
}
