package org.qa.light.session6;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class MyTestNG3 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("------ Before Test -----");
    }

    @Test(dataProvider = "dataProvider")
    public void test(Customer c) {
//        Assert.assertTrue(c.age >= 18, "Age should be greater than 18");
//        Assert.assertTrue(c.email.length() > "@gmail.com".length(), "Email should contain @gmail.com");
//        Assert.assertNotNull(c.name);

        SoftAssert sa = new SoftAssert();
        sa.assertNotNull(c.name);
        sa.assertTrue(c.age >= 18, "Age should be greater than 18");
        sa.assertTrue(c.email.length() > "@gmail.com".length(), "Email should contain @gmail.com");
        sa.assertAll();
    }

    @DataProvider
    public Object[][] dataProvider() {

        return new Object[][]{
                {randomCustomer("abcdefg")},
                {randomCustomer("")},
                {randomCustomer("abcdefg1234567")},
        };
    }

    private Customer randomCustomer(String prefix) {
        Random random = new Random();
        Customer c = new Customer();
        c.name = "test customer";
        c.age = random.nextInt(20) + 1;
        c.email = prefix + "@gmail.com";
        return c;
    }
}
