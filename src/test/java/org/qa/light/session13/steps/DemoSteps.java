package org.qa.light.session13.steps;

import io.cucumber.java.en.Given;
import org.qa.light.session12.AgentActions;

public class DemoSteps {

    @Given("Print this number {int}")
    public void printThisNumber(int number) {
        System.out.println(number);
    }

    @Given("Print this string {string}")
    public void printThisString(String string) {
        System.out.println(string);
    }

    @Given("Support agent executes {}")
    public void supportAgentExecutes(AgentActions actions) {
        switch (actions) {
            case UPDATE_USER_DATA:
                System.out.println("Agent updates user data");
                break;
            case DELETE_USER_DATA:
                System.out.println("Agent deletes user data");
                break;
            case REGISTER_NEW_USER_DATA:
                System.out.println("Agent registers new user data");
                break;
        }
    }
}
