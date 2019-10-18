package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        try {
            System.out.println("RPN input : ");
            String input = userInput.nextLine();
            System.out.println("Result of " + input + " is " + ReversePolishNotation.getResult(input));
            userInput.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
