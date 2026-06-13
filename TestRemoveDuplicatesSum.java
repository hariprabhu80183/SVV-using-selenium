package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRemoveDuplicatesSum {

    @Test
    void testWithDuplicates() {
        int[] input = {1, 2, 2, 3, 1};
        int result = RemoveDuplicatesSum.sumWithoutDuplicates(input);
        Assert.assertEquals(result, 6, "Sum should be 6 after removing duplicates");
    }

    @Test
    void testAllUnique() {
        int[] input = {4, 5, 6};
        int result = RemoveDuplicatesSum.sumWithoutDuplicates(input);
        Assert.assertEquals(result, 15, "All unique, sum should be 15");
    }

    @Test
    void testAllDuplicates() {
        int[] input = {7, 7, 7};
        int result = RemoveDuplicatesSum.sumWithoutDuplicates(input);
        Assert.assertEquals(result, 7, "Only first 7 should count");
    }

    @Test
    void testEmptyArray() {
        int[] input = {};
        int result = RemoveDuplicatesSum.sumWithoutDuplicates(input);
        Assert.assertEquals(result, 0, "Empty array should return 0");
    }

    @Test
    void testWithNegativeNumbers() {
        int[] input = {-1, -2, -2, -3, -1};
        int result = RemoveDuplicatesSum.sumWithoutDuplicates(input);
        Assert.assertEquals(result, -6, "Sum should handle negatives correctly");
    }
}