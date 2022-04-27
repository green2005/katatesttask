package com.kata.training;

import java.util.Scanner;

public class Main {

    public static String calc(String input) {
        Calculator calculator = new Calculator();
        return calculator.calc(input);
    }

    public static void main(String[] args) {
        //System.out.println(calc("3 - 9"));
        //System.out.println(calc("X*VI"));

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter expression:");
            String expr = scanner.next();
            System.out.println(calc(expr));
            System.out.println("Wanna try again? y/n");
            String response = scanner.next();
            if (!response.equals("y")) {
                break;
            }
        } while (true);
    }
}
