package org.example;

public class palindrom {

    public static boolean isPalindrome(int num) {
        if (num < 0) return false; // Negative numbers are not palindromes

        int original = num;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return original == reversed;
    }
}