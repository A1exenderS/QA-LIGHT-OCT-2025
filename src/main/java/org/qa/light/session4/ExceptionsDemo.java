package org.qa.light.session4;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    public static void main(String[] args) {
        method1("s100000");
        method1(null);
        method1("s100000");
    }

    public static void method1(String s) {
        try {
            method2(s);
        } catch (Exception e) {
            System.out.println("Oops! Something went wrong");
        }
    }

    public static void method2(String s) {
        method3(s);
    }

    public static void method3(String s) {
        method4(s);
    }

    public static void method4(String s) {
        method5(s);
    }

    public static void method5(String s) {
        try {
            System.out.println(s.length());
            FileReader fileReader = new FileReader("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finally!");
        }
    }
}
