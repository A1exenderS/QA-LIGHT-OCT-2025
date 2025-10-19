package org.qa.light.session6;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

public class MyJunitTest {

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("before all test");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("after all test");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("-------------------------------");
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
        System.out.println("Do something with it 1");
    }

    @Test
    public void myTest2() {
        System.out.println("Do something with it 2");
    }

    //password requirements:
    //- at least 8 chars
    //- at least 1 number
    //- at least 1 spec symbol
    //- at least 1 capital letter
    //abcdeF1!
    //abceF1!
    //abcdef1!
    //abcdeFg!
    //abcdeF12
    @ParameterizedTest
//    @ValueSource(strings = {"abceF1!", "abcdef1!", "abcdeFg!", "abcdeF12"})
//    @EnumSource(SomeValues.class)
    @MethodSource("argumentsStream")
    public void myTest3(String input, int value) {
        System.out.println("Validating " + input);
        Assertions.assertTrue(value >= 30,
                "Expected value >= 30 but got " + value);
    }

    public static Stream<Arguments> argumentsStream() {
        Random random = new Random();
        String value2 = "expected value ";
        return Stream.of(
                Arguments.of("abceF1!", random.nextInt(100), 1982734897),
                Arguments.of("abcdef1!", random.nextInt(100)),
                Arguments.of("abcdeFg!", random.nextInt(100)),
                Arguments.of("abcdeF12", random.nextInt(100))
        );
    }
}
