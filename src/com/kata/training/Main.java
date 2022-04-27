package com.kata.training;

public class Main {

    public static String calc(String input) {
        Calculator calculator = new Calculator();
        return calculator.calc(input);
    }

    public static void main(String[] args) {

//        System.out.println(calc("1 +10"));
//        System.out.println(calc("10 *10"));
        System.out.println(calc("3 - 9+1"));

        System.out.println(calc("X*VI"));
    }
}
