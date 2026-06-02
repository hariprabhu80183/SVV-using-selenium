package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class palindromtest {

    @Test
    void testPalindromeNumberPositive() {
        boolean result = palindrom.isPalindrome(121);
        Assert.assertEquals(result, true, "121 should be palindrome");
    }

    @Test
    void testPalindromeNumberOddDigits() {
        boolean result = palindrom.isPalindrome(12321);
        Assert.assertEquals(result, true, "12321 should be palindrome");
    }

    @Test
    void testNotPalindromeNumber() {
        boolean result = palindrom.isPalindrome(123);
        Assert.assertEquals(result, false, "123 is not a palindrome");
    }

    @Test
    void testSingleDigit() {
        boolean result = palindrom.isPalindrome(7);
        Assert.assertEquals(result, true, "Single digits are palindromes");
    }

    @Test
    void testZero() {
        boolean result = palindrom.isPalindrome(0);
        Assert.assertEquals(result, true, "0 should be a palindrome");
    }

    @Test
    void testNegativeNumber() {
        boolean result = palindrom.isPalindrome(-121);
        Assert.assertEquals(result, false, "Negative numbers are not palindromes");
    }
}