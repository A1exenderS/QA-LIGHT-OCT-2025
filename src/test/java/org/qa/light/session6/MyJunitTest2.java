package org.qa.light.session6;

import org.junit.jupiter.api.*;

public class MyJunitTest2 {

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("before all test 2");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("after all test 2");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("--------------2-----------------");
        System.out.println("Load rozetka.com.ua");
        System.out.println("Open side menu");
        System.out.println("Open shopping cart");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Log out user if possible");
    }

    @Test
    public void myTest1() {
        System.out.println("Do something with it 2.1");
    }

    @Test
    public void myTest2() {
        System.out.println("Do something with it 2.2");
    }

    @Test
    public void myTest3() {
        System.out.println("Do something with it 2.3");
    }
}
