package org.example;

import java.util.Scanner;

public class caloperations {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static int modulus(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot perform modulus with zero");
        return a % b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");

        int choice = sc.nextInt();
        int result = 0;

        try {
            switch (choice) {
                case 1:
                    result = add(a, b);
                    break;
                case 2:
                    result = subtract(a, b);
                    break;
                case 3:
                    result = multiply(a, b);
                    break;
                case 4:
                    result = divide(a, b);
                    break;
                case 5:
                    result = modulus(a, b);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
