package org.qa.light.session6;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class MyTestNG2 {

    @AfterSuite
    public void afterSuite() {
        System.out.println("------ After Suite -----");
    }

    @Test
    public void test() {
        System.out.println("Hello NG Test! 2");
    }
}
